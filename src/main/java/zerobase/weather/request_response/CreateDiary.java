package zerobase.weather.request_response;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class CreateDiary {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {

        @NotNull
        private LocalDate writeAt;

        @NotNull
        private String cityName;

        private String contents;
    }

    public static class Response {

    }
}
