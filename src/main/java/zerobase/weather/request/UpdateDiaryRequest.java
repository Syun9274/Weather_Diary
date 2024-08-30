package zerobase.weather.request;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class UpdateDiaryRequest {

    @NotNull
    private LocalDate writeAt;

    @NotNull
    private String contents;
}
