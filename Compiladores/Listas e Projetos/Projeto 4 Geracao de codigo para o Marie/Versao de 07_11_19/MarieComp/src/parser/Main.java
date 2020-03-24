package parser;

import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        Parser parser = new Parser(new Scanner(new InputStreamReader(System.in)));
        try {
            parser.parse();
        } catch (Exception e) {
            System.out.println("Caught an exception: " + e);
        }
    }
}
