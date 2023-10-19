package lessons.daos;

import lessons.entities.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageDao extends CrudRepository<Page, Long> {

    @Query(" SELECT page " +
           " FROM Page page " +
           " WHERE page.lesson=(:lessonID)")
    List<Page> findByLessonID(@Param("lessonID") String lessonID);

}
