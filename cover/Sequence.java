package cover;

import java.util.ArrayList;

public class Sequence extends Component {
    private int initialTerm;
    private int difference;
    private int upperBound;

    public Sequence(int initialTerm, int difference) {
        this.initialTerm = initialTerm;
        this.difference = difference;
        this.upperBound = Integer.MAX_VALUE;
    }

    public Sequence(int initialTerm, int difference, int upperBound) {
        this.initialTerm = initialTerm;
        this.difference = difference;
        this.upperBound = upperBound;
    }

    public ArrayList<Integer> numbersInRange(int x) {
        int curVal = initialTerm;
        ArrayList<Integer> inRange = new ArrayList<>();

        while (curVal <= x && curVal <= upperBound) {
            inRange.add(curVal);
            curVal += difference;
        }

        return inRange;
    }
}
