package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zerobase.weather.WeatherApplication;
import zerobase.weather.dto.DiaryDTO;
import zerobase.weather.dto.WeatherDTO;
import zerobase.weather.entity.Diary;
import zerobase.weather.entity.Weather;
import zerobase.weather.exception.DiaryException;
import zerobase.weather.repository.DiaryRepository;
import zerobase.weather.repository.WeatherRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;

import static zerobase.weather.enums.ErrorCode.WEATHER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CreateDiaryService {

    private final DiaryRepository diaryRepository;
    private final WeatherService weatherService;
    private final WeatherRepository weatherRepository;

    private static final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);

    @Transactional
    public DiaryDTO saveDiary(LocalDate writeAt, String cityName, String contents) {

        Weather weather = weatherRepository.findByCityNameOrderByIdDesc(cityName)
                .orElseGet(() -> {

                    logger.info("날씨 정보를 찾을 수 없어 날씨 API를 호출합니다.");
                    WeatherDTO weatherDTO = weatherService.saveWeather(cityName);

                    // WeatherDTO에서 새로 생성된 Weather의 ID를 사용해 엔티티 조회
                    return weatherRepository.findById(weatherDTO.getId())
                            .orElseThrow(() -> new DiaryException(WEATHER_NOT_FOUND));
                });

        Diary diary = Diary.builder()
                .writeAt(writeAt)
                .contents(contents)
                .weather(weather)
                .build();

        logger.info("새로운 일기를 생성합니다.");
        return DiaryDTO.fromEntity(diaryRepository.save(diary));
    }
}
