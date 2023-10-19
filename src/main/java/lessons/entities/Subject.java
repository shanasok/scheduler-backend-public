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
@Table(name = "SUBJECT")
public class Subject {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SUMMARY")
    private String summary;

    @Column(name = "SUBJECT_NUMBER")
    private Long subjectNumber;

    @ManyToOne
    @JoinColumn(name="COURSE_ID", nullable=false)
    private Course course;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessons;
}