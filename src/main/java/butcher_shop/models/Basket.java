package butcher_shop.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;


@Getter
@Setter
@Entity
@DynamicUpdate
@Table(name = "basket")
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name = "count")
    int count;
    @Column(name = "sum")
    int sum;
    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Meat> meat;
}
