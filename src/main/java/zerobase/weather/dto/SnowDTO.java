package zerobase.weather.dto;

import lombok.*;
import zerobase.weather.entity.Snow;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SnowDTO {

    private long id;

    private double oneHour;
    private double threeHours;

    public static SnowDTO fromEntity(Snow snow) {

        if(snow == null)
            return null;

        return SnowDTO.builder()
                .id(snow.getId())
                .oneHour(snow.getOneHour())
                .threeHours(snow.getThreeHours())
                .build();
    }
}