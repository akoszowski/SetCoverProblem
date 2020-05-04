package cover;

import java.util.ArrayList;

public class Parser {
    private boolean alreadyAdded = false;
    private Set curSet;
    private ArrayList<Set> setsFamily = new ArrayList<>();
    private ArrayList<Integer> buffer = new ArrayList<>();

    public void print() {
        for (Set s: setsFamily) {
            System.out.println(s.numbersInRange(10).toString());
        }

        System.out.println("setsFamily = " + setsFamily.size());;
    }

    public void parse(int x) {
        buffer.add(x);

        execute();
    }

    // jeżeli możemy to wybieramy pełną komendę - co z końcówkami !!!
    private void execute() {
        int bufSize = buffer.size();
        int first = buffer.get(0);

        if (!alreadyAdded) {
            curSet = new Set();
        }

        // możemy chcieć dodać zbiór pusty 0
        if (first == 0) {
            setsFamily.add(curSet);
            alreadyAdded = false;
            bufRemove(1);
        }
        else if (bufSize == 2) {
            int second = buffer.get(1);

            // zapytanie u d
            if (first < 0) {
                //System.out.println("Put Query" + first + " " + second);

                Query query = Query.getInstance();
                query.solve(setsFamily, first, second);

                bufRemove(2);
            }
            // dodajemy pojedynczy element d 0
            else if (second == 0) {
                curSet.addComponent(first);
                setsFamily.add(curSet);
                alreadyAdded = false;
                bufRemove(2);
            }
            // trzeba się wrócić d d
            else if (second > 0) {
                curSet.addComponent(first);
                alreadyAdded = true;
                bufRemove(1);
            }
        }
        else if (bufSize == 3) {
            int second = buffer.get(1), third = buffer.get(2);

            // infSq d u 0
            if (third == 0) {
                curSet.addComponent(first, second);
                setsFamily.add(curSet);
                alreadyAdded = false;
                bufRemove(3);
            }
            // finSq d u u
            else if (third < 0) {
                curSet.addComponent(first, second, third);
                alreadyAdded = true;
                bufRemove(3);
            }
            // trzeba się wrócić d u d
            else if (third > 0) {
                curSet.addComponent(first, second);
                alreadyAdded = true;
                bufRemove(2);
            }
        }

    }

    private void bufRemove(int n) {
        for (int i = 0; i < n; ++i) {
            buffer.remove(0);
        }
    }

}
