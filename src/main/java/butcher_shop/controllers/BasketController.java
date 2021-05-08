package butcher_shop.controllers;

import butcher_shop.services.BasketService;
import butcher_shop.services.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private MeatService meatService;

    @GetMapping("/basket")
    public String getBasket(){
        return "basket";
    }
}
