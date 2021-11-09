package Models;

import java.util.ArrayList;

public class SubDog {

    String status;
    ArrayList <String> message;

    public void setMessage(ArrayList<String> message) {
        this.message = message;
    }

    public ArrayList<String> getMessage() {
        return message;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
