package vsa;

import java.util.Objects;
import vsa.analyzable.Assignment;
import vsa.analyzable.State;
import vsa.visitor.AbstractPropagatingVisitor;

public class ValueSetAnalysis extends AbstractPropagatingVisitor<javafx.util.Pair<Integer, Integer>> {

    public ValueSetAnalysis() {
        super(true);
    }

    @Override
    public javafx.util.Pair<Integer, Integer> visit(State s, javafx.util.Pair<Integer, Integer> d) {
        
        // get old interval
        javafx.util.Pair<Integer, Integer> oldflow = dataflowOf(s);
        // variable for new interval
        javafx.util.Pair<Integer, Integer> newval;
        
        if(oldflow == null){
            // bottom: take new interval
            newval = d;
            dataflowOf(s, newval);
        } else {
            // combine old interval and interval comming from transition
            newval = new javafx.util.Pair<>(
                    Integer.min(d.getKey(), oldflow.getKey()),
                    Integer.max(d.getValue(), oldflow.getValue()));

            // has interval changed?
            if (Objects.equals(oldflow, newval)) {
                // no: return null pointer
                newval = null;
            } else {
                // yes: save new interval
                dataflowOf(s, newval);
            }
        }
        
        // print combination
        System.out.println(oldflow +" -> "+newval);
        
        // return new interval or null
        return newval;
    }

    @Override
    public javafx.util.Pair<Integer, Integer> visit(Assignment s, javafx.util.Pair<Integer, Integer> d) {
        Integer offset = new Integer(s.toString());
        return new javafx.util.Pair<>(d.getKey()+offset, d.getValue()+offset);
    }

}
