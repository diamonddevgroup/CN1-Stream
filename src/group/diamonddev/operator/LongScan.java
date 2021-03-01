package group.diamonddev.operator;

import group.diamonddev.function.LongBinaryOperator;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongScan extends PrimitiveExtIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final LongBinaryOperator accumulator;

    public LongScan(
            PrimitiveIterator.OfLong iterator,
            LongBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext();
        if (hasNext) {
            final long current = iterator.nextLong();
            if (isInit) {
                next = accumulator.applyAsLong(next, current);
            } else {
                next = current;
            }
        }
    }
}
