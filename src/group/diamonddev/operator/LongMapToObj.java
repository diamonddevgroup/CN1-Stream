package group.diamonddev.operator;

import group.diamonddev.function.LongFunction;
import group.diamonddev.iterator.LsaIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongMapToObj<R> extends LsaIterator<R> {

    private final PrimitiveIterator.OfLong iterator;
    private final LongFunction<? extends R> mapper;

    public LongMapToObj(
            PrimitiveIterator.OfLong iterator,
            LongFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R nextIteration() {
        return mapper.apply(iterator.nextLong());
    }
}
