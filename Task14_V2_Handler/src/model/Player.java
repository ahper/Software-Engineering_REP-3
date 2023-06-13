package model;

public class Player {
    private final String name;
    private int balance;

    public Player(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public void addNumber(int amount) {balance += amount;}

    public void removeNumber(int amount) {balance -= amount;}

    public boolean isCorrectPay(int amount) {
        return balance >= amount;
    }

    public String getName() {return name;}
    public int getBalance() {return balance;}
}
