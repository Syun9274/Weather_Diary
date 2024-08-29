package zerobase.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zerobase.weather.request.CallWeatherRequest;
import zerobase.weather.dto.WeatherDTO;
import zerobase.weather.service.WeatherService;

@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @PostMapping("/callWeatherAPI")
    public ResponseEntity<WeatherDTO> callWeatherAPI(
            @RequestBody CallWeatherRequest request) {

        WeatherDTO weatherDTO = weatherService.saveWeather(request.getCityName());
        return ResponseEntity.status(HttpStatus.CREATED).body(weatherDTO);
    }
}
