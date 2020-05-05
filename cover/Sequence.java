package cover;

import java.util.ArrayList;

// class representing finite/infinite sequence being component of set
public class Sequence extends Component {
    private int initialTerm;
    private int difference;
    private int upperBound;

    // constructor of infinite sequence
    public Sequence(int initialTerm, int difference) {
        this.initialTerm = initialTerm;
        this.difference = difference;
        this.upperBound = Integer.MAX_VALUE;
    }

    // constructor of finite sequence
    public Sequence(int initialTerm, int difference, int upperBound) {
        this.initialTerm = initialTerm;
        this.difference = difference;
        this.upperBound = upperBound;
    }

    // returns a list of all numbers from the set that are less or equal x
    public ArrayList<Integer> numbersInRange(int x) {
        int curTerm = initialTerm;
        ArrayList<Integer> inRange = new ArrayList<>();

        while (curTerm <= x && curTerm <= upperBound) {
            inRange.add(curTerm);
            curTerm += difference;
        }

        return inRange;
    }
}
