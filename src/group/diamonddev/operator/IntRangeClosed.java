package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntRangeClosed extends PrimitiveIterator.OfInt {

    private final int endInclusive;
    private int current;
    private boolean hasNext;

    public IntRangeClosed(int startInclusive, int endInclusive) {
        this.endInclusive = endInclusive;
        current = startInclusive;
        hasNext = current <= endInclusive;
    }

    @Override
    public boolean hasNext() {
        return hasNext;
    }

    @Override
    public int nextInt() {
        if (current >= endInclusive) {
            hasNext = false;
            return endInclusive;
        }
        return current++;
    }
}
