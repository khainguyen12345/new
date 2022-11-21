package com.example.database_recy;

public class UsersModel {
    private int user_id;
    private String username;
    private String password;
    private String note;
    private String number;
    private String email;
    private long money;
    private String thu_chi;
    private String date;


    public UsersModel(String date, String note, long money , String thu_chi) {
        this.note = note;
        this.money = money;
        this.thu_chi = thu_chi;
        this.date = date;
    }

    public UsersModel(int user_id, String username, String number, String email) {
        this.user_id = user_id;
        this.username = username;
        this.number = number;
        this.email = email;
    }

//    public UsersModel(String date, String note, String money, String thuchi) {
//
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "UsersModel{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", money=" + money +
                ", thu_chi=" + thu_chi +
                '}';
    }

    public UsersModel(int user_id, String username, String password, String number, String email) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.number = number;
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UsersModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String isThu_chi() {
        return thu_chi;
    }

    public void setThu_chi(String thu_chi) {
        this.thu_chi = thu_chi;
    }

    public UsersModel(String username, String password, String note, long money, String thu_chi) {
        this.username = username;
        this.password = password;
        this.note = note;
        this.money = money;
        this.thu_chi = thu_chi;
    }
//    private int id;
//    private String name;
//    private int age;
//    private boolean active;
//
//    public UsersModel(int id, String name, int age, boolean active) {
//        this.id = id;
//        this.name = name;
//        this.age = age;
//        this.active = active;
//    }
//
//    public UsersModel() {
//    }
//
//    @Override
//    public String toString() {
//        return "CustomerModel{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", active=" + active +
//                '}';
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public boolean isActive() {
//        return active;
//    }
//
//    public void setActive(boolean active) {
//        this.active = active;
//    }
}
