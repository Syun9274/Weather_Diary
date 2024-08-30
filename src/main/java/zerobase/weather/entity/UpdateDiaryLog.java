package zerobase.weather.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "diary_update_log")
@EntityListeners(AuditingEntityListener.class)
public class UpdateDiaryLog extends BaseEntity {

    private String beforeContents;

    private String afterContents;

    @CreatedDate
    private LocalDateTime updateAt;

    private long diaryId;
}
