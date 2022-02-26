package com.example.phonedemo1;

public class DataModel1 {
    private int id ;
    private String name ;
    private String Phone_number;
    private String age;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    private String mail;

    private boolean is_Active ;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isIs_Active() {
        return is_Active;
    }

    public void setIs_Active(boolean is_Active) {
        this.is_Active = is_Active;
    }

    public DataModel1(int id, String name, String phone_number, String age, String mail, boolean is_Active) {
        this.id = id;
        this.name = name;
        Phone_number = phone_number;
        this.age = age;
        this.mail = mail;
        this.is_Active = is_Active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return Phone_number;
    }

    public void setPhone_number(String phone_number) {
        Phone_number = phone_number;
    }

    @Override
    public String toString() {
        return "DataModel1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Phone_number='" + Phone_number + '\'' +
                ", is_Active=" + is_Active +
                '}';
    }
}
