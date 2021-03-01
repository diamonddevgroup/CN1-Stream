package group.diamonddev.operator;

import group.diamonddev.function.Predicate;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class ObjTakeWhile<T> implements Iterator<T> {

    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;
    private T next;
    private boolean hasNextInitialized, hasNext;

    public ObjTakeWhile(
            Iterator<? extends T> iterator,
            Predicate<? super T> predicate) {
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
            next = iterator.next();
            hasNext = predicate.test(next);
        }
        return hasNext;
    }

    @Override
    public final T next() {
        if (hasNextInitialized && !hasNext) {
            throw new NoSuchElementException();
        }
        return next;
    }
}
