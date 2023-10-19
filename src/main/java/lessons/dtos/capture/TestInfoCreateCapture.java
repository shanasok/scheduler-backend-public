package lessons.dtos.capture;

import lessons.entities.TestInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TestInfoCreateCapture {

    protected Long id;

    protected String name;

    public TestInfo populateTestInfo(){
        TestInfo testInfo = new TestInfo();
        testInfo.setId(this.getId());
        testInfo.setName(this.getName());
        return testInfo;
    }

}

