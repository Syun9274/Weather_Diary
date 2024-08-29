package zerobase.weather.response;

import lombok.*;
import zerobase.weather.dto.DiaryDTO;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateDiaryResponse {

    private long id;
    private LocalDate writeAt;
    private String contents;
    private long weatherId;

    public static CreateDiaryResponse from(DiaryDTO diaryDTO) {

        return CreateDiaryResponse.builder()
                .id(diaryDTO.getId())
                .writeAt(diaryDTO.getWriteAt())
                .contents(diaryDTO.getContents())
                .weatherId(diaryDTO.getWeatherDTO().getId())
                .build();
    }
}