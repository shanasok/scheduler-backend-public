package lessons.daos;

import lessons.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseDao extends CrudRepository<Course, Long> {

    @Query(" SELECT c " +
           " FROM Course c " +
           " WHERE c.name=(:cName)")
    List<Course> findByName(@Param("cName") String cName);

}
