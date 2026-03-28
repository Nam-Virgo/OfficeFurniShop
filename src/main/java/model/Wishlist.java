package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "Wishlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "products"})
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int wishlistId;

    private int isDelete;

    // 🔗 1 Wishlist - 1 Customer
    @OneToOne
    @JoinColumn(name = "customerId", unique = true)
    private Customer customer;

    // 🔗 ManyToMany với Product
    @ManyToMany
    @JoinTable(
            name = "wishlists_products",
            joinColumns = @JoinColumn(name = "wishlistId"),
            inverseJoinColumns = @JoinColumn(name = "productId")
    )
    private List<Product> products;
}