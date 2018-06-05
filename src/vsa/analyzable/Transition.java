package vsa.analyzable;

import java.util.Map;
import vsa.visitor.PropagatingVisitor;
import vsa.visitor.Visitor;

public class Transition implements java.io.Serializable, Analyzable {

    protected State source;
    protected State dest;

    public Transition(State source, State dest) {
        this.source = source;
        this.source.addOutEdge(this);
        this.dest = dest;
        this.dest.addInEdge(this);
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T> void backwardAccept(PropagatingVisitor<T> v, T d) {
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

    @Override
    public String toString() {
        return source + " -> " + dest;
    }
    
    

}
