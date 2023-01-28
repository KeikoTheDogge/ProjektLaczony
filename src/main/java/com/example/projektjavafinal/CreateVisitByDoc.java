package com.example.projektjavafinal;

import Login.Authentication;
import entity.DoctorsEntity;
import entity.UsersEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateVisitByDoc {

    private DatabaseConnection connection() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        return databaseConnection;
    }

    private int lastVisitID() throws SQLException {
        ResultSet id = connection().result("SELECT MAX(visitID) from visits;");
        if (id.next()) {
            return id.getInt(1);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj login");
        String login = input.next();
        System.out.println("Podaj hasło");
        String haslo = input.next();
        DatabaseConnection databaseConnection = new DatabaseConnection();
        CreateVisitByDoc createVisitByDoc = new CreateVisitByDoc();
        int id = createVisitByDoc.lastVisitID();
        Authentication authentication = new Authentication();
        UsersEntity user = authentication.authenticate(login, haslo);
        if (user instanceof DoctorsEntity) {
            System.out.println("Podaj datę wizyty");
            String date = input.next();
            System.out.println("Podaj godzinę wizyty");
            String time = input.next();
            System.out.println("Podaj typ wizyty");
            String type = input.next();
            int nextId = id + 1;
            databaseConnection.addEmptyVisit("INSERT INTO visits(visitId, date, time, doctorId, type) VALUES (" + nextId + ",'" +
                    date + "','" + time + "','" + user.getUserId() + "','" + type +"')");
            System.out.println("Wizyta dodana");
        }
        else {
            System.out.println("wypierdalaj");
        }
    }
}
