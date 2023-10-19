package lessons.controllers;

import lessons.dtos.response.LessonResponse;
import lessons.services.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
public class LessonController {

    private LessonService lessonService;

    @RequestMapping(value       = "/all",
                    method      = RequestMethod.GET,
                    consumes    = MediaType.APPLICATION_JSON_VALUE,
                    produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LessonResponse> getAllLessonInfo() {
        LessonResponse response = new LessonResponse();
        response.setLesson(lessonService.findAllLessons());
        response.setMessage("Successfully retrieved all lessons");
        response.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Autowired
    public void setLessonService(LessonService lessonService){
        this.lessonService = lessonService;
    }

}
