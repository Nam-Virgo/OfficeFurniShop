package model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"conversation", "user"})
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int messageId;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime timestamp;

    // 🔗 ManyToOne → Conversation
    @ManyToOne
    @JoinColumn(name = "conversationId")
    private Conversation conversation;

    // 🔗 ManyToOne → User (người gửi)
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
}