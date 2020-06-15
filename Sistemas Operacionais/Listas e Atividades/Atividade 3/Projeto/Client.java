import java.lang.Thread;
import java.lang.Runnable;
import java.util.Random;
import java.util.ArrayList;

public class Client implements Runnable{
    // implements Runnable ~~ou~~ extends Thread
    private String name;
    private Account account;
    private Random rand = new Random();
    private ArrayList<Integer> values = new ArrayList<>();
    
 
    // Construtor
    public Client(String name, Account account){
        this.name = name;
        this.account = account;
        values.add(10);
        values.add(20);
        values.add(50);
        values.add(100);
        System.out.println("Conta " + this.name + " criada. Saldo inicial: " + account.getBalance());
    }

    // Getters
    public String getName() {
        return this.name;
    }

    private int getValue(){
        return values.get(rand.nextInt(values.size()));
    }

    // Metodos
    public void execute(){
        int value = getValue();
        while(true){
            if(rand.nextInt(10) > 5){
                account.deposit(value);
                System.out.println(this.name + " : + " + value + ". Saldo: " + account.getBalance());
            }
            else{
                account.withdraw(value);
                System.out.println(this.name + " : - " + value + ". Saldo: " + account.getBalance());
            }
            try {
                Thread.sleep((rand.nextInt(4) + 1) * 1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        System.out.println("Iniciando a Thread do " + this.name);
        execute();
    }
}
