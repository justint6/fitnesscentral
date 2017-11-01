package fc.domain;

/**
 * Created by Justin on 3/09/2017.
 */

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Clients") //Auto wiring can sometimes break due to case sensitivity on Table and Field names.
public class Clients {
    public Clients() {

    }
    public Clients(Long Client_ID) {
        this.Client_ID = Client_ID;
    }
    //public Clients(String username){
     //   this.username = username;
   // }

   // public Clients(String username, String Field, String Value){
     //   this.username = username;
   // }

    public Long getClient() { return Client_ID;
    }

    public void setClient_ID() { this.Client_ID = Client_ID; }


    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name){ this.First_Name = First_Name; }

    public String getClient_Address() {
        return Client_Address;
    }

    public void setClient_Address(String Client_Address) {
        this.Client_Address = Client_Address;
    }

    public Integer getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(Integer Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public Integer getMobile_Number() {
        return Mobile_Number;
    }

    public void setMobile_Number(Integer Mobile_Number) {
        this.Mobile_Number = Mobile_Number;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String Email_Address) {
        this.Email_Address = Email_Address;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long Client_ID;

    @Column(length = 64)
    private String First_Name;

    @Column(length = 128)
    private String Client_Address;

    private Integer Phone_Number;

    private Integer Mobile_Number;

    @Column(length = 128)
    private String Email_Address;

}

