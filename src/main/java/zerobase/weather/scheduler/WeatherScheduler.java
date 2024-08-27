package zerobase.weather.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import zerobase.weather.service.WeatherService;

@Component
@RequiredArgsConstructor
public class WeatherScheduler {

    private final WeatherService weatherService;

    // 오전 1시에 날씨 정보 업데이트
    @Scheduled(cron = "0 0 1 * * ?")
    public void fetchWeatherData() {
        String cityName = "Seoul"; // default = Seoul

        weatherService.saveWeather(cityName);
    }
}
