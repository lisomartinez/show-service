package cloud.liso.showservice.repositories;

import cloud.liso.showservice.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Integer> {

    @Query("SELECT s FROM Season s WHERE show_id = :id")
    List<Season> findAllByShow(@Param("id") int id);
}
