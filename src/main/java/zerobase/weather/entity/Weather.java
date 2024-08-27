package zerobase.weather.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity (name = "weather")
public class Weather extends BaseEntity {

    // 좌표 정보
    private double lon; // 경도
    private double lat; // 위도

    // 날씨 정보
    private int weatherId; // 날씨 ID
    private String weatherMain; // 날씨 상태 (Rain, Snow 등)
    private String description; // 상세 설명

    // 주요 날씨 정보
    private double temp; // 현재 기온
    private double feelsLike; // 체감 온도
    private double tempMin; // 최저 기온
    private double tempMax; // 최고 기온
    private int pressure; // 기압
    private int humidity; // 습도
    private int seaLevel; // 해수면 기압
    private int grndLevel; // 지면 기압

    // 가시성
    private int visibility;

    // 바람 정보
    private double windSpeed; // 풍속
    private int windDeg; // 풍향

    // 비와 눈 정보는 별도의 Entity 처리
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "rain_id", nullable = true)
    private Rain rain; // 비 정보

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "snow_id", nullable = true)
    private Snow snow; // 눈 정보

    // 구름 정보
    private int cloudsAll; // 구름량

    // 시스템 정보
    private int sysType;
    private int sysId;
    private String country; // 국가 코드 (KR)
    private LocalDateTime sunrise; // 일출 시간
    private LocalDateTime sunset; // 일몰 시간

    private int timezone; // 타임존 정보
    private String cityName; // 도시 이름 (Seoul 등)

}