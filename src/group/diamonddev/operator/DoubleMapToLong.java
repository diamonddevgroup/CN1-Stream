package group.diamonddev.operator;

import group.diamonddev.function.DoubleToLongFunction;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleMapToLong extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleToLongFunction mapper;

    public DoubleMapToLong(
            PrimitiveIterator.OfDouble iterator,
            DoubleToLongFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public long nextLong() {
        return mapper.applyAsLong(iterator.nextDouble());
    }
}
