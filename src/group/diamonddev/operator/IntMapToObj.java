package group.diamonddev.operator;

import group.diamonddev.function.IntFunction;
import group.diamonddev.iterator.LsaIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntMapToObj<R> extends LsaIterator<R> {

    private final PrimitiveIterator.OfInt iterator;
    private final IntFunction<? extends R> mapper;

    public IntMapToObj(
            PrimitiveIterator.OfInt iterator,
            IntFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R nextIteration() {
        return mapper.apply(iterator.nextInt());
    }
}
