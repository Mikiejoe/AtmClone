package com.example.demo;

import java.util.ArrayList;
import java.util.Random;

public class Bank {
    private String name;

    private ArrayList <User> users;

    private  ArrayList <Account> accounts;
    public  Bank(String name){
        this.name = name;
        this.users = new ArrayList<User>();
        this.accounts = new ArrayList<Account>();
    }


    public String getNewUserUUID() {
        String uuid;
        Random rng = new Random();
        int len = 6;
        boolean nonUnique;
        do {
            uuid = "";
            for (int c = 0; c<len; c++){
                uuid += Integer.toString(rng.nextInt(10));
            }
            nonUnique = false;
            for (User u : this.users){
                if(uuid.compareTo(u.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuid;



    }

    public String getNewAccountUUID() {
        String uuid;
        Random rng = new Random();
        int len = 10;
        boolean nonUnique;
        do {
            uuid = "";
            for (int c = 0; c<len; c++){
                uuid += Integer.toString(rng.nextInt(10));
            }
            nonUnique = false;
            for (Account a : this.accounts){
                if(uuid.compareTo(a.getUUID()) == 0){
                    nonUnique = true;
                    break;
                }
            }
        } while (nonUnique);
        return uuid;

    }
    public  void addAccount(Account anAcct){
        this.accounts.add(anAcct);
    }
    public User addUser(String firstName, String lastName, String pin){
        User newUser =  new User(firstName, lastName, pin,this);
        this.users.add(newUser);

        Account newAccount = new Account ("Savings",newUser, this);
        newUser.addAccount(newAccount);
        this.accounts.add(newAccount);
        return  newUser;
    }

    public  User userLogin(String userID, String aPin){
        for (User u : this.users){
            if(u.getUUID().compareTo(userID) == 0 && u.validatePin(aPin)){
                return  u;
            }
        }

        return  null;
    }

    public Object getName() {
        return this.name;
    }
}

