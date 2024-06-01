package org.example;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

public class DatabasePopulateService {
    public static void main(String[] args) {
        try (Connection connection = Database.getInstance().getConnection();
             Statement stmt = connection.createStatement()) {

            String sql = new String(Files.readAllBytes(Paths.get("sql/populate_db.sql")));
            stmt.execute(sql);
            System.out.println("Database populated successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}