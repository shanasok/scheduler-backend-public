package lessons.entities.enums;

import lessons.entities.content.Code;
import lessons.entities.content.Definition;
import lessons.entities.content.Fact;
import lombok.Getter;

@Getter
public enum ContentType {

    DEFINITION(1L, "DEFINITION", Definition.class),
    FACT(2L, "FACT", Fact.class),
    CODE(3L,"CODE", Code.class);

    private final Long id;
    private final String tableName;
    private final Class tableClass;

    ContentType(Long id, String tableName, Class tableClass){
        this.id = id;
        this.tableName = tableName;
        this.tableClass = tableClass;
    }

}
