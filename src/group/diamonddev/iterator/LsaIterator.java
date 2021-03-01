package group.diamonddev.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Abstract iterator with implemented {@code remove} method.
 *
 * @param <T> the type of the elements
 *
 * @author Diamond
 */
public abstract class LsaIterator<T> implements Iterator<T> {

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove not supported");
    }

    @Override
    public final T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return nextIteration();
    }

    public abstract T nextIteration();
}
