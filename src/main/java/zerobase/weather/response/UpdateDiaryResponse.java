package zerobase.weather.response;

import lombok.*;
import zerobase.weather.dto.UpdateDiaryLogDTO;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDiaryResponse {

    private long id;
    private String beforeContents;
    private String afterContents;
    private LocalDateTime updateAt;
    private long diaryId;

    public static UpdateDiaryResponse from(UpdateDiaryLogDTO updateDiaryLogDTO) {

        return UpdateDiaryResponse.builder()
                .id(updateDiaryLogDTO.getId())
                .beforeContents(updateDiaryLogDTO.getBeforeContents())
                .afterContents(updateDiaryLogDTO.getAfterContents())
                .updateAt(updateDiaryLogDTO.getUpdateAt())
                .diaryId(updateDiaryLogDTO.getDiaryId())
                .build();
    }
}
