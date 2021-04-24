package butcher_shop.repositories;

import butcher_shop.models.Chicken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChickenRepository extends JpaRepository<Chicken, Integer> {
}
