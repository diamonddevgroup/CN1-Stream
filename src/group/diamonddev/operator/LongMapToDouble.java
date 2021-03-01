package group.diamonddev.operator;

import group.diamonddev.function.LongToDoubleFunction;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongMapToDouble extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfLong iterator;
    private final LongToDoubleFunction mapper;

    public LongMapToDouble(
            PrimitiveIterator.OfLong iterator,
            LongToDoubleFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        return mapper.applyAsDouble(iterator.nextLong());
    }
}
