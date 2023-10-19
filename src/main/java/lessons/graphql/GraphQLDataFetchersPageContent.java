package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.content.Fact;
import lessons.entities.content.PageContent;
import lessons.services.PageContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class GraphQLDataFetchersPageContent {

    private PageContentService pageContentService;

    public DataFetcher<PageContent> getPageContentByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return pageContentService.findById(Long.parseLong(id));
        };
    }

    public DataFetcher<PageContent> updatePageContent() {
        return dataFetchingEnvironment -> {
            PageContent pageContent = pageContentService.findById(Long.parseLong(dataFetchingEnvironment.getArgument("contentId")));
            if (pageContent.getContent() instanceof Fact){
                ((Fact) pageContent.getContent()).setFact(dataFetchingEnvironment.getArgument("fact"));
            }

            Optional<PageContent> pageContentOptional = Optional.of(pageContentService.updatePageContent(pageContent));
            return pageContentOptional.orElse(null);
        };
    }

    @Autowired
    public void setPageContentService(PageContentService pageContentService){
        this.pageContentService = pageContentService;
    }
}
