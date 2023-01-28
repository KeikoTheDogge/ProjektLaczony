package entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@org.hibernate.annotations.NamedQueries(
        {
                @org.hibernate.annotations.NamedQuery(name="getVisitBySpecialisation",
                        query="select v, u from VisitsEntity v inner join UsersEntity u on v.doctorId = u.id inner join DoctorsEntity d on u.id = d.userId where d.specialization = :spec and v.patientId = null")
        }
)

@Entity
@Table(name = "visits", schema = "nfz")
public class VisitsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "visitId")
    private int visitId;
    @Basic
    @Column(name = "date")
    private Date date;
    @Basic
    @Column(name = "time")
    private Time time;
    @Basic
    @Column(name = "doctorId")
    private int doctorId;
    @Basic
    @Column(name = "patientId")
    private Integer patientId;

    public int getVisitId() {
        return visitId;
    }

    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitsEntity that = (VisitsEntity) o;

        if (visitId != that.visitId) return false;
        if (doctorId != that.doctorId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (time != null ? !time.equals(that.time) : that.time != null) return false;
        if (patientId != null ? !patientId.equals(that.patientId) : that.patientId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = visitId;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + doctorId;
        result = 31 * result + (patientId != null ? patientId.hashCode() : 0);
        return result;
    }
}
