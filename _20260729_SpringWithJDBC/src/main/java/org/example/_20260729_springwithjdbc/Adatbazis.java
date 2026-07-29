package org.example._20260729_springwithjdbc;

import java.io.Closeable;
import java.sql.*;

public class Adatbazis implements Closeable {
    Connection conn = null;

    public Adatbazis(String url, String username, String password) {
        try {
            conn = DriverManager.getConnection(url,
                    username, password);
            System.out.println("Sikerült kapcsolódni az adatbázishoz!");
        } catch (SQLException se) {
            System.out.println("Nem sikerült létrehozni a kapcsolatot! " + se.toString());
            throw new RuntimeException("Nem sikerült csatlakozni az adatbázishoz!");
        }
    }

    @Override
    protected void finalize() throws Throwable {
        if (conn != null) {
            conn.close();
            System.out.println("Sikerült lebontani az adatbázis kapcsolatot a finalizeból!");
        }
        System.out.println("Nem is kellett lebontani az adatbázis kapcsolatot a finalizeból!");
    }

    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException se) {
                System.out.println("Hiba: " + se.toString());
            }
            System.out.println("Sikerült lebontani az adatbázis kapcsolatot a closeból!");
        }
        System.out.println("Nem is kellett lebontani az adatbázis kapcsolatot a closeból!");
    }

    public boolean dropTable(String table) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS " + table + ";");
            System.out.println(table + " sikeresen eldobva!");
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült eldobni a tanulók táblát! " + se.toString());
            return false;
        }
    }

    public boolean selectTable(String table) {
        try {
            Statement  stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM " + table + ";");
            ResultSetMetaData meta = result.getMetaData();

            System.out.println();
            for(int i=1; i <= meta.getColumnCount(); ++i) {
                System.out.print(meta.getColumnName(i) + "    ");
            }
            System.out.println();
            System.out.println("---------------------------------------------------------------------------------");

            while(result.next()) {
//                System.out.println(result.getInt(1)  + "  " + result.getString(2) +
//                        "  " + result.getString(3) + "  " + result.getFloat(4) );
                for(int i=1; i <= meta.getColumnCount(); ++i) {
                    System.out.print(result.getString(i) + "    ");
                }
                System.out.println();
            }
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült a select! " + se.toString());
            return false;
        }
    }


    public Connection getConn() {
        return conn;
    }
}
