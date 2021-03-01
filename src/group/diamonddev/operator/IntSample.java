package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntSample extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final int stepWidth;

    public IntSample(PrimitiveIterator.OfInt iterator, int stepWidth) {
        this.iterator = iterator;
        this.stepWidth = stepWidth;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        final int result = iterator.nextInt();
        int skip = 1;
        while (skip < stepWidth && iterator.hasNext()) {
            iterator.nextInt();
            skip++;
        }
        return result;
    }
}
