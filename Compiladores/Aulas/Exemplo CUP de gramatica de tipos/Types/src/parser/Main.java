// java -cp ../tools/java-cup-11b.jar:types_parser.jar parser.Main
package parser;

import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) {
        // initialize the symbol factory
        Parser parser = new Parser(new Scanner(new InputStreamReader(System.in)));
        try {
            parser.parse();
        } catch (Exception e) {
            System.out.println("Caught an exception.");
        }
    }
}
