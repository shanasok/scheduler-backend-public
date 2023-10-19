package lessons.graphql;

import graphql.schema.DataFetcher;
import lessons.entities.Page;
import lessons.entities.content.Content;
import lessons.entities.content.PageContent;
import lessons.services.ContentService;
import lessons.services.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class GraphQLDataFetchersPage {

    private PageService pageService;

    public DataFetcher<Page> getPageByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String id = dataFetchingEnvironment.getArgument("id");
            return pageService.findById(Long.parseLong(id));
        };
    }

    public DataFetcher<Page> updatePage(Page page) {
        return dataFetchingEnvironment -> {
            Optional<Page> pageOptional = Optional.of(pageService.updatePage(page));
            return pageOptional.orElse(null);
        };
    }

    @Autowired
    public void setPageService(PageService pageService){
        this.pageService = pageService;
    }
}
