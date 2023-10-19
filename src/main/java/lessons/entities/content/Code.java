package lessons.entities.content;

import lessons.entities.enums.SnippetLanguage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CODE")
@PrimaryKeyJoinColumn(name = "CONTENT_ID")
public class Code extends Content{

    @Column(name = "SNIPPET", columnDefinition = "TEXT")
    private String snippet;

    @Column(name = "SNIPPET_LANGUAGE")
    private SnippetLanguage language;
}
