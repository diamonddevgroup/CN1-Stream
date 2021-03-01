package group.diamonddev.operator;

import group.diamonddev.function.LongUnaryOperator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongIterate extends PrimitiveIterator.OfLong {

    private final LongUnaryOperator op;
    private long current;

    public LongIterate(long seed, LongUnaryOperator f) {
        this.op = f;
        current = seed;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public long nextLong() {
        final long old = current;
        current = op.applyAsLong(current);
        return old;
    }
}
