package org.example._20260729_springwithjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TanulokTabla {
    Connection conn = null;

    public TanulokTabla(Connection conn) {
        this.conn = conn;
    }

    public boolean createTanulok() {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE TABLE IF NOT EXISTS tanulok " +
                    "(id int PRIMARY KEY, vezeteknev VARCHAR(50), " +
                    "keresztnev VARCHAR(50), jegyatlag FLOAT);");
            System.out.println("Tanulók tábla létrehozva!");
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült eldobni a tanulók táblát! " + se.toString());
            return false;
        }
    }

    public boolean insertTanulok(int id, String vezeteknev, String keresztnev, float jegyatlag) {
        try {
            PreparedStatement pstm = conn.prepareStatement("INSERT INTO tanulok VALUES " +
                    "(?, ?, ?, ?);");
            pstm.setInt(1, id);
            pstm.setString(2, vezeteknev);
            pstm.setString(3, keresztnev);
            pstm.setFloat(4, jegyatlag);
            System.out.println("Az insert utasítás: " + pstm.toString());
            pstm.execute();
            System.out.println("Sikerült a beszúrás!");
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült az insert! " + se.toString());
            return false;
        }
    }


    public void insertTanulokFromKeyboard() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Szeretne újabb tanulót beszúrnia  táblába? i/n");
            char kilepE = sc.next().charAt(0);
            if (kilepE == 'n') {
                break;
            }
            System.out.println("Kérem a tanuló id-ját: ");
            int id = sc.nextInt();
            System.out.println("Kérem a tanuló vezetéknevét: ");
            String vn = sc.next();
            System.out.println("Kérem a tanuló keresztnevét: ");
            String kn = sc.next();
            System.out.println("Kérem a tanuló jegyeinek az átlagát: ");
            double jegyatlag = sc.nextDouble();

            insertTanulok(id, vn, kn, (float)jegyatlag);
        }
    }

    public boolean deleteTanulo(int id) {
        try {
            PreparedStatement pstm = conn.prepareStatement("DELETE FROM tanulok WHERE " +
                    "id = ?");
            pstm.setInt(1, id);

            System.out.println("A delete utasítás: " + pstm.toString());
            pstm.execute();
            System.out.println("Sikerült a törlés!");
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült az törlés! " + se.toString());
            return false;
        }
    }

    public boolean updateTanulok(int originalId, int id, String vezeteknev, String keresztnev, float jegyatlag) {
        try {
            PreparedStatement pstm = conn.prepareStatement("UPDATE tanulok SET " +
                    "id = ?,  vezeteknev = ?, keresztnev = ?, jegyatlag = ? " +
                    "WHERE id = ?;");
            pstm.setInt(1, id);
            pstm.setString(2, vezeteknev);
            pstm.setString(3, keresztnev);
            pstm.setFloat(4, jegyatlag);
            pstm.setInt(5, originalId);
            System.out.println("Az update utasítás: " + pstm.toString());
            pstm.execute();
            System.out.println("Sikerült az update!");
            return true;
        } catch (SQLException se) {
            System.out.println("Nem sikerült az update! " + se.toString());
            return false;
        }
    }


}

