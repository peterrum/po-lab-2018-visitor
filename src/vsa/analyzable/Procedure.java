package vsa.analyzable;

import java.util.Map;
import vsa.visitor.PropagatingVisitor;
import vsa.visitor.Visitor;

public class Procedure implements java.io.Serializable, Analyzable {

    protected State begin;
    protected State end;

    public Procedure(State begin, State end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void forwardAccept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void backwardAccept(Visitor v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> void forwardAccept(PropagatingVisitor<T> v, T d) {
        if ((d = v.visit(this, d)) == null) {
            return;
        }
        v.enter(getBegin(), d);
    }

    @Override
    public <T> void backwardAccept(PropagatingVisitor<T> v, T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getAnnotation(Object key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T getAnnotation(Class<T> key) throws ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object putAnnotation(Object key, Object value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> T putAnnotation(Class<T> key, T value) throws ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Object, Object> getAnnotations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void putAnnotations(Map<?, ?> a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public State getBegin() {
        return begin;
    }

    public State getEnd() {
        return end;
    }

}
