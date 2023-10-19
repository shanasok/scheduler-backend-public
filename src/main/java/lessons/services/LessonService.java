package lessons.services;

import lessons.daos.LessonDao;
import lessons.entities.Lesson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LessonService {

    private LessonDao lessonDao;

    public List<Lesson> findAllLessons(){
        Iterable<Lesson> info = lessonDao.findAll();
        return StreamSupport
                .stream(info.spliterator(),false)
                .collect(Collectors.toList());
    }

    public Lesson findById(Long id){
        Optional<Lesson> lessonOptional = lessonDao.findById(id);
        setPageContentIsEditableFalse(lessonOptional);
        return lessonOptional.orElse(null);
    }

    public void setPageContentIsEditableFalse(Optional<Lesson> lessonOptional){
        if (lessonOptional.isPresent())
            lessonOptional.get().getPages().stream().forEach(
                    page -> page.getPageContent().stream().forEach(
                            pageContent -> pageContent.setIsEditable(Boolean.FALSE)
                    )
            );
    }

    public List<Lesson> findByName(String name){
        return lessonDao.findByName(name);
    }

    @Autowired
    public void setLessonDao(LessonDao lessonDao) {
        this.lessonDao = lessonDao;
    }
}
