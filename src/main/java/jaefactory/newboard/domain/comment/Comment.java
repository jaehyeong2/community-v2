package jaefactory.newboard.domain.comment;

import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter @Setter
@Entity
public class Comment {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id")
    private int id;

    @Column(nullable = false, length = 200)
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @JoinColumn(name = "board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() { this.createDate = LocalDateTime.now();}
}
