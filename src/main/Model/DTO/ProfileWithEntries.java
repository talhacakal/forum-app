package main.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import main.Model.Entry;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileWithEntries {

    private String name;
    private String lastName;
    private String birth;
    private String personalInfo;
    private String location;
    private List<Entry> entries;
}
