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
@Table(name = "LESSON")
public class Lesson {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LESSON_NUMBER")
    private Long lessonNumber;

    @ManyToOne
    @JoinColumn(name="SUBJECT_ID", nullable=false)
    private Subject subject;

    @OneToMany(mappedBy = "lesson")
    private List<Page> pages;
}
