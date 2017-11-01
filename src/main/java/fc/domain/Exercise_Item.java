package fc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

/**
 * Created by Justin on 26/10/2017.
 */
@Entity
@Table(name = "Exercise_Item") //Auto wiring can sometimes break due to case sensitivity on Table and Field names.
public class Exercise_Item {
    public Exercise_Item() {

    }
    public Exercise_Item(Long Exercise_ID) {
        this.Exercise_ID = Exercise_ID;
    }
    //public Clients(String username){
    //   this.username = username;
    // }

    // public Clients(String username, String Field, String Value){
    //   this.username = username;
    // }

    public Long getExercise_Item() { return Exercise_ID;
    }

    public void setExercise_ID() { this.Exercise_ID = Exercise_ID; }


    public String getExercise_Name() {
        return Exercise_Name;
    }

    public void setExercise_Name(String Exercise_Name){ this.Exercise_Name = Exercise_Name; }

    public String getExercise_Description() {
        return Exercise_Description;
    }

    public void setExercise_Description(String Exercise_Description) {
        this.Exercise_Description = Exercise_Description;
    }


    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }




    //@GeneratedValue(strategy = GenerationType.AUTO)


    /*@Temporal(TemporalType.TIMESTAMP)
    private Date event_time;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timerring_event_time;*/
    @Id
    // @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="SEQUENCE1")
    //  @SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
    // @Column(name = "Client_ID", insertable = false, updatable = false)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Exercise_ID;

    @Column(length = 64)
    private String Exercise_Name;

    @Column(length = 256)
    private String Exercise_Description;


}
