package butcher_shop.repositories;

import butcher_shop.models.Meat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeatRepository extends JpaRepository<Meat, Long> {
}
