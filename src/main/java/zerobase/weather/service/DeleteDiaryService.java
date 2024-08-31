package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import zerobase.weather.WeatherApplication;
import zerobase.weather.entity.Diary;
import zerobase.weather.repository.DiaryRepository;
import zerobase.weather.repository.UpdateDiaryLogRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteDiaryService {

    private final DiaryRepository diaryRepository;
    private final UpdateDiaryLogRepository updateDiaryLogRepository;

    private static final Logger logger = LoggerFactory.getLogger(WeatherApplication.class);

    @Transactional
    public List<Diary> deleteDiary(LocalDate writeAt) {

        List<Diary> diariesToDelete = diaryRepository.findByWriteAt(writeAt);

        logger.info("삭제하고자 하는 일기의 수정 기록을 삭제합니다.");
        for (Diary diary : diariesToDelete) {
            updateDiaryLogRepository.deleteAllByDiaryId(diary.getId());
        }

        logger.info("일기를 삭제합니다.");
        diaryRepository.deleteAll(diariesToDelete);
        return diariesToDelete;
    }
}
