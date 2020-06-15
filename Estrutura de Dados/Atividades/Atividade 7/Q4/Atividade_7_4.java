import java.util.Scanner;

public class Atividade_7_4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println("Resposta: " + func(n));
        in.close();
    }

    public static int func(int n) {
        if (n == 2)
            return 2;
        return 2 * func(n - 1) + 3;
    }
}
