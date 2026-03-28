package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Customer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Customer {

    @Id
    private int customerId;

    // 🔗 dùng chung PK với User
    @OneToOne
    @MapsId
    @JoinColumn(name = "customerId")
    private User user;
}