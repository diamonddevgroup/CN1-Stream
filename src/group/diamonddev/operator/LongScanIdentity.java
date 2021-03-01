package group.diamonddev.operator;

import group.diamonddev.function.LongBinaryOperator;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongScanIdentity extends PrimitiveExtIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final long identity;
    private final LongBinaryOperator accumulator;

    public LongScanIdentity(
            PrimitiveIterator.OfLong iterator,
            long identity,
            LongBinaryOperator accumulator) {
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
            final long current = iterator.nextLong();
            next = accumulator.applyAsLong(next, current);
        }
    }
}
