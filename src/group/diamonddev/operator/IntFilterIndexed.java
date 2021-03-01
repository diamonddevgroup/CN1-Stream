package group.diamonddev.operator;

import group.diamonddev.function.IndexedIntPredicate;
import group.diamonddev.iterator.PrimitiveIndexedIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class IntFilterIndexed extends PrimitiveIterator.OfInt {

    private final PrimitiveIndexedIterator.OfInt iterator;
    private final IndexedIntPredicate predicate;
    private boolean hasNext, hasNextEvaluated;
    private int next;

    public IntFilterIndexed(
            PrimitiveIndexedIterator.OfInt iterator,
            IndexedIntPredicate predicate) {
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
            final int index = iterator.getIndex();
            next = iterator.nextInt();
            if (predicate.test(index, next)) {
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
}
