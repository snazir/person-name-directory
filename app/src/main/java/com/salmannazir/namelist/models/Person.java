package com.salmannazir.namelist.models;

import org.json.JSONObject;

/**
 * Created by salmannazir on 30/09/2016.
 */

public class Person {

    private String firstName;
    private String lastName;

    public Person() {
    }
    public Person(JSONObject jsonObject) {

        try {

            this.firstName = jsonObject.optString("first_name");
            this.lastName = jsonObject.optString("last_name");

        }catch (Exception e){

            e.printStackTrace();
        }
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
