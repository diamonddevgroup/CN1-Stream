package group.diamonddev.operator;

import group.diamonddev.function.ToLongFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjMapToLong<T> extends PrimitiveIterator.OfLong {

    private final Iterator<? extends T> iterator;
    private final ToLongFunction<? super T> mapper;

    public ObjMapToLong(
            Iterator<? extends T> iterator,
            ToLongFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public long nextLong() {
        return mapper.applyAsLong(iterator.next());
    }
}
