package zerobase.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zerobase.weather.entity.Weather;

import java.util.Optional;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("SELECT w FROM weather w WHERE w.cityName = :cityName ORDER BY w.id DESC")
    Optional<Weather> findByCityNameOrderByIdDesc(@Param("cityName") String cityName);
}