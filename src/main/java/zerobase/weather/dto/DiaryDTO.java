package zerobase.weather.dto;

import lombok.*;
import zerobase.weather.entity.Diary;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryDTO {

    private long id;

    private LocalDate writeAt;
    private String contents;

    private WeatherDTO weatherDTO;

    public static DiaryDTO fromEntity(Diary diary) {

        return DiaryDTO.builder()
                .id(diary.getId())
                .writeAt(diary.getWriteAt())
                .contents(diary.getContents())
                .weatherDTO(WeatherDTO.fromEntity(diary.getWeather()))
                .build();
    }
}
