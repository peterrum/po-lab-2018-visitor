package vsa.analyzable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import vsa.visitor.PropagatingVisitor;
import vsa.visitor.Visitor;

public class State implements java.io.Serializable, Analyzable {

    private List<Transition> inEdges = new ArrayList<Transition>();
    private List<Transition> outEdges = new ArrayList<Transition>();
    private final String label;
    private Map<Object, Object> annotations;

    public State(String label) {
        this.label = label;
    }

    public void addInEdge(Transition t) {
        inEdges.add(t);
    }

    public void addOutEdge(Transition t) {
        outEdges.add(t);
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
        Iterator<Transition> it = outEdges.iterator();
        while (it.hasNext()) {
            v.enter(it.next(), d);
        }
    }

    @Override
    public <T> void backwardAccept(PropagatingVisitor<T> v, T d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getAnnotation(Object key) {
        if (annotations == null) {
            return null;
        }
        return annotations.get(key);
    }

    @Override
    public <T> T getAnnotation(Class<T> key) throws ClassCastException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object putAnnotation(Object key, Object value) {
        if (annotations == null) {
            annotations = new HashMap<Object, Object>();
        }
        return annotations.put(key, value);

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
        return label;
    }

}
