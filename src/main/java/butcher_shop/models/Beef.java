package butcher_shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "beef")
@Getter
@Setter
public class Beef {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "weight")
    int weight;
    @Column(name = "price")
    int price;
    @Column(name = "description")
    String description;
}
