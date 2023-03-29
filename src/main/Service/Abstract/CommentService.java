package main.Service.Abstract;

import main.Model.DTO.CommentDTO;
import main.Model.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

public interface CommentService {

    ResponseEntity entryComments(String eid);
    ResponseEntity toComment(Authentication authentication, CommentDTO userComment);
    @PreAuthorize("hasAnyRole('ROLE_ADMIN') || authentication.name == #comment.getUid().getEmail()")
    ResponseEntity updateComment(CommentDTO userComment, Comment comment);
    @PreAuthorize(" hasAnyRole('ROLE_ADMIN') || authentication.name == #comment.getUid().getEmail()")
    ResponseEntity deleteComment(Comment comment);
}
