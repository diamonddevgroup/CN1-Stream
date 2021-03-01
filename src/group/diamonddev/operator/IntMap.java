package group.diamonddev.operator;

import group.diamonddev.function.IntUnaryOperator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntMap extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntUnaryOperator mapper;

    public IntMap(
            PrimitiveIterator.OfInt iterator,
            IntUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        return mapper.applyAsInt(iterator.nextInt());
    }
}
