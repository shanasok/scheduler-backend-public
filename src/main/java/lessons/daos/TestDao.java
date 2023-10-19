package lessons.daos;

import lessons.entities.TestInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestDao extends CrudRepository<TestInfo, Long> {

    @Query(" SELECT i " +
           " FROM TestInfo i " +
           " WHERE i.name=(:iName)")
    List<TestInfo> findByName(@Param("iName") String iName);
}
