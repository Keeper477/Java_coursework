package butcher_shop.services;

import butcher_shop.models.Meat;
import butcher_shop.models.User;
import butcher_shop.repositories.MeatRepository;
import butcher_shop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BasketService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MeatRepository meatRepository;

    public boolean addMeat(Meat meat) {
        User user = getUser();
        List<Meat> meats = user.getMeats();
        if(meat.getQuantity() > 0){
            meat.setQuantity(meat.getQuantity()-1);
            user.addMeat(meat);
            meatRepository.save(meat);
            return true;
        }
        return false;

    }
    public List<Meat> getMeats() {
        User user = getUser();
        return user.getMeats();
    }

    public List<Meat> getSetMeat(List<Meat> meats1) {
        Set set = new HashSet(meats1);
        List<Meat> meat = new ArrayList<Meat>(set);
        return meat;
    }

    public List<String> getCounts(List<Meat> meat1, List<Meat> meat2) {
        List<Integer> nums = new ArrayList<Integer>();
        for (Meat meat : meat1) {
            nums.add(Collections.frequency(meat2, meat));
        }
        List<String> str = new ArrayList<>();
        for (int i = 0; i < meat1.size(); i++) {
            str.add(nums.get(i) + " x " + meat1.get(i).getPrice());
        }
        return str;
    }
    public Double getPrice(List<Meat> meats) {
        double price = 0;
        for (Meat meat : meats) {
            price += meat.getPrice();
        }
        price -= price*getStock(meats) /100;
        return price;
    }

    public Double getStock(List<Meat> meats) {
        double discount = 0;
        if (meats.size() >=6){
            discount +=10;
        }
        List<String> sorts = new ArrayList<>();
        for (Meat meat : meats) {
            sorts.add(meat.getSort());
        }
        Set<String> stocks = new HashSet<>(sorts);
        if (stocks.size() >=2){
            discount +=5;
        }
        return discount;
    }

    public void deleteMeat(String name){
        User user = getUser();
        Meat meat = meatRepository.findByName(name);
        user.removeMeat(meat);
        meat.setQuantity(meat.getQuantity()+1);
        userRepository.save(user);
        meatRepository.save(meat);
    }
    public void buy(){
        User user = getUser();
        List<Meat> meats = user.getMeats();
        for (Meat meat : meats) {
            Set<User> users = meat.getBaskets();
            users.remove(user);
            meat.setBaskets(users);
            meatRepository.save(meat);
        }
        meats.clear();
        user.setMeats(meats);
        userRepository.save(user);
    }

    private User getUser(){
        String username = "";
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();
        } else {
            username = principal.toString();
        }
        return userRepository.findByLogin(username);
    }
}
