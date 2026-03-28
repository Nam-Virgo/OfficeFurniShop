package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "OrderItem")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"order", "product"})
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderItemId;

    // 🔗 ManyToOne → Order
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    // 🔗 ManyToOne → Product
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    private int quantity;

    private BigDecimal price;
}