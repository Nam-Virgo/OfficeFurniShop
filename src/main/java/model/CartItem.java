package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "CartItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"cart", "product"})
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cartItemId;

    // 🔗 ManyToOne → Cart
    @ManyToOne
    @JoinColumn(name = "cartId")
    private Cart cart;

    // 🔗 ManyToOne → Product
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;

    private BigDecimal price;
}