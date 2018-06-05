package vsa;

import vsa.analyzable.Nop;
import vsa.analyzable.Procedure;
import vsa.analyzable.State;

public class main {

    public static void main(String[] args) {

        {
            State s0 = new State("s0");
            State s1 = new State("s1");
            State s2 = new State("s2");
            State s3 = new State("s3");

            Nop n1 = new Nop(s0, s1);
            Nop n2 = new Nop(s1, s2);
            Nop n3 = new Nop(s2, s1);
            Nop n4 = new Nop(s2, s3);

            Procedure procedure = new Procedure(s0, s3);
            ValueSetAnalysis vas = new ValueSetAnalysis();
            vas.enter(procedure, 0);
            vas.fullAnalysis();
        }
    }
}
