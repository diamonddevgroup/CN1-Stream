package group.diamonddev.operator;

import group.diamonddev.function.Predicate;
import group.diamonddev.iterator.LsaExtIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjTakeUntil<T> extends LsaExtIterator<T> {

    private final Iterator<? extends T> iterator;
    private final Predicate<? super T> stopPredicate;

    public ObjTakeUntil(
            Iterator<? extends T> iterator,
            Predicate<? super T> predicate) {
        this.iterator = iterator;
        this.stopPredicate = predicate;
    }

    @Override
    protected void nextIteration() {
        hasNext = iterator.hasNext() && !(isInit && stopPredicate.test(next));
        if (hasNext) {
            next = iterator.next();
        }
    }
}
