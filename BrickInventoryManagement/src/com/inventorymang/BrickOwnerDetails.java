package com.inventorymang;

public class BrickOwnerDetails extends BrickCompany {

    private String name;
    private String address;
    private long phone;
    private String password;

    public int brickCount;
    public int ownerId;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BrickOwnerDetails(String companyname, String name, String address, String password,long phone, int brickCount,int ownerId) {
        super(companyname);
        this.name = name;
        this.address=address;
        this.password=password;
        this.phone=phone;
        this.brickCount=brickCount;
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public long getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    void displayOwnerDetails(){
        System.out.println("Display Owner Details");
        System.out.println("Brick Company Name:"+getCompanyname());
        System.out.println("Owner ID:"+ownerId);
        System.out.println("Owner Name:"+getName());
        System.out.println("Password:"+getPassword());
        System.out.println("Address:"+getAddress());
        System.out.println("PhoneNumber:"+getPhone());
        System.out.println("Available Bricks:"+brickCount);


    }

}
