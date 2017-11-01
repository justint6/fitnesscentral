package fc.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by Justin on 8/09/2017.
 */

    @Entity
    @Table(name = "Register") //Auto wiring can sometimes break due to case sensitivity on Table and Field names.
    public class Register {

        public Register() {

        }
        public Register(Integer Record_ID) {
            this.Record_ID = Record_ID;
        }

        public Integer getRecord_ID() { return Record_ID; }

        public void setRecord_ID() { this.Record_ID = Record_ID; }

        public Integer getClient_ID() {
            return Client_ID;
        }

        public void setClient_ID(Integer Client_IR){ this.Client_ID = Client_ID; }

        public Date getRecord_Date() {
            return Record_Date;
        }

        public void setRecord_Date(Date Record_Date) {
            this.Record_Date = Record_Date;
        }

        public Integer getTraining_Session_ID() {
            return Training_Session_ID;
        }

        public void setTraining_Session_ID(Integer Training_Session_ID) {
            this.Training_Session_ID = Training_Session_ID;
        }

        public String getSession_Type() {
            return Session_Type;
        }

        public void setSession_Type(String Session_Type) {
            this.Session_Type = Session_Type;
        }

        public String getStatus() {
            return Status;
        }

        public void setStatus(String Status) {
            this.Status = Status;
        }

        public Integer getGroup_ID() { return Group_ID; }

        public void setGroup_ID(Integer Group_ID) { this.Group_ID = Group_ID; }


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
        //@SequenceGenerator(name="SEQUENCE1", sequenceName="SEQUENCE1", allocationSize=1)
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Integer Record_ID;
        @Column
        private Integer Client_ID;

        @Column
        private Date Record_Date;

        @Column
        private Integer Training_Session_ID;

        @Column(length = 64)
        private String Session_Type;

        @Column(length = 64)
        private String Status;

        private Integer Group_ID;


    }
