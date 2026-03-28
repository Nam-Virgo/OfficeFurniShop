package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Conversation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"customer", "administrator", "messages"})
public class Conversation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int conversationId;

    private String title;

    private String status;

    private LocalDateTime createdDate;

    // 🔗 ManyToOne → Customer
    @ManyToOne
    @JoinColumn(name = "customerId")
    private Customer customer;

    // 🔗 ManyToOne → Administrator
    @ManyToOne
    @JoinColumn(name = "adminId")
    private Administrator administrator;

    // 🔗 1 Conversation - nhiều Message
    @OneToMany(mappedBy = "conversation",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Message> messages;
}