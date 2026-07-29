package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //JDBC  ->  Java Database Connection
        String url = "jdbc:mysql://localhost:3306/db";

        Properties props = new Properties();
        props.setProperty("user", "root");
//        props.setProperty("password", "");
        props.setProperty("ssl", "true");
        try {
/*
            Connection conn = DriverManager.getConnection(url,
                    "root", "");
*/
            Connection conn = DriverManager.getConnection(url, props);
            Statement statement = conn.createStatement();

            String command = """
                CREATE TABLE IF NOT EXISTS people (
                    id INT PRIMARY KEY AUTO_INCREMENT,
                    name VARCHAR(255)
                )""";

            statement.execute(command);

        } catch (SQLException se) {
            System.out.println(se);
        }

    }
}