package lessons.dtos.response;

import lessons.entities.Course;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CourseResponse {

    private String message;
    private List<Course> course;
    private boolean success;

}
