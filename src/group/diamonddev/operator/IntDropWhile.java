package group.diamonddev.operator;

import group.diamonddev.function.IntPredicate;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntDropWhile extends PrimitiveExtIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate predicate;

    public IntDropWhile(
            PrimitiveIterator.OfInt iterator,
            IntPredicate predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            // Skip first time
            while (hasNext = iterator.hasNext()) {
                next = iterator.nextInt();
                if (!predicate.test(next)) {
                    return;
                }
            }
        }

        hasNext = hasNext && iterator.hasNext();
        if (!hasNext) return;

        next = iterator.nextInt();
    }
}
