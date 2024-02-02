package com.inventorymang;

public class BrickUserDetails {
    private String username;
    private String useraddress;
    private long userphone;
    private String userpassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseraddress() {
        return useraddress;
    }

    public void setUseraddress(String useraddress) {
        this.useraddress = useraddress;
    }

    public long getUserphone() {
        return userphone;
    }

    public void setUserphone(long userphone) {
        this.userphone = userphone;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public BrickUserDetails(String username, String useraddress, long userphone, String userpassword) {
        this.username = username;
        this.useraddress = useraddress;
        this.userphone = userphone;
        this.userpassword = userpassword;
    }
    void displayUserrDetails(){
        System.out.println("Display User Details");
        System.out.println("User Name:"+getUsername());
        System.out.println("User Address:"+getUseraddress());
        System.out.println("User Phone:"+getUserphone());
        System.out.println("User Password:"+getUserpassword());

    }
}
