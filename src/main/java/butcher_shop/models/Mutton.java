package butcher_shop.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "mutton")
@Getter
@Setter
public class Mutton {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "name")
    String name;
    @Column(name = "weight")
    String weight;
    @Column(name = "price")
    String price;
    @Column(name = "description")
    String description;
}
