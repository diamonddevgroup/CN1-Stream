package group.diamonddev.operator;

import group.diamonddev.function.UnaryOperator;
import group.diamonddev.iterator.LsaIterator;

/**
 * @author Diamond
 */
public class ObjIterate<T> extends LsaIterator<T> {

    private final UnaryOperator<T> op;
    private T current;

    public ObjIterate(T seed, UnaryOperator<T> op) {
        this.op = op;
        current = seed;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T nextIteration() {
        final T old = current;
        current = op.apply(current);
        return old;
    }
}
