package group.diamonddev.operator;

import group.diamonddev.function.LongPredicate;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class LongTakeWhile extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate predicate;
    private long next;
    private boolean hasNextInitialized, hasNext;

    public LongTakeWhile(
            PrimitiveIterator.OfLong iterator,
            LongPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
        hasNextInitialized = false;
        hasNext = true;
    }

    @Override
    public boolean hasNext() {
        if (hasNextInitialized && !hasNext) {
            return false;
        }
        hasNextInitialized = true;
        hasNext = iterator.hasNext();
        if (hasNext) {
            next = iterator.nextLong();
            hasNext = predicate.test(next);
        }
        return hasNext;
    }

    @Override
    public long nextLong() {
        if (hasNextInitialized && !hasNext) {
            throw new NoSuchElementException();
        }
        return next;
    }
}
