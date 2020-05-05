package cover;

import java.util.ArrayList;

// class realizing the query
public class Query {
    private static final Query INSTANCE = new Query();

    private Query(){
    }

    public static Query getInstance() {
        return INSTANCE;
    }

    public void solve(ArrayList<Set> setsFamily, int a, int b) {
        // choosing algorithm finding the solution
        // precise algorithm
        if (b == 1) {
            Precise precise = Precise.getInstance();

            precise.findSolution(setsFamily, -a);
            precise.printSolution();
        }
        // greedy algorithm
        else if (b == 2) {
            Greedy greedy = Greedy.getInstance();

            greedy.findSolution(setsFamily, -a);
            greedy.printSolution();
        }
        // naive algorithm
        else {
            Naive naive = Naive.getInstance();

            naive.findSolution(setsFamily, -a);
            naive.printSolution();
        }
    }
}
