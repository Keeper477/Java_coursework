package butcher_shop.controllers;

import butcher_shop.models.Meat;
import butcher_shop.services.BasketService;
import butcher_shop.services.MeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/shop")
public class MeatController {

    @Autowired
    private MeatService meatService;

    @Autowired
    private BasketService basketService;

    @GetMapping("/mutton")
    @ResponseBody
    public ModelAndView getMutton() {
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats = meatService.getBySort("mutton");
        mav.addObject("meat", meats);
        return mav;
    }

    @GetMapping("/pork")
    @ResponseBody
    public ModelAndView getPork(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getBySort("pork");
        mav.addObject("meat", meats);
        return mav;
    }
    @GetMapping("/beef")
    @ResponseBody
    public ModelAndView getBeef(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getBySort("beef");
        mav.addObject("meat", meats);
        return mav;
    }
    @GetMapping("/chicken")
    @ResponseBody
    public ModelAndView getMeat(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getBySort("chicken");
        mav.addObject("meat", meats);
        return mav;
    }

    @GetMapping("{sort}/add/{name}")
    public ModelAndView addMeat(@PathVariable String sort, @PathVariable String name){
        List<Meat> meats = meatService.getBySort(sort);
        Meat meat = meatService.getByName(meats, name);
        ModelAndView mav = new ModelAndView("shop");
        basketService.addMeat(meat);
        mav.addObject("meat", meats);
        mav.addObject("product", meat.getName());
        mav.addObject("purchase", true);
        return mav;
    }

}
