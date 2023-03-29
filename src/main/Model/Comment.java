package main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import main.Security.User.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String cid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid")
    @JsonIgnore
    private User uid;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "eid", referencedColumnName = "eid")
    @JsonIgnore
    private Entry eid;
    private String content;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "last_update_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;

    @PrePersist
    public void prePersist() {
        setCid(UUID.randomUUID().toString());
    }
}
