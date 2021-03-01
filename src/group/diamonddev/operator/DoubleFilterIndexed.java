package group.diamonddev.operator;

import group.diamonddev.function.IndexedDoublePredicate;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class DoubleFilterIndexed extends PrimitiveIterator.OfDouble {

    private final PrimitiveIndexedIterator.OfDouble iterator;
    private final IndexedDoublePredicate predicate;
    private boolean hasNext, hasNextEvaluated;
    private double next;

    public DoubleFilterIndexed(
            PrimitiveIndexedIterator.OfDouble iterator,
            IndexedDoublePredicate predicate) {
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
    public double nextDouble() {
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
            next = iterator.nextDouble();
            if (predicate.test(index, next)) {
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
}
