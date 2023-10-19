package lessons.entities;

import lessons.entities.content.PageContent;
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
@Table(name = "PAGE")
public class Page {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "PAGE_NUMBER")
    private Long pageNumber;

    @ManyToOne
    @JoinColumn(name="LESSON_ID", nullable=false)
    private Lesson lesson;

    @OneToMany(mappedBy = "page")
    private List<PageContent> pageContent;
}
