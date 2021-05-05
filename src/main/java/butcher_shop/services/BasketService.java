package butcher_shop.services;

import butcher_shop.models.Meat;
import butcher_shop.repositories.BasketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BasketService {

    @Autowired
    private final BasketRepository basketRepository;

}
