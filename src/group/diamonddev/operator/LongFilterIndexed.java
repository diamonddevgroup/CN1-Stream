package group.diamonddev.operator;

import group.diamonddev.function.IndexedLongPredicate;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class LongFilterIndexed extends PrimitiveIterator.OfLong {

    private final PrimitiveIndexedIterator.OfLong iterator;
    private final IndexedLongPredicate predicate;
    private boolean hasNext, hasNextEvaluated;
    private long next;

    public LongFilterIndexed(
            PrimitiveIndexedIterator.OfLong iterator,
            IndexedLongPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    public boolean hasNext() {
        if (!hasNextEvaluated) {
            nextIteration();
            hasNextEvaluated = true;
        }
        return hasNext;
    }

    @Override
    public long nextLong() {
        if (!hasNextEvaluated) {
            hasNext = hasNext();
        }
        if (!hasNext) {
            throw new NoSuchElementException();
        }
        hasNextEvaluated = false;
        return next;
    }

    private void nextIteration() {
        while (iterator.hasNext()) {
            final int index = iterator.getIndex();
            next = iterator.nextLong();
            if (predicate.test(index, next)) {
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
}
