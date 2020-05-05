package cover;

import java.util.ArrayList;

// class representing single element being component of set
public class Element extends Component {
    private int value;

    public Element(int value) {
        this.value = value;
    }

    // returns a list of all numbers from the set that are less or equal x
    public ArrayList<Integer> numbersInRange(int x) {
        ArrayList<Integer> inRange = new ArrayList<>();

        if (value <= x) {
            inRange.add(value);
        }

        return inRange;
    }
}
