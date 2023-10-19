package lessons.controllers;

import lessons.dtos.response.TestInfoResponse;
import lessons.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    private TestService testService;

    @RequestMapping(value       = "/all",
                    method      = RequestMethod.GET,
                    consumes    = MediaType.APPLICATION_JSON_VALUE,
                    produces    = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TestInfoResponse> getAllTestInfo() {
        TestInfoResponse response = new TestInfoResponse();
        response.setTestInfo(testService.findAllTestInfo());
        response.setMessage("Successfully retrieved all test data");
        response.setSuccess(true);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Autowired
    public void setTestService(TestService testService){
        this.testService = testService;
    }
}
