package lessons.dtos.response;

import lessons.entities.TestInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TestInfoResponse {

    private String message;
    private List<TestInfo> testInfo;
    private boolean success;

}
