//Bruna Galastri Guedes & 18.00189-0 
//Daniel Ughini Xavier  & 18.00022-3  
//Rodolfo Cochi Bezerra & 18.00202-0 
//Vítor Martin Simoni   & 18.00050-9 
//Leonardo Cury Haddad  & 18.00442-3 

public class Main {
    public static void main(String[] args) {        
        Account account = new Account(500);
        System.out.println("--------------------------------------------");
        Thread c1 = new Thread(new Client("c1", account));
        Thread c2 = new Thread(new Client("c2", account));
        Thread c3 = new Thread(new Client("c3", account));
        Thread c4 = new Thread(new Client("c4", account));
        System.out.println("--------------------------------------------");

        // RODAR THREADS AQUI
        c1.start();
        c2.start();
        c3.start();
        c4.start();
    }
}