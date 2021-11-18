package org.example.Models;

import java.util.ArrayList;

public class DogList {
    ArrayList<ArrayList<Object>> message = new ArrayList<ArrayList<Object>>();
    String status;

    public void setMessage(ArrayList<ArrayList<Object>> message) {
        this.message = message;
    }

    public ArrayList<ArrayList<Object>> getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

