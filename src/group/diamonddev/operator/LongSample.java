package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongSample extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final int stepWidth;

    public LongSample(PrimitiveIterator.OfLong iterator, int stepWidth) {
        this.iterator = iterator;
        this.stepWidth = stepWidth;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public long nextLong() {
        final long result = iterator.nextLong();
        int skip = 1;
        while (skip < stepWidth && iterator.hasNext()) {
            iterator.nextLong();
            skip++;
        }
        return result;
    }
}
