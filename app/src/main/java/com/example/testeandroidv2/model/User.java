package com.example.testeandroidv2.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userAccount")
    @Expose
    private User userAccount;

    @SerializedName("userId")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("bankAccount")
    @Expose
    private String bankAccount;

    @SerializedName("agency")
    @Expose
    private String agency;

    @SerializedName("balance")
    @Expose
    private Double balance;

    public User(User userAccount,
                Integer id,
                String name,
                String bankAccount,
                String agency, Double balance) {

        this.userAccount = userAccount;
        this.id = id;
        this.name = name;
        this.bankAccount = bankAccount;
        this.agency = agency;
        this.balance = balance;
    }

    public User getUserAccount() {
        return userAccount;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public String getAgency() {
        return agency;
    }

    public Double getBalance() {
        return balance;
    }
}
