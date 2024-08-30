package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.weather.entity.UpdateDiaryLog;

public interface UpdateDiaryLogRepository extends JpaRepository<UpdateDiaryLog, Long> {
}
