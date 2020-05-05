// PROJECT: Set cover problem
// Author: Antoni Koszowski

package cover;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int toParse;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();

        // reading and redirecting input
        while (sc.hasNext()) {
            toParse = sc.nextInt();

            parser.parse(toParse);
        }
    }
}
