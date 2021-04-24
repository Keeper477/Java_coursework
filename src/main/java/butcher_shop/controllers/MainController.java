package butcher_shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String getHome() {
        return "home";
    }
    @GetMapping("/shop")
    public String getShop() {
        return "shop";
    }
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
    @GetMapping("/basket")
    public String getBasket() {
        return "basket";
    }
}
