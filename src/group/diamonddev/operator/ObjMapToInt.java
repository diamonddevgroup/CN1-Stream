package group.diamonddev.operator;

import group.diamonddev.function.ToIntFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjMapToInt<T> extends PrimitiveIterator.OfInt {

    private final Iterator<? extends T> iterator;
    private final ToIntFunction<? super T> mapper;

    public ObjMapToInt(
            Iterator<? extends T> iterator,
            ToIntFunction<? super T> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public int nextInt() {
        return mapper.applyAsInt(iterator.next());
    }
}
