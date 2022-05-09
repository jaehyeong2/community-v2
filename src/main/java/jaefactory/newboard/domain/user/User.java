package jaefactory.newboard.domain.user;


import jaefactory.newboard.domain.BaseTimeEntity;
import jaefactory.newboard.domain.board.Board;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true)
    private String username; //아이디
    private String name; //이름

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    private String oauth;

    private String role;  //USER,ADMIN

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<>();

    public void changePassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void updateName(String name) {
        this.name = name;
    }
}
