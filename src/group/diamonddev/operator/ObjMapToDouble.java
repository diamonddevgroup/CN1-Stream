package group.diamonddev.operator;

import group.diamonddev.function.ToDoubleFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjMapToDouble<T> extends PrimitiveIterator.OfDouble {

    private final Iterator<? extends T> iterator;
    private final ToDoubleFunction<? super T> mapper;

    public ObjMapToDouble(
            Iterator<? extends T> iterator,
            ToDoubleFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public double nextDouble() {
        return mapper.applyAsDouble(iterator.next());
    }
}
