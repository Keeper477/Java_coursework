package butcher_shop.repositories;

import butcher_shop.models.Mutton;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuttonRepository extends JpaRepository<Mutton, Integer> {
}
