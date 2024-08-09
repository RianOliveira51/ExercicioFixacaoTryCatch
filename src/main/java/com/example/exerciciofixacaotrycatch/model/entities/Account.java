package com.example.exerciciofixacaotrycatch.model.entities;

import com.example.exerciciofixacaotrycatch.model.exception.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(){

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit){
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber(){
        return number;
    }

    public void setNumber(Integer Number){
        this.number = number;
    }

    public String getHolder(){
        return holder;
    }

    public void setHolder(String holder){
        this.holder = holder;
    }

    public double getBalance(){
        return balance;
    }


    public Double getWithdrawLimit(){
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit){
        this.withdrawLimit = withdrawLimit;
    }

    public void Deposit (Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount){
        if(amount > withdrawLimit){
           throw new DomainException("The amount exceeds withdraw limit");
        }else if(amount > balance) {
            throw new DomainException("Not enough balance");
        }else{
            balance -= amount;
        }
    }

    public String toString(){
        return "Number: "
                + number
                + ", Titular: "
                + holder
                + ", Saldo: R$"
                + balance
                + ", Limite:  R$"
                + withdrawLimit;
    }
}
