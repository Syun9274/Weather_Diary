package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
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

    @Transactional
    public List<Diary> deleteDiary(LocalDate writeAt) {
        try {
            // 삭제 로직
            List<Diary> diariesToDelete = diaryRepository.findByWriteAt(writeAt);
            for (Diary diary : diariesToDelete) {
                updateDiaryLogRepository.deleteAllByDiaryId(diary.getId());
            }
            diaryRepository.deleteAll(diariesToDelete);
            return diariesToDelete;

        } catch (Exception e) {
            // 예외가 발생한 경우 로그 출력
            System.err.println("Exception occurred: " + e.getMessage());
            e.printStackTrace(); // stack trace를 콘솔에 출력
            throw e;  // 예외를 다시 던져서 서버에 알림
        }
    }
}
