package lessons.services;

import lessons.daos.SubjectDao;
import lessons.entities.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class SubjectService {

    private SubjectDao subjectDao;

    public List<Subject> findAllSubjects(){
        Iterable<Subject> info = subjectDao.findAll();
        return StreamSupport
                .stream(info.spliterator(),false)
                .collect(Collectors.toList());
    }

    public Subject findById(Long id){
        Optional<Subject> subjectOptional = subjectDao.findById(id);
        return subjectOptional.orElse(null);
    }

    public List<Subject> findByName(String name){
        return subjectDao.findByName(name);
    }

    public List<Subject> findByCourseId(Long courseId) {
        Iterable<Subject> info =  subjectDao.findByCourseId(courseId);
        return StreamSupport
                .stream(info.spliterator(),false)
                .collect(Collectors.toList());
    }

    @Autowired
    public void setSubjectDao(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }
}
