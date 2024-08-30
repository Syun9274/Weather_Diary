package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zerobase.weather.entity.Diary;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

    List<Diary> findByWriteAt(LocalDate writeAt);

    List<Diary> findByWriteAtBetween(LocalDate startDate, LocalDate endDate);

    Optional<Diary> findFirstByWriteAtOrderByIdAsc(LocalDate writeAt);
}
