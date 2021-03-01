package group.diamonddev.operator;

import group.diamonddev.function.IndexedPredicate;
import group.diamonddev.iterator.IndexedIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class ObjTakeWhileIndexed<T> implements Iterator<T> {

    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> predicate;
    private T next;
    private boolean hasNextInitialized, hasNext;

    public ObjTakeWhileIndexed(
            IndexedIterator<? extends T> iterator,
            IndexedPredicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        hasNextInitialized = false;
        hasNext = true;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    @Override
    public boolean hasNext() {
        if (hasNextInitialized && !hasNext) {
            return false;
        }
        hasNextInitialized = true;
        hasNext = iterator.hasNext();
        if (hasNext) {
            int nextIndex = iterator.getIndex();
            next = iterator.next();
            hasNext = predicate.test(nextIndex, next);
        }
        return hasNext;
    }

    @Override
    public T next() {
        if (hasNextInitialized && !hasNext) {
            throw new NoSuchElementException();
        }
        return next;
    }
}
