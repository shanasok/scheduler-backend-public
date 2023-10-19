package lessons.controllers;

import lessons.dtos.response.CourseResponse;
import lessons.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private CourseService courseService;

    @RequestMapping(value       = "/all",
                    method      = RequestMethod.GET,
                    consumes    = MediaType.APPLICATION_JSON_VALUE,
                    produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CourseResponse> getAllCourses() {
        CourseResponse response = new CourseResponse();
        response.setCourse(courseService.findAllCourses());
        response.setMessage("Successfully retrieved all courses");
        response.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Autowired
    public void setCourseService(CourseService courseService){
        this.courseService = courseService;
    }

}
