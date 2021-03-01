package group.diamonddev.operator;

import group.diamonddev.function.IntPredicate;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntTakeUntil extends PrimitiveExtIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntPredicate stopPredicate;

    public IntTakeUntil(
            PrimitiveIterator.OfInt iterator,
            IntPredicate stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext() && !(isInit && stopPredicate.test(next));
        if (hasNext) {
            next = iterator.nextInt();
        }
    }
}
