package lessons.daos;

import lessons.ApplicationTests;
import lessons.entities.TestInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TestDaoTest extends ApplicationTests {

    @Autowired
    private TestDao testDao;

    @Test
    public void readEntity(){
        List<TestInfo> result = testDao.findByName("Test1");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals("Test1", result.get(0).getName());
        assertEquals("Test1", result.get(1).getName());
    }

}
