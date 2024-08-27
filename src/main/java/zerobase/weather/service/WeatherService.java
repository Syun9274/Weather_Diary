package zerobase.weather.service;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import zerobase.weather.dto.WeatherDTO;
import zerobase.weather.entity.Weather;
import zerobase.weather.repository.WeatherRepository;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;

    private final ApiService apiService;

    @Transactional
    public WeatherDTO saveWeather(String cityName) {

        apiService.setCityName(cityName);
        Weather weather = apiService.callApi();

        return WeatherDTO.fromEntity(
                weatherRepository.save(weather));
    }
}
