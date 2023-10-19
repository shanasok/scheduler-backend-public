package lessons.services;

import lessons.daos.PageDao;
import lessons.entities.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
public class PageService {

    private PageDao pageDao;

    public Page findById(Long id){
        Optional<Page> pageOptional = pageDao.findById(id);
        return pageOptional.orElse(null);
    }

    public Page updatePage(@NotNull Page page){
        return pageDao.save(page);
    }

    @Autowired
    public void setPageDao(PageDao pageDao) {
        this.pageDao = pageDao;
    }
}
