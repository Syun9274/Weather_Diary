package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    @Transactional
    public DiaryDTO saveDiary(LocalDate writeAt, String cityName, String contents) {

        Weather weather = weatherRepository.findByCityNameOrderByIdDesc(cityName)
                .orElseGet(() -> {
                    // Weather 정보가 없다면
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

        return DiaryDTO.fromEntity(diaryRepository.save(diary));
    }
}
