package group.diamonddev.operator;

import group.diamonddev.function.DoublePredicate;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class DoubleTakeWhile extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate predicate;
    private double next;
    private boolean hasNextInitialized, hasNext;

    public DoubleTakeWhile(
            PrimitiveIterator.OfDouble iterator,
            DoublePredicate predicate) {
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
            next = iterator.nextDouble();
            hasNext = predicate.test(next);
        }
        return hasNext;
    }

    @Override
    public double nextDouble() {
        if (hasNextInitialized && !hasNext) {
            throw new NoSuchElementException();
        }
        return next;
    }
}
