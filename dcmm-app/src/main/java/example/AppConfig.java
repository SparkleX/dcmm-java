package example;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import example.foo.ExamplePlugin;

@Configuration
public class AppConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean sfb = new SqlSessionFactoryBean();
        sfb.setDataSource(dataSource);

        //Properties prop = new Properties();
        //prop.setProperty("dialect", "mysql");

        //PageHelper pagePlugin = new PageHelper();
        //pagePlugin.setProperties(prop);

        ExamplePlugin plugin = new ExamplePlugin();
        Interceptor[] plugins = {plugin};
        sfb.setPlugins(plugins);

        SqlSessionFactory factory = sfb.getObject();
        //factory.getConfiguration().setMapUnderscoreToCamelCase(true);
        return factory;
    }
}
