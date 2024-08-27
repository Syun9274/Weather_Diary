package zerobase.weather.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "snow")
public class Snow extends BaseEntity {

    @Column(name = "one_hour")
    private double oneHour;

    @Column(name = "three_hour")
    private double threeHours;
}
