package model.entities;

import model.exceptions.DomainException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double withdrawLimit, Double balance) throws DomainException {
        if (balance < 0) {
            throw new DomainException("Error: Negative Amount for balance");
        }
        this.number = number;
        this.holder = holder;
        this.withdrawLimit = withdrawLimit;
        this.balance = balance;
    }

    public void deposit(Double amount) {
        this.balance += amount;
    }

    public void withdraw(Double amount) throws DomainException {
        if(getBalance() < amount) {
            throw new DomainException("Error: Amount is smaller than balance");
        } else if(amount == 0) {
            throw new DomainException("Error: Amount is zero");
        } else if(amount > this.withdrawLimit) {
            throw new DomainException("Error: Amount is more than withdraw limit");
        } else {
            this.balance -= amount;
        }
    }


    //Getters and Setters
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }
}
