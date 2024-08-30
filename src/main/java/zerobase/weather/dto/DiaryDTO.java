package zerobase.weather.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import zerobase.weather.entity.Diary;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DiaryDTO {

    private long id;

    private LocalDate writeAt;
    private LocalDateTime updateAt;
    private String contents;

    private WeatherDTO weatherDTO;

    public static DiaryDTO fromEntity(Diary diary) {

        return DiaryDTO.builder()
                .id(diary.getId())
                .writeAt(diary.getWriteAt())
                .updateAt(diary.getUpdateAt())
                .contents(diary.getContents())
                .weatherDTO(WeatherDTO.fromEntity(diary.getWeather()))
                .build();
    }

    public static DiaryDTO fromEntityList(Diary diary) {
        return DiaryDTO.builder()
                .id(diary.getId())
                .writeAt(diary.getWriteAt())
                .contents(diary.getContents())
                .build();
    }
}
