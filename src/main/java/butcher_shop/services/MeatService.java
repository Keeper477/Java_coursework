package butcher_shop.services;

import butcher_shop.models.Meat;
import butcher_shop.repositories.MeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeatService {

    @Autowired
    private MeatRepository meatRepository;

    public List<Meat> getBySort(String sort) {
        List<Meat> meats = meatRepository.findAllBySort(sort);
        meats.sort(Comparator.comparing(Meat::getId));
        return meats;
    }

    public Meat getByName(List<Meat> meats, String name){
        for (Meat meat : meats) {
            if (meat.getName().equals(name))
                return meat;
        }
        return null;
    }
}
