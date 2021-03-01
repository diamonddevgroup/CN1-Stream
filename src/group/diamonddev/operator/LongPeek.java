package group.diamonddev.operator;

import group.diamonddev.function.LongConsumer;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongPeek extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final LongConsumer action;

    public LongPeek(
            PrimitiveIterator.OfLong iterator,
            LongConsumer action) {
        this.iterator = iterator;
        this.action = action;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public long nextLong() {
        final long value = iterator.nextLong();
        action.accept(value);
        return value;
    }
}
