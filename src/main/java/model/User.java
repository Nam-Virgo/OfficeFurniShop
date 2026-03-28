package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "`User`") // ⚠️ vì User là keyword
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "role")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String gender;

    private String status;

    private int isDelete;

    private int isActive;

    // 🔗 ManyToOne với Role
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    private Role role;
}