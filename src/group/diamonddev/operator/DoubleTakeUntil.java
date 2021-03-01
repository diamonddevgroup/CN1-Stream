package group.diamonddev.operator;

import group.diamonddev.function.DoublePredicate;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleTakeUntil extends PrimitiveExtIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoublePredicate stopPredicate;

    public DoubleTakeUntil(
            PrimitiveIterator.OfDouble iterator,
            DoublePredicate stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext() && !(isInit && stopPredicate.test(next));
        if (hasNext) {
            next = iterator.nextDouble();
        }
    }
}
