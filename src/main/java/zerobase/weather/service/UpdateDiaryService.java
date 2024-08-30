package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobase.weather.dto.UpdateDiaryLogDTO;
import zerobase.weather.entity.Diary;
import zerobase.weather.entity.UpdateDiaryLog;
import zerobase.weather.exception.DiaryException;
import zerobase.weather.repository.DiaryRepository;
import zerobase.weather.repository.UpdateDiaryLogRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static zerobase.weather.enums.ErrorCode.DIARY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class UpdateDiaryService {

    private final DiaryRepository diaryRepository;
    private final UpdateDiaryLogRepository updateDiaryLogRepository;

    @Transactional
    public UpdateDiaryLogDTO updateDiary(LocalDate writeAt, String contents) {

        Diary diary = diaryRepository.findFirstByWriteAtOrderByIdAsc(writeAt)
                .orElseThrow(() -> new DiaryException(DIARY_NOT_FOUND));

        UpdateDiaryLog updateLog = UpdateDiaryLog.builder()
                .beforeContents(diary.getContents())
                .afterContents(contents)
                .updateAt(LocalDateTime.now())
                .diaryId(diary.getId())
                .build();

        diary.setContents(contents);
        diary.setUpdateAt(LocalDateTime.now());
        diaryRepository.save(diary);

        return UpdateDiaryLogDTO.fromEntity(updateDiaryLogRepository.save(updateLog));
    }
}
