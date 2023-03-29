package main.Repository;

import main.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByEid_Eid(String eid);
    Optional<Comment> findByCid(String cid);
}