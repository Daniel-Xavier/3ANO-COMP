package lexer;

import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			Lexer lexer = new Lexer();
			Token t;
			while ((t = lexer.scan()).tag != (char)(-1)) {
				System.out.print(t);
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
