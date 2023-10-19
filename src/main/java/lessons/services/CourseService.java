package lessons.services;

import lessons.daos.CourseDao;
import lessons.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {

    private CourseDao courseDao;

    public List<Course> findAllCourses(){
        Iterable<Course> info =  courseDao.findAll();
        return StreamSupport
                .stream(info.spliterator(),false)
                .collect(Collectors.toList());
    }

    public Course findById(Long id){
        Optional<Course> courseOptional = courseDao.findById(id);
        return courseOptional.orElse(null);
    }

    public List<Course> findByName(String name){
        return courseDao.findByName(name);
    }

    @Autowired
    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }
}
