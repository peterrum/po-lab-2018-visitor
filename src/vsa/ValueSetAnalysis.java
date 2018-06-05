package vsa;

import java.util.List;
import java.util.Objects;
import vsa.analyzable.Nop;
import vsa.analyzable.State;
import vsa.visitor.AbstractPropagatingVisitor;

public class ValueSetAnalysis extends AbstractPropagatingVisitor<Integer>{

    public ValueSetAnalysis() {
        super(true);
    }

    @Override
    public Integer visit(State s, Integer d) {
        System.out.println(s);
        
        Integer oldflow = dataflowOf(s);
        
        if(Objects.equals(oldflow, d))
            return null;
        
        Integer newval = 1;
        dataflowOf(s,newval);
        
        return newval;
    }

    @Override
    public Integer visit(Nop s, Integer d) {
        System.out.println(s);
        return d;
    }
    
    
    

    
}
