package Visits;

import entity.DoctorsEntity;
import java.sql.SQLException;

public class DoctorWork {
    int time;

    public void WorkHour() {
        if (time > 8) {
            System.out.println("Twój czas pracy przekracza wpisany w bazę");
        }
    }

    public DoctorsEntity WorkFromTo(int ID) throws SQLException {
        return null;
    }

}
