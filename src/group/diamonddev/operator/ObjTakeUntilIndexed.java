package group.diamonddev.operator;

import group.diamonddev.function.IndexedPredicate;
import group.diamonddev.iterator.IndexedIterator;
import group.diamonddev.iterator.LsaExtIterator;

/**
 * @author Diamond
 */
public class ObjTakeUntilIndexed<T> extends LsaExtIterator<T> {

    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> stopPredicate;

    public ObjTakeUntilIndexed(
            IndexedIterator<? extends T> iterator,
            IndexedPredicate<? super T> predicate) {
        this.iterator = iterator;
        this.stopPredicate = predicate;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext() && !(isInit && stopPredicate.test(iterator.getIndex(), next));
        if (hasNext) {
            next = iterator.next();
        }
    }
}
