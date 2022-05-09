package jaefactory.newboard.domain.user;


import jaefactory.newboard.domain.BaseTimeEntity;
import jaefactory.newboard.domain.board.Board;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username; //아이디
    private String realName; //이름

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String oauth;

    private String role;  //USER,ADMIN

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

}
