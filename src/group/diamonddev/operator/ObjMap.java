package group.diamonddev.operator;

import group.diamonddev.function.Function;
import group.diamonddev.iterator.LsaIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjMap<T, R> extends LsaIterator<R> {

    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends R> mapper;

    public ObjMap(
            Iterator<? extends T> iterator,
            Function<? super T, ? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R nextIteration() {
        return mapper.apply(iterator.next());
    }
}
