import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:integration.properties")
public class DBConfig {

    @Value("${spring.datasource.url}")
    String URL;

    @Value("${spring.datasource.username}")
    String USERNAME;

    @Value("${spring.datasource.password}")
    String PASSWORD;

    @Value("${spring.datasource.driverClassName}")
    String DRIVER_CLASSNAME;

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(DRIVER_CLASSNAME);
        dataSourceBuilder.url(URL);
        dataSourceBuilder.username(USERNAME);
        dataSourceBuilder.password(PASSWORD);
        return dataSourceBuilder.build();
    }


}
