package Visits;

public class Visit {
    String name;
    double time;

    public Visit(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public void VisitType() {
        switch (name) {
            case "porada" -> time = 0.25;
            case "zabieg" -> time = 1;
            case "szczepienie" -> time = 0.5;
        }
    }

    public void WorkHour() {
        if (time > 8) {
            System.out.println("Twój czas pracy przekracza wpisany w bazę");
        }
    }


}
