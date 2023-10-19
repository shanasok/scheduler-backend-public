package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.TestInfo;
import lessons.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GraphQLDataFetchers {

    private TestService testService;

    public DataFetcher getAllTestInfoDataFetcher() {
        return dataFetchingEnvironment -> {
            String testInfoId = dataFetchingEnvironment.getArgument("id");
            if (testInfoId == null)
                return testService.findAllTestInfo();
            else {
                List<TestInfo> info = new ArrayList<>();
                info.add(testService.findById(Long.parseLong(testInfoId)));
                return info;
            }
        };
    }

    public DataFetcher getTestInfoByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return testService.findById(Long.parseLong(id));
        };
    }

    @Autowired
    public void setTestService(TestService testService){
        this.testService = testService;
    }
}
