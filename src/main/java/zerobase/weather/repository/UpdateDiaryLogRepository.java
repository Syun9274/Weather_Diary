package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.entity.UpdateDiaryLog;

@Repository
public interface UpdateDiaryLogRepository extends JpaRepository<UpdateDiaryLog, Long> {

    void deleteAllByDiaryId(Long diaryId);

}
