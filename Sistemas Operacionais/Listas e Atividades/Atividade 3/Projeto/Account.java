public class Account{
    private double balance; 

    // Construtor
    public Account(double initBalance){
        this.balance = initBalance;
    }

    // Getters
    public double getBalance() {
        return this.balance;
    }
    
    // Metodos
    public boolean deposit(double value){
        this.balance += value;
        return true;
    }

    public boolean withdraw(double value){
        if(this.balance >= value){
            this.balance -= value;
            return true;
        }
        else{
            System.out.println("Saldo indisponivel.");
            return false;
        }
    }
} 