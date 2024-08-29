package zerobase.weather.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

public class ReadDiaryRequest {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SingleDayRequest {

        @NotNull
        private LocalDate writeDate;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MultiDayRequest {

        @NotNull
        private LocalDate startDate;

        @NotNull
        private LocalDate endDate;
    }
}
