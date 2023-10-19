package lessons.services;

import lessons.ApplicationTests;
import lessons.entities.TestInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestInfoServiceTest extends ApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void testFindAllTestInfo(){
        List<TestInfo> allTestInfo = testService.findAllTestInfo();
        assertNotNull(allTestInfo);
        assertTrue((allTestInfo).size() > 0);
    }


}
