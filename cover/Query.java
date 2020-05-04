package cover;

import java.util.ArrayList;

public class Query {
    public void solve(ArrayList<Set> setsFamily, int a, int b) {
        if (b == 1) {
            Precise precise = new Precise();

            //System.out.println("First option");

            precise.findSolution(setsFamily, -a);
            precise.printSolution();
            //System.out.println("AAA");
        }
        else if (b == 2) {
            Greedy greedy = new Greedy();

            //System.out.println("Second option");

            greedy.findSolution(setsFamily, -a);
            greedy.printSolution();
        }
        else {
            Naive naive = new Naive();

            //System.out.println("Third option");

            naive.findSolution(setsFamily, -a);
            naive.printSolution();
        }
    }
}
