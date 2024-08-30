package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobase.weather.entity.Diary;

import java.time.LocalDate;
import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findByWriteAt(LocalDate writeAt);

    List<Diary> findByWriteAtBetween(LocalDate startDate, LocalDate endDate);

}
