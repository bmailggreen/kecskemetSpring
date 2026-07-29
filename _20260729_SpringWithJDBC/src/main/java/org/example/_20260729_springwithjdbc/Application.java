package org.example._20260729_springwithjdbc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public void runExistingDatabaseCode() {
        String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=UTC";
        try (Adatbazis ab = new Adatbazis(url, "root", "")) {
            TanulokTabla tt = new TanulokTabla(ab.getConn());
            Scanner sc = new Scanner(System.in);

            menuPont:
            while (true) {
                System.out.println("1. tanulók tábla eldobása");
                System.out.println("2. tanulók tábla létrehozása");
                System.out.println("3. tanulók táblába beszúrás");
                System.out.println("4. tanulók táblából törlés");
                System.out.println("5. tanulók táblában update");
                System.out.println("6. tanulók tábla selectje");
                System.out.println("7. kilépés");
                int menu = sc.nextInt();

                switch (menu) {
                    case 1:
                        ab.dropTable("tanulok");
                        break;
                    case 2:
                        tt.createTanulok();
                        break;
                    case 3:
                        tt.insertTanulokFromKeyboard();
                        break;
                    case 4:
                        System.out.println("Mi a tanuló id-ja, akit törölnénk: ");
                        tt.deleteTanulo(sc.nextInt());
                        break;
                    case 5:
                        System.out.println("Mi a tanuló id-ja, akit updatelnénk: ");
                        int originalId = sc.nextInt();
                        System.out.println("Mi legyen az új id: ");
                        int id = sc.nextInt();
                        System.out.println("Mi legyen az új vezetéknév: ");
                        String vn = sc.next();
                        System.out.println("Mi legyen az új keresztnév: ");
                        String kn = sc.next();
                        System.out.println("Mi legyen az új jegyátlag: ");
                        double ja = sc.nextDouble();
                        tt.updateTanulok(originalId, id, vn, kn, (float) ja);
                        break;
                    case 6:
                        ab.selectTable("tanulok");
                        break;
                    case 7:
                        break menuPont;
                }
            }
        } //End of database connection
    }


    @Override
    public void run(String... args) throws Exception {
        runExistingDatabaseCode();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
