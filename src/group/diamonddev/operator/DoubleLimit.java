package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleLimit extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final long maxSize;
    private long index;

    public DoubleLimit(PrimitiveIterator.OfDouble iterator, long maxSize) {
        this.iterator = iterator;
        this.maxSize = maxSize;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return (index < maxSize) && iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        index++;
        return iterator.nextDouble();
    }
}
