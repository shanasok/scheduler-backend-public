package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.Course;
import lessons.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GraphQLDataFetchersCourse {

    private CourseService courseService;

    public DataFetcher<List<Course>> getAllCoursesDataFetcher() {
        return dataFetchingEnvironment -> {
            String courseId = dataFetchingEnvironment.getArgument("id");
            if (courseId == null)
                return courseService.findAllCourses();
            else {
                List<Course> info = new ArrayList<>();
                info.add(courseService.findById(Long.parseLong(courseId)));
                return info;
            }
        };
    }

    public DataFetcher<Course> getCourseByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return courseService.findById(Long.parseLong(id));
        };
    }

    public DataFetcher<List<Course>> getCoursesByNameDataFetcher() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return courseService.findByName(name);
        };
    }

    @Autowired
    public void setCourseService(CourseService courseService){
        this.courseService = courseService;
    }
}
