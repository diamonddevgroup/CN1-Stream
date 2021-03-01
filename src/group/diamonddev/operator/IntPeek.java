package group.diamonddev.operator;

import group.diamonddev.function.IntConsumer;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntPeek extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntConsumer action;

    public IntPeek(
            PrimitiveIterator.OfInt iterator,
            IntConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        final int value = iterator.nextInt();
        action.accept(value);
        return value;
    }
}
