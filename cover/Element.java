package cover;

import java.util.ArrayList;

public class Element extends Component {
    private int value;

    public Element(int value) {
        this.value = value;
    }

    public ArrayList<Integer> numbersInRange(int x) {
        ArrayList<Integer> inRange = new ArrayList<>();

        if (value <= x) {
            inRange.add(value);
        }

        return inRange;
    }
}
