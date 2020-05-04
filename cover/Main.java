package cover;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int curVal;
        Scanner sc = new Scanner(System.in);
        Parser parser = new Parser();

        while (sc.hasNext()) {
            curVal = sc.nextInt();
            parser.parse(curVal);

            /*if (curVal == 0) {
                parser.print();
            }*/
        }

    }
}
