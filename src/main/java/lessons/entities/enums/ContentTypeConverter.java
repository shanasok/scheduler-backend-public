package lessons.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ContentTypeConverter implements AttributeConverter<ContentType, Long> {

    @Override
    public Long convertToDatabaseColumn(ContentType contentType) {
        if (contentType == null) {
            return null;
        }
        return contentType.getId();
    }

    @Override
    public ContentType convertToEntityAttribute(Long contentTypeId) {
        if (contentTypeId == null) {
            return null;
        }

        return Stream.of(ContentType.values())
                .filter(ls -> ls.getId().equals(contentTypeId))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
