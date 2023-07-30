package example;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
   /* @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);

        ExamplePlugin plugin = new ExamplePlugin();
        Interceptor[] plugins = {plugin};
        sfb.setPlugins(plugins);

        SqlSessionFactory factory = sfb.getObject();
        //factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return factory;
    }*/
}
