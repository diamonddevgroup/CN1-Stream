package group.diamonddev.operator;

import group.diamonddev.function.LongPredicate;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongTakeUntil extends PrimitiveExtIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final LongPredicate stopPredicate;

    public LongTakeUntil(
            PrimitiveIterator.OfLong iterator,
            LongPredicate stopPredicate) {
        this.iterator = iterator;
        this.stopPredicate = stopPredicate;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext() && !(isInit && stopPredicate.test(next));
        if (hasNext) {
            next = iterator.nextLong();
        }
    }
}
