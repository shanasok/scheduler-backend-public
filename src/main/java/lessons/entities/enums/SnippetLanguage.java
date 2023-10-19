package lessons.entities.enums;

import lombok.Getter;

@Getter
public enum SnippetLanguage {

    JAVA(1L,"Java"),
    JAVASCRIPT(2L, "JavaScript"),
    HTML(3L, "HTML"),
    CSS(4L, "CSS");

    private Long id;
    private String friendlyType;

    SnippetLanguage(Long id, String friendlyType) {
        this.id= id;
        this.friendlyType = friendlyType;
    }
}
