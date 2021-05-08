package butcher_shop.services;

import butcher_shop.models.Meat;
import butcher_shop.repositories.MeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeatService {

    @Autowired
    private MeatRepository meatRepository;

    public List<Meat> getByName(String sort) {
        return meatRepository.findAllBySort(sort);
    }
}
