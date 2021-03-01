package group.diamonddev.operator;

import group.diamonddev.function.IntBinaryOperator;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntScanIdentity extends PrimitiveExtIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final int identity;
    private final IntBinaryOperator accumulator;

    public IntScanIdentity(
            PrimitiveIterator.OfInt iterator,
            int identity,
            IntBinaryOperator accumulator) {
        this.iterator = iterator;
        this.identity = identity;
        this.accumulator = accumulator;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            // Return identity
            hasNext = true;
            next = identity;
            return;
        }
        hasNext = iterator.hasNext();
        if (hasNext) {
            final int current = iterator.nextInt();
            next = accumulator.applyAsInt(next, current);
        }
    }
}
