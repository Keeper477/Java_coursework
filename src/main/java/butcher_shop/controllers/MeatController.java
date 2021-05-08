package butcher_shop.controllers;

import butcher_shop.models.Basket;
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
    public ModelAndView getMutton(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getByName("Говядина");
        return getModelAndView(mav, meats);
    }

    @GetMapping("/pork")
    @ResponseBody
    public ModelAndView getPork(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getByName("Свинина");
        return getModelAndView(mav, meats);
    }
    @GetMapping("/beef")
    @ResponseBody
    public ModelAndView getBeef(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getByName("Баранина");
        return getModelAndView(mav, meats);
    }
    @GetMapping("/chicken")
    @ResponseBody
    public ModelAndView getMeat(){
        ModelAndView mav = new ModelAndView("shop");
        List<Meat> meats= meatService.getByName("Курица");
        return getModelAndView(mav, meats);
    }

    private ModelAndView getModelAndView(ModelAndView mav, List<Meat> meats) {
        Meat meat = meats.get(0);
        mav.addObject("meat1", meat);
        meat = meats.get(1);
        mav.addObject("meat2", meat);
        meat = meats.get(2);
        mav.addObject("meat3", meat);
        meat = meats.get(3);
        mav.addObject("meat4", meat);
        meat = meats.get(4);
        mav.addObject("meat5", meat);
        return mav;
    }

}
