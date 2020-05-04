package cover;

import java.util.ArrayList;

public class Query {
    private static final Query INSTANCE = new Query();

    private Query(){
    }

    public static Query getInstance() {
        return INSTANCE;
    }

    public void solve(ArrayList<Set> setsFamily, int a, int b) {
        if (b == 1) {
            Precise precise = Precise.getInstance();

            //System.out.println("First option");

            precise.findSolution(setsFamily, -a);
            precise.printSolution();
            //System.out.println("AAA");
        }
        else if (b == 2) {
            Greedy greedy = Greedy.getInstance();

            //System.out.println("Second option");

            greedy.findSolution(setsFamily, -a);
            greedy.printSolution();
        }
        else {
            Naive naive = Naive.getInstance();

            //System.out.println("Third option");

            naive.findSolution(setsFamily, -a);
            naive.printSolution();
        }
    }
}
