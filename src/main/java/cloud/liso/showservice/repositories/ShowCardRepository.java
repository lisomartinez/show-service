package cloud.liso.showservice.repositories;

import cloud.liso.showservice.model.ShowCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowCardRepository extends JpaRepository<ShowCard, Integer> {
}
