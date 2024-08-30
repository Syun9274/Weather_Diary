package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    @Transactional
    public ReadDiaryResponse findDiariesByDate(LocalDate writeDate) {
        List<Diary> diaries = diaryRepository.findByWriteAt(writeDate);
        return ReadDiaryResponse.fromEntityList(diaries);
    }

    @Transactional
    public ReadDiaryResponse findDiariesByMultiDay(
            LocalDate startDate, LocalDate endDate) {

        List<Diary> diaries = diaryRepository.findByWriteAtBetween(startDate, endDate);
        return ReadDiaryResponse.fromEntityList(diaries);
    }
}
