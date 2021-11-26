package jaefactory.newboard.domain.board;

import jaefactory.newboard.domain.reply.Reply;
import jaefactory.newboard.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "board_id")
    private int id;
    private String title;

    @Lob //용량 큰 데이터
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    private List<Reply> replies = new ArrayList<>();

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() { this.createDate = LocalDateTime.now();}
}
