package lessons.services;

import lessons.daos.TestDao;
import lessons.entities.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TestService {

    private TestDao testDao;

    public List<TestInfo> findAllTestInfo(){
        Iterable<TestInfo> info =  testDao.findAll();
        return StreamSupport
                .stream(info.spliterator(),false)
                .collect(Collectors.toList());
    }

    public TestInfo findById(Long id){
        Optional<TestInfo> testOptional = testDao.findById(id);
        return testOptional.orElse(null);
    }

    public List<TestInfo> findByName(String name){
        return testDao.findByName(name);
    }

    @Autowired
    public void setTestDao(TestDao testDao) {
        this.testDao = testDao;
    }
}
