package zerobase.weather.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import org.springframework.stereotype.Service;
import zerobase.weather.entity.Rain;
import zerobase.weather.entity.Snow;
import zerobase.weather.entity.Weather;
import zerobase.weather.exception.ApiException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

import static zerobase.weather.enums.ErrorCode.*;

@Setter
@Service
public class ApiService {

    private final ObjectMapper objectMapper = new ObjectMapper();
    private String cityName;

    // API KEY
    private String getApiKey() {
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                getClass().getResourceAsStream(
                                        "/secret/OpenAPI_Key.txt"))))) {

            return br.readLine();
        } catch (Exception e) {
            throw new ApiException(CANT_GET_API_KEY);
        }
    }

    // API 호출로 데이터 받기
    public Weather callApi() {

        String API_KEY = getApiKey();
        String BASE_URL = "https://api.openweathermap.org/data/2.5/weather";

        String url = BASE_URL +
                "?q=" + cityName +
                "&appid=" + API_KEY +
                "&units=metric";

        try {
            HttpURLConnection connection =
                    (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder data = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    data.append(inputLine);
                }
                in.close();

                return parseWeatherData(data.toString());
            } else {
                throw new ApiException(ERROR_API_RESPONSE);
            }

        } catch (IOException e) {
            throw new ApiException(ERROR_API_RESPONSE);
        }
    }

    // JSON에서 날씨 정보 추출 후 Weather형태로 build
    private Weather parseWeatherData(String jsonData) {

        try {
            JsonNode root = objectMapper.readTree(jsonData);

            Weather weather = Weather.builder()
                    .lon(root.path("coord").path("lon").asDouble())
                    .lat(root.path("coord").path("lat").asDouble())
                    .weatherId(root.path("weather").get(0).path("id").asInt())
                    .weatherMain(root.path("weather").get(0).path("main").asText())
                    .description(root.path("weather").get(0).path("description").asText())
                    .temp(root.path("main").path("temp").asDouble())
                    .feelsLike(root.path("main").path("feels_like").asDouble())
                    .tempMin(root.path("main").path("temp_min").asDouble())
                    .tempMax(root.path("main").path("temp_max").asDouble())
                    .pressure(root.path("main").path("pressure").asInt())
                    .humidity(root.path("main").path("humidity").asInt())
                    .seaLevel(root.path("main").path("sea_level").asInt())
                    .grndLevel(root.path("main").path("grnd_level").asInt())
                    .visibility(root.path("visibility").asInt())
                    .windSpeed(root.path("wind").path("speed").asDouble())
                    .windDeg(root.path("wind").path("deg").asInt())
                    .cloudsAll(root.path("clouds").path("all").asInt())
                    .sysType(root.path("sys").path("type").asInt())
                    .sysId(root.path("sys").path("id").asInt())
                    .country(root.path("sys").path("country").asText())
                    .sunrise(convertUnixTimestampToLocalDateTime(root.path("sys").path("sunrise").asLong()))
                    .sunset(convertUnixTimestampToLocalDateTime(root.path("sys").path("sunset").asLong()))
                    .timezone(root.path("timezone").asInt())
                    .cityName(root.path("name").asText())
                    .build();

            // Rain과 Snow는 데이터가 있을 때만 처리
            if (root.has("rain")) {
                Rain rain = Rain.builder()
                        .oneHour(root.path("rain").path("1h").asDouble(0.0))
                        .threeHours(root.path("rain").path("3h").asDouble(0.0))
                        .build();
                weather.setRain(rain);
            }

            if (root.has("snow")) {
                Snow snow = Snow.builder()
                        .oneHour(root.path("snow").path("1h").asDouble(0.0))
                        .threeHours(root.path("snow").path("3h").asDouble(0.0))
                        .build();
                weather.setSnow(snow);
            }

            return weather;

        } catch (Exception e) {
            throw new ApiException(PARSE_FAIL_JSON);
        }
    }

    private LocalDateTime convertUnixTimestampToLocalDateTime(long timestamp) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(timestamp),
                ZoneId.of("UTC"));
    }

}
