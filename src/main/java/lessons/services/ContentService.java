package lessons.services;

import lessons.daos.ContentDao;
import lessons.entities.content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ContentService {

    private ContentDao contentDao;

    public Content findById(Long id){
        Optional<Content> contentOptional = contentDao.findById(id);
        return contentOptional.orElse(null);
    }

    public Content update(Content content){
        return contentDao.save(content);
    }

    @Autowired
    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }
}
