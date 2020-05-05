package cover;

import java.util.ArrayList;

// abstract class representing component of set
// that can be either single element or finite/infinite sequence
public abstract class Component {
    // returns a list of all numbers from the set that are less or equal x
    public abstract ArrayList<Integer> numbersInRange(int x);
}
