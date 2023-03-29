package main.Model;

import jakarta.persistence.*;
import lombok.*;
import main.Security.User.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Entity
@Table(name = "authentication")
public class Authentication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", nullable = false, unique = true)
    @NonNull
    private User uuid;
    @NonNull
    private String password;
    @Column(name = "create_date")
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "last_update_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
}
