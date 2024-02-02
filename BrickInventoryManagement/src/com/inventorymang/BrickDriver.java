package com.inventorymang;

import java.util.InputMismatchException;
import java.util.Scanner;


public class BrickDriver {
    static int id=10010;

    static Scanner scanner = new Scanner(System.in);
    static Scanner scannerA = new Scanner(System.in);
    static Scanner scannerB = new Scanner(System.in);
    static Scanner scannerc = new Scanner(System.in);
    static int tri=3;
    static BrickOwnerDetails Owner;

    static BrickUserDetails user;


    public static void main(String[] args) {

        System.out.println("Welcome To Brickies Bricks");

        do {
            System.out.println("1.Owner login \n 2.User login \n 3.create Account");
        try{
            int option = scanner.nextInt();
            switch (option) {
                case 1: {
                    BrickLogin();
                    break;
                }
                case 2:{
                    UserLogin();
                    break;
                }
                case 3:{
                    CreateAccount();
                    break;
                }

            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter a valid option.");
            scanner.nextLine();
        }
        } while(tri>0);
        System.out.println("Thank You...Visit Brickies Again");

    }
    public static void CreateAccount(){

        System.out.println("1.Create owner Account \n 2.Create User Account ");
        int option = scanner.nextInt();
        switch (option) {
            case 1: {
                CreateBrickLogin();
                break;
            }
            case 2:{
                CreateUserLogin();
                break;
            }

        }

    }
    public static void BrickLogin () {
        try {
            System.out.println("Enter the Owner Id");
            int ownerid = scanner.nextInt();
            System.out.println("Enter the Password:");
            String password = scannerA.nextLine();

            if (ownerid == Owner.ownerId && password.equalsIgnoreCase(Owner.getPassword())) {
                Brickpage();
            } else if (ownerid == Owner.ownerId && !password.equalsIgnoreCase(Owner.getPassword())) {
                System.out.println("Invalid Password");
                tri--;
            } else if (ownerid != Owner.ownerId && password.equalsIgnoreCase(Owner.getPassword())) {
                System.out.println("Invalid ID");
                tri--;
            } else {
                System.out.println("Invalid Credential");
                tri--;
            }
        }catch (InputMismatchException e){
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine();
        }

    }
    public static void UserLogin () {
        System.out.println("Enter the User Name:");
        String username=scannerc.nextLine();
        System.out.println("Enter the Password:");
        String password=scannerB.nextLine();

        if(username.equalsIgnoreCase(user.getUsername()) &&  password.equalsIgnoreCase(user.getUserpassword())){
            System.out.println("Brick User Login Successfull");
            UserPage();
        } else if (!username.equalsIgnoreCase(user.getUsername()) && password.equalsIgnoreCase(user.getUserpassword())) {
            System.out.println("Invalid Username");
            tri--;
        } else if (username.equalsIgnoreCase(user.getUsername()) && !password.equalsIgnoreCase(user.getUserpassword())) {
            System.out.println("Invalid Password");
            tri--;
        }
        else {
            System.out.println("Invalid Credential");
            tri--;
        }
    }
    public static void CreateBrickLogin () {
        try {
            Scanner compname = new Scanner(System.in);
            System.out.println("Enter the Company Name:");
            String cmpname = compname.nextLine();
            Scanner ownname = new Scanner(System.in);
            System.out.println("Enter the Owner Name:");
            String ownername = ownname.nextLine();
            Scanner add = new Scanner(System.in);
            System.out.println("Enter the Address:");
            String address = add.nextLine();
            Scanner phon = new Scanner(System.in);
            System.out.println("Enter the PhoneNumber:");
            long phone = phon.nextLong();
            Scanner passw = new Scanner(System.in);
            System.out.println("Enter the Password:");
            String password = passw.nextLine();
            Scanner countbrick = new Scanner(System.in);
            System.out.println("Available Bricks Count:");
            int count = countbrick.nextInt();
            System.out.println("Brickies Account for Owner is CREATED");


            Owner = new BrickOwnerDetails(cmpname, ownername, address, password, phone, count, id);
            Owner.displayOwnerDetails();
            id++;

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter valid data.");
            scanner.nextLine();
        }
    }
    public static void CreateUserLogin () {
        Scanner uname=new Scanner(System.in);
        System.out.println("Enter the User Name:");
        String username=uname.nextLine();
        Scanner uadd=new Scanner(System.in);
        System.out.println("Enter the Address:");
        String address=uadd.nextLine();
        Scanner uphn=new Scanner(System.in);
        System.out.println("Enter the PhoneNumber:");
        long phone= uphn.nextLong();
        Scanner upass=new Scanner(System.in);
        System.out.println("Enter the Password:");
        String password=upass.nextLine();
        System.out.println("Brickies Account for User is CREATED");

         user=new BrickUserDetails(username,address,phone,password);
         user.displayUserrDetails();

    }
    public static void Brickpage(){
        boolean b = true;
        System.out.println("Welcome to Brickies");
        do{
            System.out.println("1.Update Bricks \n 2.Stock Bricks \n 3.Sell in Share Market \n 4.exit");
            int opt=scanner.nextInt();
            switch (opt){
                case 1:{
                    System.out.println("Enter the Number of Bricks that as been Produce:");
                    int sellcount=scanner.nextInt();

                    System.out.println("Can we Update the Stock With"+Owner.brickCount+" with "+sellcount+"\n 1.confirm \n\t\t\t 2.return");
                    int op=scanner.nextInt();
                    switch (op){
                        case 1:{
                            Owner.brickCount += sellcount;
                            System.out.println("As per the request "+sellcount+" bricks are Added \n Current Available Bricks :"+Owner.brickCount);
                            break;
                        }
                        case 2:{
                            Brickpage();
                            break;
                        }
                        default:
                            System.out.println("invalid input");break;
                    }
                    break;

                }
                case 2:{
                    System.out.println("Available Bricks :"+Owner.brickCount +" Bricks");
                    break;
                }
                case 3:{
                    System.out.println("Enter the Number of Bricks to be SOLD:");
                    int sellcount=scanner.nextInt();

                    System.out.println("$6 for each brick\n\t\t\t 1.confirm \n\t\t\t 2.return");
                    int op=scanner.nextInt();
                    switch (op){
                        case 1:{
                            int amt= sellcount*6;
                            Owner.brickCount += sellcount;
                            System.out.println("As per the request "+amt+" $ will be credited in your UPI Account");
                            break;
                        }
                        case 2:{
                            Brickpage();
                            break;
                        }
                        default:
                            System.out.println("invalid input");break;
                    }
                    break;

                }
                case 4:{
                    b=false;
                    break;
                }
                default:
                    System.out.println("Invalid Input");break;
            }

        }while(b);

    }
    public static void UserPage(){
        boolean b = true;
        System.out.println("Welcome to Brickies");
        do{
            System.out.println("1.Sell Bricks \n 2.Stock Bricks \n 3.Exit");
            int opt=scanner.nextInt();
            switch (opt){
                case 1:{
                    System.out.println("Enter the Number of Bricks to be SOLD:");
                    int sellcount=scanner.nextInt();

                    System.out.println("$4 for each brick\n\t\t\t 1.confirm \n\t\t\t 2.return \n\t\t\t 3.exit");
                    int op=scanner.nextInt();
                    switch (op){
                        case 1:{
                            int amt= sellcount*4;
                            Owner.brickCount += sellcount;
                            System.out.println("As per the request "+amt+" $ will be credited in your UPI Account");
                            break;
                        }
                        case 2:{
                            UserPage();
                            break;
                        }
                        case 3:{
                            b=false;
                            break;
                        }
                        default:
                            System.out.println("invalid input");break;
                    }
                    break;

                }
                case 2:{
                    System.out.println("Available Bricks :"+Owner.brickCount +" Bricks");
                    break;
                }
                case 3:{
                    b=false;
                    break;
                }
                default:
                    System.out.println("Invalid Input");break;
            }

        }while(b);

    }
}