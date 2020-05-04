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
        int minNeeded = instanceBound + 1;
        boolean[] covered = new boolean[instanceBound + 1];
        ArrayList<Integer> optimalSolution = new ArrayList<>();
        ArrayList<Set> familySubset = new ArrayList<>();

        int curArr = 1, arrNum = (1 << setsNum), curVal;
        while (curArr < arrNum) {
            familySubset.clear();

            curVal = curArr;
            for (int i = 0; curVal > 0; ++i) {
                if (curVal % 2 == 1) {
                    familySubset.add(setsFamily.get(i));
                }

                curVal /= 2;
            }

            if (familySubset.size() < minNeeded && checkIfCovers(familySubset, instanceBound)) {
                minNeeded = familySubset.size();
                optimalSolution.clear();

                curVal = curArr;
                for (int i = 0; curVal > 0; ++i) {
                    if (curVal % 2 == 1) {
                        optimalSolution.add(i + 1);
                    }
                    curVal /= 2;
                }
            }

            curArr++;
        }

        solution.addAll(optimalSolution);

    }
}
