package entity;

import jakarta.persistence.*;

import java.sql.Time;

@NamedQueries(
        {
                @NamedQuery(
                        name = "docSpec",
                        query = "from DoctorsEntity e where e.specialization = :specialization"
                )
        }
)
@Entity
@PrimaryKeyJoinColumn(name = "userID")
@Table(name = "doctors", schema = "nfz")
public class DoctorsEntity extends UsersEntity {
    @Id
    @Basic
    @Column(name = "userID")
    private Integer userId;
    @Basic
    @Column(name = "specialization")
    private String specialization;
    @Basic
    @Column(name = "work_for")
    private Time workFor;
    @Basic
    @Column(name = "work_to")
    private Time workTo;
    @Basic
    @Column(name = "work_hours")
    private Time workHours;

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public Time getWorkFor() {
        return workFor;
    }

    public void setWorkFor(Time workFor) {
        this.workFor = workFor;
    }

    public Time getWorkTo() {
        return workTo;
    }

    public void setWorkTo(Time workTo) {
        this.workTo = workTo;
    }

    public Time getWorkHours() {
        return workHours;
    }

    public void setWorkHours(Time workHours) {
        this.workHours = workHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DoctorsEntity that = (DoctorsEntity) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (specialization != null ? !specialization.equals(that.specialization) : that.specialization != null)
            return false;
        if (workFor != null ? !workFor.equals(that.workFor) : that.workFor != null) return false;
        if (workTo != null ? !workTo.equals(that.workTo) : that.workTo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        result = 31 * result + (workFor != null ? workFor.hashCode() : 0);
        result = 31 * result + (workTo != null ? workTo.hashCode() : 0);
        return result;
    }


}
