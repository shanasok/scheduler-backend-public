package lessons.entities.content;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "FACT")
@PrimaryKeyJoinColumn(name = "CONTENT_ID")
public class  Fact extends Content{

    @Column(name = "FACT", columnDefinition = "TEXT")
    private String fact;

}
