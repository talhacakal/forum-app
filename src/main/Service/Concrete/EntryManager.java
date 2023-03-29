package main.Service.Concrete;

import main.Model.DTO.EntryDTO;
import main.Model.Comment;
import main.Model.Entry;
import main.Repository.CommentRepository;
import main.Repository.EntryRepository;
import main.Service.Abstract.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntryManager implements EntryService {

    @Autowired
    private EntryRepository entryRepository;
    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Object updateEntry(EntryDTO entrydto, Entry entry) {
        entry.setContent(entrydto.getContent());
        entry.setOpenFComment(entrydto.isOpenFComment());
        return ResponseEntity.status(HttpStatus.OK).body(this.entryRepository.save(entry));
    }
    @Override
    public Object closeComment(Entry entry) {
        entry.setOpenFComment(false);
        this.entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Override
    public Object openComment(Entry entry) {
        entry.setOpenFComment(true);
        this.entryRepository.save(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    @Override
    public Object deleteEntry(Entry entry) {
        entry.setUid(null);
        List<Comment> commentList = this.commentRepository.findByEid_Eid(entry.getEid());
        for (Comment comment : commentList) comment.setUid(null);
        this.commentRepository.deleteAll(commentList);
        this.entryRepository.delete(entry);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
