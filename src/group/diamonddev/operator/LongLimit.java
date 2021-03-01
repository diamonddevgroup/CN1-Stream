package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongLimit extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final long maxSize;
    private long index;

    public LongLimit(PrimitiveIterator.OfLong iterator, long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return (index < maxSize) && iterator.hasNext();
    }

    @Override
    public long nextLong() {
        index++;
        return iterator.nextLong();
    }
}
