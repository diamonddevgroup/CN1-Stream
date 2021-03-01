package group.diamonddev.operator;

import group.diamonddev.function.DoubleFunction;
import group.diamonddev.iterator.LsaIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleMapToObj<R> extends LsaIterator<R> {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleFunction<? extends R> mapper;

    public DoubleMapToObj(
            PrimitiveIterator.OfDouble iterator,
            DoubleFunction<? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R nextIteration() {
        return mapper.apply(iterator.nextDouble());
    }
}
