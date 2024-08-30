package zerobase.weather.dto;

import lombok.*;
import zerobase.weather.entity.UpdateDiaryLog;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateDiaryLogDTO {

    private long id;
    private String beforeContents;
    private String afterContents;
    private LocalDateTime updateAt;
    private long diaryId;

    public static UpdateDiaryLogDTO fromEntity(UpdateDiaryLog diaryUpdateLog) {

        return UpdateDiaryLogDTO.builder()
                .id(diaryUpdateLog.getId())
                .beforeContents(diaryUpdateLog.getBeforeContents())
                .afterContents(diaryUpdateLog.getAfterContents())
                .updateAt(diaryUpdateLog.getUpdateAt())
                .build();
    }

}
