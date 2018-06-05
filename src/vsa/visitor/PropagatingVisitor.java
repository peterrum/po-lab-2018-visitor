package vsa.visitor;

import vsa.analyzable.ProcedureCall;
import vsa.analyzable.Procedure;
import vsa.analyzable.State;
import vsa.analyzable.Assignment;
import vsa.analyzable.GuardedTransition;
import vsa.analyzable.Nop;
import vsa.analyzable.Analyzable;

public interface PropagatingVisitor<T>{
    /**
     * schedules a new CFG-element for visiting.
     * This method enables the concrete visitor to control it's way through the CFG, and do it for example stepwise. In this visitor, You also have to specify a custom data object d.
     * @param a the CFG-element to be scheduled
     * @param d the data to be passed on
     */
    public void enter(Analyzable a,T d);
    /**
     * specific visit method.
     * Override this method to provide custom actions when traversing a {@link CFGState}. In this visitor, You also have to specify a custom data object d.
     * @param s the CFGState which is visited
     * @param d the data to be passed on
     * @return the new data to be propagated in the CFG when the iteration has to continue, <code>null</code> when the iteration stabilizes
     */
    public T visit(State s,T d);
    /**
     * specific visit method.
     * Override this method to provide custom actions when traversing a {@link CFGNullEdge}. In this visitor, You also have to specify a custom data object d.
     * @param ne the CFGNullEdge which is visited
     * @param d the data to be passed on
     * @return the new data to be propagated in the CFG when the iteration has to continue, <code>null</code> when the iteration stabilizes
     */
    public T visit(Nop ne, T d);
    /**
     * specific visit method.
     * Override this method to provide custom actions when traversing a {@link CFGAssignmentEdge}. In this visitor, You also have to specify a custom data object d.
     * @param ae the CFGAssignmentEdge which is visited
     * @param d the data to be passed on
     * @return the new data to be propagated in the CFG when the iteration has to continue, <code>null</code> when the iteration stabilizes
     */
    public T visit(Assignment ae, T d);
    /**
     * specific visit method.
     * Override this method to provide custom actions when traversing a {@link CFGAssertionEdge}. In this visitor, You also have to specify a custom data object d.
     * @param ae the CFGAssertionEdge which is visited
     * @param d the data to be passed on
     * @return the new data to be propagated in the CFG when the iteration has to continue, <code>null</code> when the iteration stabilizes
     */
    public T visit(GuardedTransition ae, T d);
    /**
     * specific visit method.
     * Override this method to provide custom actions when traversing a {@link CFGMethode}. In this visitor, You also have to specify a custom data object d.
     * @param ae the CFGMethode which is visited
     * @param d the data to be passed on
     * @return the new data to be propagated in the CFG when the iteration has to continue, <code>null</code> when the iteration stabilizes
     */
    public T visit(Procedure ae, T d);
    
    public T visit(ProcedureCall ae, T d);
}
