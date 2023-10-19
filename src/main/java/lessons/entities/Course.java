package lessons.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "COURSE")
public class Course {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name="MAX_ATTENDEES")
    private String maxAttendees;

    @Column(name = "SUMMARY")
    private String summary;

    @OneToMany(mappedBy= "course")
    private List<Subject> subjects;
}