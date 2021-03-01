package group.diamonddev.operator;

import group.diamonddev.internal.Operators;
import group.diamonddev.iterator.LsaExtIterator;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @author Diamond
 */
public class ObjSorted<T> extends LsaExtIterator<T> {

    private final Iterator<? extends T> iterator;
    private final Comparator<? super T> comparator;
    private Iterator<T> sortedIterator;

    public ObjSorted(
            Iterator<? extends T> iterator,
            Comparator<? super T> comparator) {
        this.iterator = iterator;
        this.comparator = comparator;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            final List<T> list = Operators.toList(iterator);
            Collections.sort(list, comparator);
            sortedIterator = list.iterator();
        }
        hasNext = sortedIterator.hasNext();
        if (hasNext) {
            next = sortedIterator.next();
        }
    }
}
