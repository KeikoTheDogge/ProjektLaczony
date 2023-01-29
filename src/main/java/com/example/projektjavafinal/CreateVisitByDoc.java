package com.example.projektjavafinal;

import entity.VisitsEntity;
import jakarta.persistence.Tuple;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class CreateVisitByDoc {
    private int lastVisitID() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet id = databaseConnection.result("SELECT MAX(visitID) from visits;");
        if (id.next()) {
            return id.getInt(1);
        } else {
            return 0;
        }
    }

    private int workHours(int ID) throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        ResultSet czas_pracy = databaseConnection.result("select work_hours from doctors where userID = '" + ID + "'");
        if (czas_pracy.next()) {
            return czas_pracy.getInt(1);
        } else {
            return 0;
        }
    }


    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        //System.out.println("Podaj godzinę wizyty");
        //String godzina = input.next();
        CreateVisitByDoc create = new CreateVisitByDoc();
        int d = create.workHours(6);
//        while (list.next()) {
//            String number = list.getString(1);
//            if (godzina.equals(number)) {
//                System.out.println("Masz już wizytę o takiej godzinie");
//                break;
//            } else {
//                System.out.println("Wszystko w porządku, byczku");
//                break;
//            }
//        }
        //list.close();
        double time = 0;
        while (true) {
            System.out.println("Podaj typ wizyty");
            String wizyta = input.next();
            switch (wizyta) {
                case "porada" -> time += 0.25;
                case "zabieg" -> time += 4;
                case "szczepienie" -> time += 0.5;
            }
            if (time > d) {
                System.out.println("Nie możesz wyświadczyć już większej ilości usług");
                break;
            }
        }
    }
}
