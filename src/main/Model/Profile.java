package main.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "uuid", referencedColumnName = "uuid", nullable = false)
    @JsonIgnore
    private User uuid;
    @NonNull
    private String name;
    @NonNull
    private String lastName;
    private String birth;
    private String personalInfo;
    private String location;
    @CreationTimestamp
    private LocalDateTime createDate;
    @Column(name = "last_update_date")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDate;
}