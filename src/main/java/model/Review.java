package model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "product"})
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private BigDecimal rating;

    private LocalDateTime createAt;

    // 🔗 ManyToOne → Customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    // 🔗 ManyToOne → Product
    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}