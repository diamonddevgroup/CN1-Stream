package group.diamonddev.operator;

import group.diamonddev.function.IntToDoubleFunction;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntMapToDouble extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfInt iterator;
    private final IntToDoubleFunction mapper;

    public IntMapToDouble(
            PrimitiveIterator.OfInt iterator,
            IntToDoubleFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        return mapper.applyAsDouble(iterator.nextInt());
    }
}
