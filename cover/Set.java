package cover;

import java.util.ArrayList;
import java.util.Collections;

public class Set {
    private ArrayList<Component> components = new ArrayList<>();


    // dodawanie nowych elementów do zbioru
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

    public boolean isEmpty() {
        return components.isEmpty();
    }

    public ArrayList<Integer> numbersInRange(int x) {
        ArrayList<Integer> inRange = new ArrayList<>();

        for(Component c: components) {
            for (Integer n: c.numbersInRange(x)) {
                if (!inRange.contains(n)) {
                    inRange.add(n);
                }
            }
        }

        return inRange;
    }


}
