package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "`Order`")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "orderItems"})
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;

    private LocalDate orderDate;

    private String status;

    private BigDecimal totalCost;

    private BigDecimal discount;

    private BigDecimal actualCost;

    private String cityOfProvince;

    private String district;

    private String ward;

    private String streetNumber;

    private String phone;

    private String paymentMethod;

    // 🔗 ManyToOne → Customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    // 🔗 1 Order - nhiều OrderItem
    @OneToMany(mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderItem> orderItems;
}