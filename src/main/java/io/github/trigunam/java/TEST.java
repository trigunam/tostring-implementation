package io.github.trigunam.java;

import io.github.trigunam.java.util.Sensitive;
import io.github.trigunam.java.util.Utilities;

public class TEST {

    private  String name;

    private String Password;




    public TEST(String name, String description) {
        this.name = name;
        this.Password = description;
    }


    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }
    @Sensitive
    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }


    @Override
    public String toString() {
        return Utilities.toString(this);
    }




}
