package main.Controller;

import main.Model.DTO.CommentDTO;
import main.Model.Comment;
import main.Repository.CommentRepository;
import main.Service.Abstract.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentService commentService;

    @GetMapping("/getComments/{eid}")
    public ResponseEntity entryComments(@PathVariable String eid) {
        return this.commentService.entryComments(eid);
    }
    @PostMapping("/auth")
    public ResponseEntity toComment(Authentication authentication, @RequestBody CommentDTO userComment) {
        return this.commentService.toComment(authentication, userComment);
    }
    @PutMapping("/auth")
    public ResponseEntity updateComment(@RequestBody CommentDTO userComment) {
        Optional<Comment> optionalComment = this.commentRepository.findByCid(userComment.getCid());
        if (optionalComment.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Comment not found!");

        return this.commentService.updateComment(userComment, optionalComment.get());
    }
    @DeleteMapping("/auth")
    public ResponseEntity deleteComment(@RequestParam String cid) {
        Optional<Comment> optionalComment = this.commentRepository.findByCid(cid);
        if (optionalComment.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return this.commentService.deleteComment(optionalComment.get());
    }
}
