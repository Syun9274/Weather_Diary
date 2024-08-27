package zerobase.weather.dto;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDate;

public class CreateDiary {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Request {

        @NotNull
        private LocalDate writeAt;

        private String contents;
    }

    public static class Response {

    }
}
