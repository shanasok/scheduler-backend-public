package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.content.Content;
import lessons.entities.content.Definition;
import lessons.entities.content.Fact;
import lessons.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class GraphQLDataFetchersContent {

    private ContentService contentService;

    public DataFetcher<Content> getContentByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return contentService.findById(Long.parseLong(id));
        };
    }

    public DataFetcher<Content> updateContentDataFetcher(){
        return dataFetchingEnvironment -> {
            Content content = dataFetchingEnvironment.getArgument("content");
            return contentService.update(content);
        };
    }

    public DataFetcher<Content> updateFact(){
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("contentId");
            String newFactStr = dataFetchingEnvironment.getArgument("fact");
            System.out.println("id is: "+id);
            Content oldContent = contentService.findById(Long.parseLong(id));
            if (oldContent instanceof Fact)
                ((Fact) oldContent).setFact(newFactStr);
            return contentService.update(oldContent);
        };
    }


    public DataFetcher<Content> updateDefinition(){
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("contentId");
            String newTerm = dataFetchingEnvironment.getArgument("term");
            String newExplanation = dataFetchingEnvironment.getArgument("explanation");
            Content oldContent = contentService.findById(Long.parseLong(id));
            if (oldContent instanceof Definition){
                ((Definition) oldContent).setTerm(newTerm);
                ((Definition) oldContent).setExplanation(newExplanation);
            }
            return contentService.update(oldContent);
        };
    }

    @Autowired
    public void setContentService(ContentService contentService){
        this.contentService = contentService;
    }
}
