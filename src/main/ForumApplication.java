package main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class ForumApplication {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

    /**
     * Uncomment for execute dump-data.sql
     **/
//    @Bean
//    CommandLineRunner runner() {
//        return args -> {
//            Connection connection = DriverManager.getConnection(url, username, password);
//            ScriptUtils.executeSqlScript(connection, new ClassPathResource("sql/dump-data.sql"));
//        };
//    }
}
