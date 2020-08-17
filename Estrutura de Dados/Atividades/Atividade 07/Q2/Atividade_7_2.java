import java.util.Scanner;

public class Atividade_7_2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Resposta: " + func(n));
        in.close();
    }

    public static long func(int n) {
        if (n == 1)
            return 1;
        return 3 + func(n - 1);
    }
}