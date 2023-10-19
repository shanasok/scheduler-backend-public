package lessons.entities.content;

import lessons.entities.Page;
import lessons.entities.content.Code;
import lessons.entities.content.Definition;
import lessons.entities.enums.ContentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PAGE_CONTENT")
public class PageContent {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="PAGE_ID", nullable=false)
    private Page page;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "CONTENT_ID", nullable=false)
    private Content content;

    @Column(name = "CONTENT_NUMBER")
    private Long contentNumber;

    private Boolean isEditable = Boolean.FALSE;

}
