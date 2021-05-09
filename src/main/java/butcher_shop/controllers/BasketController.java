package butcher_shop.controllers;

import butcher_shop.models.Meat;
import butcher_shop.services.BasketService;
import butcher_shop.services.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private BasketService basketService;

    @Autowired
    private MeatService meatService;

    @GetMapping("/basket")
    @ResponseBody
    public ModelAndView getBasket(){
        ModelAndView mav = new ModelAndView("basket");
        List<Meat> meats = basketService.getSetMeat(basketService.getMeats());
        mav.addObject("meat", meats);
        mav.addObject("num", basketService.getCounts(meats, basketService.getMeats()));
        mav.addObject("price", basketService.getPrice(basketService.getMeats()));
        return mav;
    }
    @GetMapping("/basket/delete/{name}")
    public String deleteBasket(@PathVariable String name){
        basketService.deleteMeat(name);
        return "redirect:/basket";
    }
    @GetMapping("/basket/buy")
    public String deleteBasket(){
        basketService.buy();
        return "redirect:/";
    }
}
