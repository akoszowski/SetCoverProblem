package cover;

import java.util.ArrayList;
import java.util.Arrays;

// class representing set
// consisting of single elements, finite and infinite sequences
public class Set {
    private ArrayList<Component> components = new ArrayList<>();

    public void addComponent(int a) {
        Element e = new Element(a);

        components.add(e);
    }

    public void addComponent(int a, int b) {
        Sequence infSq = new Sequence(a, -b);

        components.add(infSq);
    }

    public void addComponent(int a, int b, int c) {
        Sequence finSq = new Sequence(a, -b, -c);

        components.add(finSq);
    }

    // returns a list of all numbers from the set that are less or equal x
    public ArrayList<Integer> numbersInRange(int x) {
        boolean[] alreadyAppeared = new boolean[x + 1];
        ArrayList<Integer> inRange = new ArrayList<>();

        Arrays.fill(alreadyAppeared, false);

        for(Component c: components) {
            for (Integer n: c.numbersInRange(x)) {
                if (!alreadyAppeared[n]) {
                    alreadyAppeared[n] = true;
                    inRange.add(n);
                }
            }
        }

        return inRange;
    }
}
