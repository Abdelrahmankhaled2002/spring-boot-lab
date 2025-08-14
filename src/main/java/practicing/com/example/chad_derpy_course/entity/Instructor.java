package practicing.com.example.chad_derpy_course.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Instructor")
public class Instructor {
    @Id
    @Column(name="Ins_Id")
    private int insId;

    @Column(name="Ins_Name")
    private String insName;
    @Column(name = "Ins_Degree")
    private String insDegree;

    public Instructor(String fname, String InsDegree,int insId) {
        this.insName = fname;
        this.insDegree =InsDegree;
        this.insId = insId;
    }
    public Instructor() {}


    public String getInsName() {
        return insName;
    }

    public void setInsName(String insName) {
        this.insName = insName;
    }

    public String getInsDegree() {
        return insDegree;
    }

    public void setInsDegree(String insDegree) {
        this.insDegree = insDegree;
    }

    public int getInsId() {
        return insId;
    }

    public void setInsId(int SSN) {
        this.insId = SSN;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "SSN=" + insId +
                ", Fname='" + insName + '\'' +
                ", InsDegree='" + insDegree + '\'' +
                '}';
    }
}
