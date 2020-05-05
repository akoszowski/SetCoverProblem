package cover;

import java.util.ArrayList;

// class representing the precise algorithm
// finding the best optimal solution (in terms of number of sets and lexicographic order)
public class Precise extends Algorithm {
    private static final Precise INSTANCE = new Precise();

    private Precise(){

    }

    public static Precise getInstance() {
        solution.clear();
        return INSTANCE;
    }

    @Override
    public void findSolution(ArrayList<Set> setsFamily, int instanceBound) {
        if (!checkIfCovers(setsFamily, instanceBound)) {
            solution.add(0);
            return;
        }

        int setsNum = setsFamily.size();
        int minNeeded = setsNum + 1;
        boolean[] covered = new boolean[instanceBound + 1];
        ArrayList<Set> familySubset = new ArrayList<>();
        ArrayList<Integer> subsetIds = new ArrayList<>();

        int countSets;
        long curBit, arrNum = 1;
        arrNum <<= setsNum;

        for (long i = 1; i <= arrNum; ++i) {
            familySubset.clear();
            subsetIds.clear();
            curBit = 1;
            countSets = 0;

            for (int j = 0; j < setsNum; ++j) {
                if ((i & curBit) > 0) {
                    familySubset.add(setsFamily.get(j));
                    subsetIds.add(j + 1);
                    countSets++;
                }

                if (countSets > minNeeded) {
                    break;
                }

                curBit <<= 1;
            }

            if (isBetter(subsetIds, minNeeded) && checkIfCovers(familySubset, instanceBound)) {
                minNeeded = familySubset.size();
                System.err.print(minNeeded + "\n");
                solution.clear();

                solution.addAll(subsetIds);
            }
        }
    }

    // checks whether current subset of family of sets is the optimal solution
    // firstly when it comes to number of sets, secondary in lexicographic order
    private boolean isBetter(ArrayList<Integer> subsetIds, int minNeeded) {
        if (subsetIds.size() < minNeeded) {
            return true;
        }
        else if (subsetIds.size() == minNeeded) {
            for (int i = 0; i < subsetIds.size(); ++i) {
                if (subsetIds.get(i) > solution.get(i)) {
                    return false;
                }
                else if (subsetIds.get(i) < solution.get(i)) {
                    return true;
                }
            }
        }

        return false;
    }
}