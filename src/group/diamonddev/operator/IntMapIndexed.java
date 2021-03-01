package group.diamonddev.operator;

import group.diamonddev.function.IntBinaryOperator;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntMapIndexed extends PrimitiveIterator.OfInt {

    private final PrimitiveIndexedIterator.OfInt iterator;
    private final IntBinaryOperator mapper;

    public IntMapIndexed(
            PrimitiveIndexedIterator.OfInt iterator,
            IntBinaryOperator mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        return mapper.applyAsInt(iterator.getIndex(), iterator.nextInt());
    }
}
