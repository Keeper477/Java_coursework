package butcher_shop.services;

import butcher_shop.models.Basket;
import butcher_shop.models.Meat;
import butcher_shop.repositories.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

}
