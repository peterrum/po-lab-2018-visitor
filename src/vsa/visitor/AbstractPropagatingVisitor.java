package vsa.visitor;

import vsa.analyzable.Procedure;
import vsa.analyzable.State;
import vsa.analyzable.Assignment;
import vsa.analyzable.GuardedTransition;
import vsa.analyzable.Annotatable;
import vsa.analyzable.Nop;
import vsa.analyzable.Analyzable;
import java.util.Queue;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import vsa.analyzable.ProcedureCall;

/**
 * provides a generic interface to constructing an advanced fixpoint iteration
 * algorithm. You would have to extend an own class from this one to get an own
 * fixpoint algorithm. The Visitor performs a run through the whole CFG, as long
 * as it's visit methods return true; to terminate a run, You have to ensure,
 * that the return value of a visit method becomes false at some point. This
 * Fixpoint algorithm stores with each new item to process also context
 * information, which can be provided by any class. For a simple example of how
 * to extend such a CFGVisitor to implement a useful fixpoint iteration see
 * {@link AbstractCFGVisitor}
 *
 * @see CFGPropagatingVisitor
 * @see Analyzable
 * @author Michael Petter
 */
public abstract class AbstractPropagatingVisitor<T> implements PropagatingVisitor<T> {

    private boolean direction = true;
    // Typesafe Queue
    private Queue<Pair<Analyzable, T>> q = new LinkedList<Pair<Analyzable, T>>();

    /**
     * a helper Datastructure. Normally, You don't have to know about this one,
     * it's used internally to realize a queue over pairs of Analyzables and
     * PropagationDatas
     *
     * @author Michael Petter
     */
    protected class Pair<T1, T2> {

        private T1 first;
        private T2 second;

        /**
         * a new pair of f and s
         *
         * @param f first field
         * @param s second field
         */
        public Pair(T1 f, T2 s) {
            first = f;
            second = s;
        }

        /**
         * gives the first field
         *
         * @return guess what?
         */
        public T1 getFirst() {
            return first;
        }

        /**
         * gives the second field
         *
         * @return guess what?
         */
        public T2 getSecond() {
            return second;
        }

        /**
         * just concatenate the <code>toString</code> of each field
         *
         * @return a textual representation
         */
        public String toString() {
            return "<" + first.toString() + " x " + second.toString() + ">";
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 83 * hash + Objects.hashCode(this.first);
            hash = 83 * hash + Objects.hashCode(this.second);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final Pair<T1, T2> other = (Pair<T1, T2>) obj;
            if (!Objects.equals(this.first, other.first)) {
                return false;
            }
            if (!Objects.equals(this.second, other.second)) {
                return false;
            }
            return true;
        }
    }

    /**
     * delivers a textual representation of the queue. Mainly used for debugging
     * and animation purposes
     *
     * @return a String array of all remaining items in the queue
     */
    public String[] getQueue() {
        String[] ret = new String[q.size()];
        int i = 0;
        for (Pair p : q) {
            ret[i++] = p.getFirst().toString();
        }
        return ret;
    }

    protected AbstractPropagatingVisitor(boolean directionForward) {
        direction = directionForward;
    }

    public boolean hasNext() {
        return (peek() != null);
    }

    public Pair<Analyzable, T> getQueuedItem(int index) {
        System.out.println(q);
        return ((LinkedList<Pair<Analyzable, T>>) q).get(index);
    }

    protected Pair<Analyzable, T> poll() {
        return q.poll();
    }

    protected Pair<Analyzable, T> peek() {
        return q.peek();
    }

    protected boolean processNext() {
        if (!hasNext()) {
            return false;
        }
        // implicitely q.peek() returned a valid object
        Pair<Analyzable, T> p = poll();
        Analyzable a = p.getFirst();
        T d = p.getSecond();
        if (direction) {
            a.forwardAccept(this, d);
        } else {
            a.backwardAccept(this, d);
        }
        return true;
    }

    public void fullAnalysis() {
        while (processNext()) ;
    }

    protected T defaultBehaviour(Analyzable a, T d) {
        return d;
    }
    private final Object ID = new Object();

    public void dataflowOf(Annotatable a, T t) {
        a.putAnnotation(ID, t);
    }

    public T dataflowOf(Annotatable a) {
        return (T) a.getAnnotation(ID);
    }

    @Override
    public void enter(Analyzable a, T d) {
        if (a != null) {
            q.offer(new Pair<>(a, d));
        }
    }

    public void enterInCase(Analyzable a, T d) {
        Pair<Analyzable, T> p1 = new Pair<>(a, d);
        LinkedList<Pair<Analyzable, T>> l = (LinkedList<Pair<Analyzable, T>>) q;
        for (Pair<Analyzable, T> p2 : l) {
            if (p1.equals(p2)) {
                return;
            }
        }
        q.offer(p1);
    }

    @Override
    public T visit(State s, T d) {
        return defaultBehaviour(s, d);
    }

    @Override
    public T visit(Nop s, T d) {
        return defaultBehaviour(s, d);
    }

    @Override
    public T visit(Assignment s, T d) {
        return defaultBehaviour(s, d);
    }

    @Override
    public T visit(GuardedTransition s, T d) {
        return defaultBehaviour(s, d);
    }

    @Override
    public T visit(Procedure s, T d) {
        return defaultBehaviour(s, d);
    }

    @Override
    public T visit(ProcedureCall s, T d) {
        return defaultBehaviour(s, d);
    }
    
}
