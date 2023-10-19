package lessons.daos;

import lessons.entities.content.PageContent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageContentDao extends CrudRepository<PageContent, Long> {

    @Query(" SELECT pageContent " +
           " FROM PageContent pageContent " +
           " WHERE pageContent.page=(:pageID)")
    List<PageContent> findByPageID(@Param("pageID") String pageID);

}
