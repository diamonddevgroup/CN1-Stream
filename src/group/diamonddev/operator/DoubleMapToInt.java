package group.diamonddev.operator;

import group.diamonddev.function.DoubleToIntFunction;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleMapToInt extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleToIntFunction mapper;

    public DoubleMapToInt(
            PrimitiveIterator.OfDouble iterator,
            DoubleToIntFunction mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        return mapper.applyAsInt(iterator.nextDouble());
    }
}
