package jaefactory.newboard.service;

import jaefactory.newboard.domain.board.Board;
import jaefactory.newboard.domain.board.BoardRepository;
import jaefactory.newboard.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public Page<Board> getBoardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public void addBoard(Board board, User user) {
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(Long id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateBoardById(Long id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow(()->
        { return new IllegalArgumentException("글 찾기 실패 : 아이디를 찾을 수 없습니다.");}
        );
        board.updateBoard(requestBoard.getTitle(),requestBoard.getContent());
    }

    @Transactional(readOnly = true)
    public Board getBoardById(Long id){
        return boardRepository.findById(id).orElseThrow();
    }
}
