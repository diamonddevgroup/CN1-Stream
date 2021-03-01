package group.diamonddev.operator;

import group.diamonddev.function.IndexedLongUnaryOperator;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongMapIndexed extends PrimitiveIterator.OfLong {

    private final PrimitiveIndexedIterator.OfLong iterator;
    private final IndexedLongUnaryOperator mapper;

    public LongMapIndexed(
            PrimitiveIndexedIterator.OfLong iterator,
            IndexedLongUnaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public long nextLong() {
        return mapper.applyAsLong(iterator.getIndex(), iterator.nextLong());
    }
}
