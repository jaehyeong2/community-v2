package jaefactory.newboard.domain.reply;

import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Reply {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "reply_id")
    private Long id;

    @Column(nullable = false, length = 200)
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @JoinColumn(name = "board_id")
    @ManyToOne
    private Board board;

}
