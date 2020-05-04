package cover;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Algorithm {
    protected static ArrayList<Integer> solution = new ArrayList<>();

    public abstract void findSolution(ArrayList<Set> setsFamily, int instanceBound);

    // sprawdzamy czy suma rodziny zbiorów jest w ogóle nadzbiorem !
    protected boolean checkIfCovers(ArrayList<Set> setsFamily, int instanceBound) {
        if (setsFamily.isEmpty()) {
            return false;
        }

        boolean[] covered = new boolean[instanceBound + 1];
        ArrayList<Integer> curNums;

        Arrays.fill(covered, false);

        for (Set s: setsFamily) {
            curNums = s.numbersInRange(instanceBound);

            for (int n: curNums) {
                covered[n] = true;
            }
        }

        for (int i = 1; i <= instanceBound; ++i) {
            if (!covered[i]) {
                return false;
            }
        }

        return true;
    }

    public void printSolution() {
        int sSize = solution.size();

        for (int i = 0; i < sSize - 1; ++i) {
            System.out.print(solution.get(i) + " ");
        }
        System.out.print(solution.get(sSize - 1));
        System.out.print('\n');
    }
}
