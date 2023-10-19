package lessons.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class SnippetLanguageConverter implements AttributeConverter<SnippetLanguage, Long> {

    @Override
    public Long convertToDatabaseColumn(SnippetLanguage snippetLanguage) {
        if (snippetLanguage == null) {
            return null;
        }
        return snippetLanguage.getId();
    }

    @Override
    public SnippetLanguage convertToEntityAttribute(Long languageSnippetId) {
        if (languageSnippetId == null) {
            return null;
        }

        return Stream.of(SnippetLanguage.values())
                .filter(ls -> ls.getId().equals(languageSnippetId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
