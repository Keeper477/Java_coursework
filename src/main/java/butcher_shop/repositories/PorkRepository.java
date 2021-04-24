package butcher_shop.repositories;

import butcher_shop.models.Pork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PorkRepository extends JpaRepository<Pork, Integer> {
}
