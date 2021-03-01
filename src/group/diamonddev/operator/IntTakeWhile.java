package group.diamonddev.operator;

import group.diamonddev.function.IntPredicate;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class IntTakeWhile extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;
    private int next;
    private boolean hasNextInitialized, hasNext;

    public IntTakeWhile(
            PrimitiveIterator.OfInt iterator,
            IntPredicate predicate) {
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
            next = iterator.nextInt();
            hasNext = predicate.test(next);
        }
        return hasNext;
    }

    @Override
    public int nextInt() {
        if (hasNextInitialized && !hasNext) {
            throw new NoSuchElementException();
        }
        return next;
    }
}

