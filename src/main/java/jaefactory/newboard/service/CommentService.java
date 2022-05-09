package jaefactory.newboard.service;


import jaefactory.newboard.domain.comment.Comment;
import jaefactory.newboard.domain.comment.CommentRepository;
import jaefactory.newboard.dto.CommentSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

//    @Transactional
//    public void saveComment(CommentSaveRequestDto commentSaveRequestDto){
//       commentRepository.mSave(commentSaveRequestDto.getUserId(), commentSaveRequestDto.getBoardId(), commentSaveRequestDto.getContent());
//    }

    @Transactional
    public void deleteReplyById(Long id){
        commentRepository.deleteById(id);
    }
}
