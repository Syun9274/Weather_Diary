package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zerobase.weather.WeatherApplication;
import zerobase.weather.entity.Diary;
import zerobase.weather.repository.DiaryRepository;
import zerobase.weather.response.ReadDiaryResponse;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadDiaryService {

    private final DiaryRepository diaryRepository;

    private static final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);

    @Transactional
    public ReadDiaryResponse findDiariesByDate(LocalDate writeAt) {

        logger.info("일기를 읽어오는 중 입니다.");
        List<Diary> diaries = diaryRepository.findByWriteAt(writeAt);
        return ReadDiaryResponse.fromEntityList(diaries);
    }

    @Transactional
    public ReadDiaryResponse findDiariesByMultiDay(
            LocalDate startDate, LocalDate endDate) {

        logger.info("일기를 읽어오는 중 입니다.");
        List<Diary> diaries = diaryRepository.findByWriteAtBetween(startDate, endDate);
        return ReadDiaryResponse.fromEntityList(diaries);
    }
}
