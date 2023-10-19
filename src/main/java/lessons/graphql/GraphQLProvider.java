package lessons.graphql;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.TypeResolutionEnvironment;
import graphql.schema.GraphQLObjectType;
import graphql.schema.GraphQLSchema;
import graphql.schema.TypeResolver;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lessons.entities.content.Definition;
import lessons.entities.content.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

@Component
public class GraphQLProvider {

    private GraphQL graphQL;
    private GraphQLDataFetchersCourse graphQLDataFetchersCourse;
    private GraphQLDataFetchersLesson graphQLDataFetchersLesson;
    private GraphQLDataFetchersContent graphQLDataFetchersContent;
    private GraphQLDataFetchersPageContent graphQLDataFetchersPageContent;

    @Bean
    public GraphQL graphQL(){
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        String sdl = Resources.toString(Resources.getResource("courseSchema.graphqls"), Charsets.UTF_8);
        GraphQLSchema graphQLSchema = makeSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema makeSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    TypeResolver t =  new TypeResolver() {
        @Override
        public GraphQLObjectType getType(TypeResolutionEnvironment env) {
            Object javaObject = env.getObject();
            if (javaObject instanceof Fact) {
                return env.getSchema().getObjectType("Fact");
            } else if (javaObject instanceof Definition) {
                return env.getSchema().getObjectType("Definition");
            } else {
                return env.getSchema().getObjectType("Fact");
            }
        }
    };

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type(newTypeWiring("RootQueries")
                        .dataFetcher("allCourses", graphQLDataFetchersCourse.getAllCoursesDataFetcher())
                        .dataFetcher("findCourseById", graphQLDataFetchersCourse.getCourseByIdDataFetcher())
                        .dataFetcher("findCoursesByName", graphQLDataFetchersCourse.getCoursesByNameDataFetcher())
                        .dataFetcher("allLessons", graphQLDataFetchersLesson.getAllLessonsDataFetcher())
                        .dataFetcher("findLessonById", graphQLDataFetchersLesson.getLessonByIdDataFetcher())
                        .dataFetcher("findLessonsByName", graphQLDataFetchersLesson.getLessonsByNameDataFetcher())
                        .dataFetcher("getContentById", graphQLDataFetchersContent.getContentByIdDataFetcher())
                )
                .type(newTypeWiring("RootMutations")
                        .dataFetcher("updatePageContent", graphQLDataFetchersPageContent.updatePageContent())
                        .dataFetcher("updateFact", graphQLDataFetchersContent.updateFact())
                        .dataFetcher("updateDefinition", graphQLDataFetchersContent.updateDefinition())
                 )
                .type(newTypeWiring("Course")
                        .dataFetcher("course", graphQLDataFetchersCourse.getCourseByIdDataFetcher())
                )
                .type("Content", typeWriting ->
                        typeWriting
                                .typeResolver(t)
                )
                .build();
    }

    @Autowired
    public void setGraphQLDataFetchersCourse(GraphQLDataFetchersCourse graphQLDataFetchersCourse) {
        this.graphQLDataFetchersCourse = graphQLDataFetchersCourse;
    }

    @Autowired
    public void setGraphQLDataFetchersLesson(GraphQLDataFetchersLesson graphQLDataFetchersLesson) {
        this.graphQLDataFetchersLesson = graphQLDataFetchersLesson;
    }

    @Autowired
    public void setGraphQLDataFetchersPageContent(GraphQLDataFetchersPageContent graphQLDataFetchersPageContent) {
        this.graphQLDataFetchersPageContent = graphQLDataFetchersPageContent;
    }

    @Autowired
    public void setGraphQLDataFetchersContent(GraphQLDataFetchersContent graphQLDataFetchersContent) {
        this.graphQLDataFetchersContent = graphQLDataFetchersContent;
    }
}
