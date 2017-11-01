package fc.controller;

import java.util.List;

/**
 * Created by Justin on 7/09/2017.
 */
public class ClientsForm {

    private List<Integer> Client_ID;
    private List<String> First_Name;
    private List<Integer> Phone_Number;





    public List<Integer> getClient_ID() { return Client_ID; }
    public void setClient_ID(List<Integer> Client_ID) { this.Client_ID = Client_ID; }


    public List<String> getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(List<String> First_Name) {
        this.First_Name = First_Name;
    }

    public List<Integer> getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(List<Integer> Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

}
