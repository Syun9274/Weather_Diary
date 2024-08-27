package zerobase.weather.dto;

import lombok.*;
import zerobase.weather.entity.Rain;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RainDTO {

    private long id;

    private double oneHour;
    private double threeHours;

    public static RainDTO fromEntity(Rain rain) {

        if (rain == null)
            return null;

        return RainDTO.builder()
                .id(rain.getId())
                .oneHour(rain.getOneHour())
                .threeHours(rain.getThreeHours())
                .build();
    }
}
