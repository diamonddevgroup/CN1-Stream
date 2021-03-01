package group.diamonddev.operator;

import group.diamonddev.function.IntBinaryOperator;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntScan extends PrimitiveExtIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntBinaryOperator accumulator;

    public IntScan(
            PrimitiveIterator.OfInt iterator,
            IntBinaryOperator accumulator) {
        this.iterator = iterator;
        this.accumulator = accumulator;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext();
        if (hasNext) {
            final int current = iterator.nextInt();
            if (isInit) {
                next = accumulator.applyAsInt(next, current);
            } else {
                next = current;
            }
        }
    }
}
