package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.Lesson;
import lessons.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GraphQLDataFetchersLesson {

    private LessonService lessonService;

    public DataFetcher<List<Lesson>> getAllLessonsDataFetcher() {
        return dataFetchingEnvironment -> {
            String lessonId = dataFetchingEnvironment.getArgument("id");
            if (lessonId == null)
                return lessonService.findAllLessons();
            else {
                List<Lesson> info = new ArrayList<>();
                info.add(lessonService.findById(Long.parseLong(lessonId)));
                return info;
            }
        };
    }

    public DataFetcher<Lesson> getLessonByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return lessonService.findById(Long.parseLong(id));
        };
    }

    public DataFetcher<List<Lesson>> getLessonsByNameDataFetcher() {
        return dataFetchingEnvironment -> {
            String name = dataFetchingEnvironment.getArgument("name");
            return lessonService.findByName(name);
        };
    }

    @Autowired
    public void setLessonService(LessonService lessonService){
        this.lessonService = lessonService;
    }
}
