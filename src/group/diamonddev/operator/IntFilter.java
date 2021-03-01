package group.diamonddev.operator;

import group.diamonddev.function.IntPredicate;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class IntFilter extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;
    private boolean hasNext, hasNextEvaluated;
    private int next;

    public IntFilter(
            PrimitiveIterator.OfInt iterator,
            IntPredicate predicate) {
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
    public int nextInt() {
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
            next = iterator.nextInt();
            if (predicate.test(next)) {
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
}
