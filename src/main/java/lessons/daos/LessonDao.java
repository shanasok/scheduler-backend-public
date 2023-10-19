package lessons.daos;

import lessons.entities.Lesson;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonDao extends CrudRepository<Lesson, Long> {

    @Query(" SELECT lesson " +
           " FROM Lesson lesson " +
           " WHERE lesson.name=(:lessonName)")
    List<Lesson> findByName(@Param("lessonName") String lessonName);

}
