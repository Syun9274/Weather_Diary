package zerobase.weather.dto;

import lombok.*;
import zerobase.weather.entity.Weather;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherDTO {

    private long id;

    private double lon;
    private double lat;

    private int weatherId;
    private String weatherMain;
    private String description;

    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMax;
    private int pressure;
    private int humidity;
    private int seaLevel;
    private int grndLevel;

    private int visibility;

    private double windSpeed;
    private int windDeg;

    private int cloudsAll;

    private int sysType;
    private int sysId;
    private String country;
    private LocalDateTime sunrise;
    private LocalDateTime sunset;

    private int timezone;
    private String cityName;

    private RainDTO rain;
    private SnowDTO snow;


    public static WeatherDTO fromEntity(Weather weather) {

        return WeatherDTO.builder()
                .id(weather.getId())
                .lon(weather.getLon())
                .lat(weather.getLat())
                .weatherId(weather.getWeatherId())
                .weatherMain(weather.getWeatherMain())
                .description(weather.getDescription())
                .temp(weather.getTemp())
                .feelsLike(weather.getFeelsLike())
                .tempMin(weather.getTempMin())
                .tempMax(weather.getTempMax())
                .pressure(weather.getPressure())
                .humidity(weather.getHumidity())
                .seaLevel(weather.getSeaLevel())
                .grndLevel(weather.getGrndLevel())
                .visibility(weather.getVisibility())
                .windSpeed(weather.getWindSpeed())
                .windDeg(weather.getWindDeg())
                .rain(RainDTO.fromEntity(weather.getRain()))
                .snow(SnowDTO.fromEntity(weather.getSnow()))
                .cloudsAll(weather.getCloudsAll())
                .sysType(weather.getSysType())
                .sysId(weather.getSysId())
                .country(weather.getCountry())
                .sunrise(weather.getSunrise())
                .sunset(weather.getSunset())
                .timezone(weather.getTimezone())
                .cityName(weather.getCityName())
                .build();
    }

}
