package main.Service.Concrete;

import main.Model.DTO.CommentDTO;
import main.Model.Comment;
import main.Model.Entry;
import main.Repository.CommentRepository;
import main.Repository.EntryRepository;
import main.Service.Abstract.CommentService;
import main.Security.User.User;
import main.Security.User.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity entryComments(String eid) {
        List<Comment> commentList = this.commentRepository.findByEid_Eid(eid);
        if (commentList.size() == 0) return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(commentList);
    }
    @Override
    public ResponseEntity toComment(Authentication authentication, CommentDTO userComment) {
        Optional<Entry> optionalEntry = this.entryRepository.findByEid(userComment.getEid());
        User user = this.userRepository.findByEmail(authentication.getName()).get();
        if (optionalEntry.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        if (!optionalEntry.get().isOpenFComment())
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This entry close to comment");

        Comment comment = Comment.builder()
                .uid(user)
                .eid(optionalEntry.get())
                .content(userComment.getContent()).build();
        return ResponseEntity.ok(this.commentRepository.save(comment));
    }
    @Override
    public ResponseEntity updateComment(CommentDTO userComment, Comment comment) {
        comment.setContent(userComment.getContent());
        return ResponseEntity.ok(this.commentRepository.save(comment));
    }
    @Override
    public ResponseEntity deleteComment(Comment comment) {
        comment.setEid(null);
        comment.setUid(null);
        this.commentRepository.delete(comment);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
