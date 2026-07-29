package org.example._20260729_jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
public class Application implements CommandLineRunner {
//    @Autowired
//    JdbcTemplate template;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String command = """
                CREATE TABLE IF NOT EXISTS lego ( 
                id INT PRIMARY KEY AUTO_INCREMENT
                );""";
//        template.execute(command);
        JdbcTemplate template = new JdbcTemplate(dataSource());
        template.execute(command);

        String createCommand = """
                CREATE TABLE IF NOT EXISTS students ( 
                id INT PRIMARY KEY AUTO_INCREMENT,
                name VARCHAR(500)
                );""";
        template.execute(createCommand);

        for (int i = 0; i < 100; i++) {
            String insertCommand = "INSERT INTO students(name) values ('Józsi');";
            template.execute(insertCommand);
        }

        String queryCommand = "SELECT * FROM students;";
        List<Student> students = template.query(queryCommand, new StudentRowMapper());
//        System.out.println(students);
        students.forEach(System.out::println);

    }

    //Kreál nekem egy datasource-t.
    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/db");
        dataSource.setUsername("root");
//        dataSource.setPassword("");
        return dataSource;
    }


}
