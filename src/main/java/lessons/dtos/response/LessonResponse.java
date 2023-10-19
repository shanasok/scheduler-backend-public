package lessons.dtos.response;

import lessons.entities.Lesson;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class LessonResponse {

    private String message;
    private List<Lesson> lesson;
    private boolean success;

}
