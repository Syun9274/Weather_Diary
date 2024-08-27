package zerobase.weather.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "diary")
public class Diary extends BaseEntity {

    private String contents;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "weather_id", nullable = false)
    private Weather weather;

}
