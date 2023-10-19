package lessons.daos;

import lessons.entities.content.Content;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentDao extends CrudRepository<Content, Long> {

}
