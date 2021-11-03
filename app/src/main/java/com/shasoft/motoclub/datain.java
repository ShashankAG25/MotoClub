package com.shasoft.motoclub;

public class datain {

    public String register_number , date_in;

    public  datain(){}

    public datain(String register_number, String date_in) {
        this.register_number = register_number;
        this.date_in = date_in;
    }

    public String getRegister_number() {
        return register_number;
    }

    public void setRegister_number(String register_number) {
        this.register_number = register_number;
    }

    public String getDate_in() {
        return date_in;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }


}
