package com.example.projektjavafinal;

import entity.VisitsEntity;

import java.sql.Date;
import java.sql.Time;


public class CreateVisitByDoc {


    private final DatabaseSession databaseSession;

    public CreateVisitByDoc(DatabaseSession databaseSession) {
        this.databaseSession = databaseSession;
    }

    public void addNewVisit(int doctorId, String visitType, Date visitDate, Time visitTime) {
        VisitsEntity newVisit = new VisitsEntity();
        newVisit.setType(visitType);
        newVisit.setDate(visitDate);
        newVisit.setTime(visitTime);
        newVisit.setDoctorId(doctorId);
        databaseSession.saveObject(newVisit);
    }

    public static void main(String[] args) {
        int doctorId = 3;
        DatabaseSession databaseSession = new DatabaseSession();
        databaseSession.openSession();
        CreateVisitByDoc create = new CreateVisitByDoc(databaseSession);
        AddVisitCommand addVisitCommand = new AddVisitCommand();

        String visitType = addVisitCommand.getVisitType();
        Date date = addVisitCommand.getVisitData();
        Time time = addVisitCommand.getVisitTime();

        create.addNewVisit(doctorId, visitType, date, time);
        databaseSession.closeSession();
    }
}
