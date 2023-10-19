package lessons.entities.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "DEFINITION")
@PrimaryKeyJoinColumn(name = "CONTENT_ID")
public class Definition extends Content {

    @Column(name = "TERM")
    private String term;

    @Column(name = "EXPLANATION")
    private String explanation;
}
