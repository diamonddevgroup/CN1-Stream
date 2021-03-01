package group.diamonddev.operator;

import group.diamonddev.function.DoubleBinaryOperator;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleScanIdentity extends PrimitiveExtIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final double identity;
    private final DoubleBinaryOperator accumulator;

    public DoubleScanIdentity(
            PrimitiveIterator.OfDouble iterator,
            double identity,
            DoubleBinaryOperator accumulator) {
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
            final double current = iterator.nextDouble();
            next = accumulator.applyAsDouble(next, current);
        }
    }
}
