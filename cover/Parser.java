package cover;

import java.util.ArrayList;

// class parsing the input
// executing commands on the basis of given grammar
public class Parser {
    private boolean alreadyAdded = false;
    private Set curSet;
    private ArrayList<Set> setsFamily = new ArrayList<>();
    private ArrayList<Integer> buffer = new ArrayList<>();

    // in buffer we store not yet processed input
    public void parse(int x) {
        buffer.add(x);

        execute();
    }

    // executes commands if those can be singled out from the buffer
    private void execute() {
        int bufSize = buffer.size();
        int first = buffer.get(0);

        // in case we are defining a new set
        if (!alreadyAdded) {
            curSet = new Set();
        }

        // adding already defined set to the family of sets
        // this set may be empty
        if (first == 0) {
            setsFamily.add(curSet);
            alreadyAdded = false;

            bufRemove(1);
        }
        else if (bufSize == 2) {
            int second = buffer.get(1);

            // query - case n p
            if (first < 0) {
                Query query = Query.getInstance();
                query.solve(setsFamily, first, second);

                bufRemove(2);
            }
            // adding single element, set being defined - case p 0
            else if (second == 0) {
                curSet.addComponent(first);
                setsFamily.add(curSet);
                alreadyAdded = false;

                bufRemove(2);
            }
            // step back, adding single element - case p p
            else if (second > 0) {
                curSet.addComponent(first);
                alreadyAdded = true;

                bufRemove(1);
            }
        }
        else if (bufSize == 3) {
            int second = buffer.get(1), third = buffer.get(2);

            // adding infinite sequence, set being defined - case p n 0
            if (third == 0) {
                curSet.addComponent(first, second);
                setsFamily.add(curSet);
                alreadyAdded = false;

                bufRemove(3);
            }
            // adding finite sequence - case p n n
            else if (third < 0) {
                curSet.addComponent(first, second, third);
                alreadyAdded = true;

                bufRemove(3);
            }
            // step back, adding infinite sequence - case p n p
            else if (third > 0) {
                curSet.addComponent(first, second);
                alreadyAdded = true;

                bufRemove(2);
            }
        }
    }

    // removes first n numbers from the buffer
    private void bufRemove(int n) {
        for (int i = 0; i < n; ++i) {
            buffer.remove(0);
        }
    }
}
