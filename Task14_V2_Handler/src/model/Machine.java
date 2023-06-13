package model;

public class Machine {
    private int balance;

    public Machine(int balance) {
        this.balance = balance;
    }

    public void addNumber(int amount) {
        balance += amount;
    }

    public void removeNumber(int amount) {balance -= amount;}

    public boolean isCorrectPay(int amount) {
        return balance >= amount;
    }

    public int getBalance() {return balance;}
}
