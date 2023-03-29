package main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import main.Security.User.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "entry")
public class Entry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String eid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    @JsonIgnore
    private User uid;
    @NonNull
    private String content;
    @OneToMany(mappedBy = "eid")
    private List<Comment> comments;
    private boolean openFComment;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "last_update_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @PrePersist
    public void prePersist() {
        setEid(UUID.randomUUID().toString());
    }
}
