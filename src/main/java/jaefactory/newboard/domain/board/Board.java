package jaefactory.newboard.domain.board;

import jaefactory.newboard.domain.comment.Comment;
import jaefactory.newboard.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @NotBlank
    private String title;

    @Lob //용량 큰 데이터
    @NotBlank
    private String content;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @OneToMany(mappedBy = "board",cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    private LocalDateTime createDate;

    @PrePersist
    public void createDate() { this.createDate = LocalDateTime.now();}
}
