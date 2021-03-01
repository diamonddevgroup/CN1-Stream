package group.diamonddev.operator;

import group.diamonddev.function.IndexedDoubleUnaryOperator;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleMapIndexed extends PrimitiveIterator.OfDouble {

    private final PrimitiveIndexedIterator.OfDouble iterator;
    private final IndexedDoubleUnaryOperator mapper;

    public DoubleMapIndexed(
            PrimitiveIndexedIterator.OfDouble iterator,
            IndexedDoubleUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        return mapper.applyAsDouble(iterator.getIndex(), iterator.nextDouble());
    }
}
