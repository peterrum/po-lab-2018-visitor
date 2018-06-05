package vsa.analyzable;

import vsa.visitor.PropagatingVisitor;

public class Assignment extends Transition {

    private final String offset;

    public Assignment(State source, State dest, String offset) {
        super(source, dest);
        this.offset = offset;
    }

    @Override
    public <T> void forwardAccept(PropagatingVisitor<T> v, T d) {
        if ((d = v.visit(this, d)) != null) {
            v.enter(dest, d);
        }
    }

    @Override
    public String toString() {
        return offset;
    }
    
    

}
