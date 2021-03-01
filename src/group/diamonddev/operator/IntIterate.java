package group.diamonddev.operator;

import group.diamonddev.function.IntUnaryOperator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntIterate extends PrimitiveIterator.OfInt {

    private final IntUnaryOperator op;
    private int current;

    public IntIterate(int seed, IntUnaryOperator f) {
        this.op = f;
        current = seed;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int nextInt() {
        final int old = current;
        current = op.applyAsInt(current);
        return old;
    }
}
