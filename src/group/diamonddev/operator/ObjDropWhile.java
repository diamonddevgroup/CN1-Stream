package group.diamonddev.operator;

import group.diamonddev.function.Predicate;
import group.diamonddev.iterator.LsaExtIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjDropWhile<T> extends LsaExtIterator<T> {

    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> predicate;

    public ObjDropWhile(
            Iterator<? extends T> iterator,
            Predicate<? super T> predicate) {
        this.iterator = iterator;
        this.predicate = predicate;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            // Skip first time
            while (hasNext = iterator.hasNext()) {
                next = iterator.next();
                if (!predicate.test(next)) {
                    return;
                }
            }
        }

        hasNext = hasNext && iterator.hasNext();
        if (!hasNext) return;

        next = iterator.next();
    }
}
