package cover;

import java.util.ArrayList;

public class Precise extends Algorithm {
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

        long curArr = 1, arrNum = (1 << setsNum), curVal;
        while (curArr < arrNum) {
            familySubset.clear();

            curVal = curArr;
            for (int i = 0; curVal > 0; ++i) {
                if (curVal % 2 == 1) {
                    familySubset.add(setsFamily.get(i));
                }

                curVal /= 2;
            }

            if (isBetter(familySubset) && checkIfCovers(familySubset, instanceBound)) {
                minNeeded = familySubset.size();
                System.err.print(minNeeded + "\n");
                solution.clear();

                curVal = curArr;
                for (int i = 0; curVal > 0; ++i) {
                    if (curVal % 2 == 1) {
                        solution.add(i + 1);
                    }
                    curVal /= 2;
                }
            }

            curArr++;
        }
    }
}
