package jaefactory.newboard.service;


import jaefactory.newboard.domain.reply.Reply;
import jaefactory.newboard.domain.reply.ReplyRepository;
import jaefactory.newboard.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ReplyService {

    private final ReplyRepository replyRepository;

    @Transactional(readOnly = true)
    public List<Reply> getAllReplies() {
        return replyRepository.findAll();
    }

    @Transactional
    public void saveReply(ReplySaveRequestDto replySaveRequestDto){
        int result = replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
    }

    @Transactional
    public void deleteReplyById(int id){
        replyRepository.deleteById(id);
    }
}
