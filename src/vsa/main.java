package vsa;

import vsa.analyzable.Assignment;
import vsa.analyzable.Procedure;
import vsa.analyzable.State;
import vsa.analyzable.Transition;

public class main {

    public static void main(String[] args) {

        {
            State s0 = new State("s0");
            State s1 = new State("s1");

            Transition n1 = new Assignment(s0, s1, "1");
            Transition n2 = new Assignment(s0, s1, "2");

            Procedure procedure = new Procedure(s0, s1);
            ValueSetAnalysis vas = new ValueSetAnalysis();
            vas.enter(procedure, new javafx.util.Pair<>(0, 0));
            vas.fullAnalysis();
        }
    }
}
