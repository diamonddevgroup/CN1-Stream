package group.diamonddev.operator;

import group.diamonddev.function.DoubleConsumer;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoublePeek extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleConsumer action;

    public DoublePeek(
            PrimitiveIterator.OfDouble iterator,
            DoubleConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        final double value = iterator.nextDouble();
        action.accept(value);
        return value;
    }
}
