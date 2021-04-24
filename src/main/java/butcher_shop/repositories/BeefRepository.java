package butcher_shop.repositories;

import butcher_shop.models.Beef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BeefRepository extends JpaRepository<Beef, Integer> {
}
