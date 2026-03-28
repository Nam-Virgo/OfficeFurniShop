package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "RefundRequest")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"order", "orderItem"})
public class RefundRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int refundId;

    // 🔗 ManyToOne → Order
    @ManyToOne
    @JoinColumn(name = "orderId")
    private Order order;

    // 🔗 ManyToOne → OrderItem
    @ManyToOne
    @JoinColumn(name = "orderItemId")
    private OrderItem orderItem;

    private String reason;

    private String requestType;

    private String status = "PENDING";

    private String imagePath;

    private LocalDateTime createdDate;
}