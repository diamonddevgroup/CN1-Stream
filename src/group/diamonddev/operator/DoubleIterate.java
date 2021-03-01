package group.diamonddev.operator;

import group.diamonddev.function.DoubleUnaryOperator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleIterate extends PrimitiveIterator.OfDouble {

    private final DoubleUnaryOperator op;
    private double current;

    public DoubleIterate(double seed, DoubleUnaryOperator f) {
        this.op = f;
        current = seed;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public double nextDouble() {
        final double old = current;
        current = op.applyAsDouble(current);
        return old;
    }
}
