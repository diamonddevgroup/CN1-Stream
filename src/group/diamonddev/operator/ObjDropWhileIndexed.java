package group.diamonddev.operator;

import group.diamonddev.function.IndexedPredicate;
import group.diamonddev.iterator.IndexedIterator;
import group.diamonddev.iterator.LsaExtIterator;

/**
 * @author Diamond
 */
public class ObjDropWhileIndexed<T> extends LsaExtIterator<T> {

    private final IndexedIterator<? extends T> iterator;
    private final IndexedPredicate<? super T> predicate;

    public ObjDropWhileIndexed(
            IndexedIterator<? extends T> iterator,
            IndexedPredicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            // Skip first time
            while (hasNext = iterator.hasNext()) {
                final int index = iterator.getIndex();
                next = iterator.next();
                if (!predicate.test(index, next)) {
                    return;
                }
            }
        }

        hasNext = hasNext && iterator.hasNext();
        if (!hasNext) return;

        next = iterator.next();
    }
}
