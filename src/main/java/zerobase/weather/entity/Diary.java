package zerobase.weather.entity;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "diary")
public class Diary extends BaseEntity {

    private LocalDate writeAt;

    private LocalDateTime updateAt;

    private String contents;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "weather_id", nullable = false)
    private Weather weather;

}
