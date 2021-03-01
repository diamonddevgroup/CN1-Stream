package group.diamonddev.operator;

import group.diamonddev.function.DoubleUnaryOperator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleMap extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleUnaryOperator mapper;

    public DoubleMap(
            PrimitiveIterator.OfDouble iterator,
            DoubleUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        return mapper.applyAsDouble(iterator.nextDouble());
    }
}
