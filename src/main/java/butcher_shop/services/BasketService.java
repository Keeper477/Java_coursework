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

    public void addMeat(Meat meat) {
        User user = getUser();
        user.addMeat(meat);
        meatRepository.save(meat);
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
    public Integer getPrice(List<Meat> meats) {
        int price = 0;
        for (Meat meat : meats) {
            price += meat.getPrice();
        }
        return price;
    }

    public void deleteMeat(String name){
        User user = getUser();
        user.removeMeat(meatRepository.findByName(name));
        userRepository.save(user);
    }
    public void buy(){
        User user = getUser();
        List<Meat> meats = user.getMeats();
        for (Meat meat : meats) {
            meat.setQuantity(meat.getQuantity()-1);
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
