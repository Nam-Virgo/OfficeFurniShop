package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    // 🔗 ManyToOne → User
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    private String receiverName;

    private String phone;

    private String city;

    private String district;

    private String ward;

    private String specificAddress;

    private boolean isDefault;
}