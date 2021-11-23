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
    public Page<Board> getAllBoards(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    @Transactional
    public void addBoard(Board board, User user) {
        board.setViewCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoardById(int id){
        boardRepository.deleteById(id);
    }

    @Transactional
    public void updateBoardById(int id, Board requestBoard){
        Board board = boardRepository.findById(id).orElseThrow();
        board.setTitle(requestBoard.getTitle());
        board.setContent(requestBoard.getContent());
        boardRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Board getBoardById(int id){
        return boardRepository.findById(id).orElseThrow();
    }
}
