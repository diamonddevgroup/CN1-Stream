package group.diamonddev.operator;

import group.diamonddev.function.IndexedFunction;
import group.diamonddev.iterator.IndexedIterator;
import group.diamonddev.iterator.LsaIterator;

/**
 * @author Diamond
 */
public class ObjMapIndexed<T, R> extends LsaIterator<R> {

    private final IndexedIterator<? extends T> iterator;
    private final IndexedFunction<? super T, ? extends R> mapper;

    public ObjMapIndexed(
            IndexedIterator<? extends T> iterator,
            IndexedFunction<? super T, ? extends R> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R nextIteration() {
        return mapper.apply(iterator.getIndex(), iterator.next());
    }
}
