package lessons.services;

import lessons.daos.PageContentDao;
import lessons.entities.content.PageContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class PageContentService {

    private PageContentDao pageContentDao;

    public PageContent findById(Long id){
        Optional<PageContent> pageContentOptional = pageContentDao.findById(id);
        return pageContentOptional.orElse(null);
    }

    public PageContent updatePageContent(@NotNull PageContent pageContent){
        return pageContentDao.save(pageContent);
    }

    @Autowired
    public void setPageContentDao(PageContentDao pageContentDao) {
        this.pageContentDao = pageContentDao;
    }
}
