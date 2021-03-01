package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongArray extends PrimitiveIterator.OfLong {

    private final long[] values;
    private int index;

    public LongArray(long[] values) {
        this.values = values;
        index = 0;
    }

    @Override
    public long nextLong() {
        return values[index++];
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }
}
