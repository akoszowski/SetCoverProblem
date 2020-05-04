package cover;

import java.util.ArrayList;

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

        long curArr = 1, arrNum = 1, curVal;
        arrNum <<= setsNum;
        while (curArr < arrNum) {
            familySubset.clear();
            subsetIds.clear();

            curVal = curArr;
            for (int i = 0; curVal > 0; ++i) {
                if (curVal % 2 == 1) {
                    familySubset.add(setsFamily.get(i));
                    subsetIds.add(i+1);
                }

                curVal /= 2;
            }

            if (isBetter(subsetIds, minNeeded) && checkIfCovers(familySubset, instanceBound)) {
                minNeeded = familySubset.size();
                System.err.print(minNeeded + "\n");
                solution.clear();

                solution.addAll(subsetIds);
            }

            curArr++;
        }
    }

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
