package lessons.services;

import lessons.ApplicationTests;
import lessons.entities.Page;
import lessons.entities.content.Content;
import lessons.entities.content.Definition;
import lessons.entities.content.Fact;
import lessons.entities.content.PageContent;
import lessons.entities.enums.ContentType;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class PageServiceTest  extends ApplicationTests {

    @Autowired
    PageService pageService;

    private Page mockedPage;
    private List<PageContent> pageContentList;
    private PageContent mockPageContent1, mockPageContent2, mockPageContent3;
    private Fact mockContentFact1, mockContentFact3;
    private Definition mockContentDefinition2;

    @Before
    public void setup() {

        mockContentFact1 = mock(Fact.class);
        when(mockContentFact1.getId()).thenReturn(1L);
        when(mockContentFact1.getContentType()).thenReturn(ContentType.FACT);
        when(mockContentFact1.getFact()).thenReturn("Fact1");

        mockContentDefinition2 = mock(Definition.class);
        when(mockContentDefinition2.getId()).thenReturn(2L);
        when(mockContentDefinition2.getContentType()).thenReturn(ContentType.DEFINITION);
        when(mockContentDefinition2.getTerm()).thenReturn("Term2");
        when(mockContentDefinition2.getExplanation()).thenReturn("Explanation2");

        mockContentFact3 = mock(Fact.class);
        when(mockContentFact3.getId()).thenReturn(3L);
        when(mockContentFact3.getContentType()).thenReturn(ContentType.FACT);
        when(mockContentFact3.getFact()).thenReturn("Fact3");

        mockPageContent1 = mock(PageContent.class);
        when(mockPageContent1.getId()).thenReturn(1L);
        when(mockPageContent1.getContentNumber()).thenReturn(1L);
        when(mockPageContent1.getPage()).thenReturn(mockedPage);
        when(mockPageContent1.getContent()).thenReturn(mockContentFact1);

        mockPageContent2 = mock(PageContent.class);
        when(mockPageContent2.getId()).thenReturn(2L);
        when(mockPageContent2.getContentNumber()).thenReturn(2L);
        when(mockPageContent2.getPage()).thenReturn(mockedPage);
        when(mockPageContent2.getContent()).thenReturn(mockContentDefinition2);

        mockPageContent3 = mock(PageContent.class);
        when(mockPageContent3.getId()).thenReturn(3L);
        when(mockPageContent3.getContentNumber()).thenReturn(3L);
        when(mockPageContent3.getPage()).thenReturn(mockedPage);
        when(mockPageContent3.getContent()).thenReturn(mockContentFact3);

        pageContentList = new ArrayList<>();
        pageContentList.add(mockPageContent1);
        pageContentList.add(mockPageContent2);
        pageContentList.add(mockPageContent3);

        mockedPage = mock(Page.class);
        when(mockedPage.getId()).thenReturn(1L);
        when(mockedPage.getPageNumber()).thenReturn(1L);
        when(mockedPage.getPageContent()).thenReturn(pageContentList);
    }

//    public void updatePageTest_updatesAllPageContents(){
//        pageService.updatePage(mockedPage);
//        verify(mockPageContent1, times(1)).getContent();
//    }
}
