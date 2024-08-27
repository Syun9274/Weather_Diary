package zerobase.weather.dto;

import lombok.Data;

public class CallWeather {

    @Data
    public static class Request {

        private String cityName;
    }

}
