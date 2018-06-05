package vsa.analyzable;

import vsa.visitor.PropagatingVisitor;

public class Assignment extends Transition {

    public Assignment(State source, State dest) {
        super(source, dest);
    }

    @Override
    public <T> void forwardAccept(PropagatingVisitor<T> v, T d) {
        if ((d = v.visit(this, d)) != null) {
            v.enter(dest, d);
        }
    }

}
