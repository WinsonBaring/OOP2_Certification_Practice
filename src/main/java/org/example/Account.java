package org.example;

public class Account {
    public static void main(String[] args) {
        // Test constructor and toString()
        Account a1 = new Account("A101", "Tan Ah Teck", 88);
        System.out.println(a1);  // toString();
        Account a2 = new Account("A102", "Kumar"); // default balance
        System.out.println(a2);

        // Test Getters
        System.out.println("ID: " + a1.getId());
        System.out.println("Name: " + a1.getName());
        System.out.println("Balance: " + a1.getBalance());

        // Test credit() and debit()
        a1.credit(100);
        System.out.println(a1);
        a1.debit(50);
        System.out.println(a1);
        a1.debit(500);  // debit() error
        System.out.println(a1);

        // Test transfer()
        a1.transferto(a2, 100);  // toString()
        System.out.println(a1);
        System.out.println(a2);
    }

    private String id;
    private String name;
    private int balance;

    public Account(String id, String name){
        this.id = id;
        this.name = name;
        this.balance = 0;
    }
    public Account(String id, String name, int balance){
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int credit(int amount){
        return this.balance += amount;
    }
    public int debit(int amount){
        if(balance <= amount){
            System.out.println("Amount Exceeded the balance");
            return 0;
        } return this.balance -= amount;
    }
    public int transferto(Account c,int amount){
        if(amount >= balance) {
            System.out.println("Amount Exceeded the balance");
            return 0;
        }
        c.credit(amount);
        return debit(amount);

    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}