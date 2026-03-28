package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Administrator")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "user")
public class Administrator {

    @Id
    private int userId;

    // 🔗 shared PK với User
    @OneToOne
    @MapsId
    @JoinColumn(name = "userId")
    private User user;
}