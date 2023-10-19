package lessons.daos;

import lessons.entities.Subject;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectDao extends CrudRepository<Subject, Long> {

    @Query(" SELECT s " +
           " FROM Subject s " +
           " WHERE s.name=(:sName)")
    List<Subject> findByName(@Param("sName") String sName);

    @Query(" SELECT s " +
            " FROM Subject s " +
            " WHERE s.course=(:courseId)")
    List<Subject> findByCourseId(@Param("courseId") Long courseId);


}
