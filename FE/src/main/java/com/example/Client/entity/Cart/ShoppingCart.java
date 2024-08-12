package com.example.Client.entity.Cart;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.util.Set;

@Getter
@Setter
/*@AllArgsConstructor*/
@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    /*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @GeneratedValue(generator = "TypeGenerator")
    @GenericGenerator(name = "TypeGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator", parameters = {
            @Parameter(name = "sequence_name", value = "type_sequence"),
            @Parameter(name = "initial", value = "1"),
            @Parameter(name = "increment_size", value = "1")
    })
    @Column
    private Long id;

    @Column
    private double totalPrice;
    @Column
    private int totalItems;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "cart")
    private Set<CartItem> cartItems;


/*    public ShoppingCart() {
        this.cartItems = new HashSet<>();
        this.totalItems = 0;
        this.totalPrice = 0.0;
    }*/

    //    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "acc_id", referencedColumnName = "acc_id")
//    private Acc acc;
}