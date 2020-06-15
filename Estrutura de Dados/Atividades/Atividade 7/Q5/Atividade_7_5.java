import java.util.Scanner;

public class Atividade_7_5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Resposta: " + func(n));
        in.close();
    }

    public static int func(int n) {
        if (n == 0 || n == 1)
            return 1;
        return 2 * func(n - 2) + 10;
    }
}
