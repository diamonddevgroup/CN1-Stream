package group.diamonddev.operator;

import group.diamonddev.iterator.LsaExtIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author Diamond
 */
public class ObjConcat<T> extends LsaExtIterator<T> {

    private final List<? extends Iterator<? extends T>> iterators;
    private final int iteratorsCount;
    private int iteratorIndex;

    public ObjConcat(
            Iterator<? extends T> iterator1,
            Iterator<? extends T> iterator2) {
        iterators = Arrays.asList(iterator1, iterator2);
        iteratorsCount = 2;
        iteratorIndex = 0;
    }

    public ObjConcat(List<? extends Iterator<? extends T>> iterators) {
        this.iterators = new ArrayList<Iterator<? extends T>>(iterators);
        iteratorsCount = iterators.size();
        iteratorIndex = 0;
    }

    @Override
    protected void nextIteration() {
        while (iteratorIndex < iteratorsCount) {
            Iterator<? extends T> currentIterator = iterators.get(iteratorIndex);
            if (currentIterator.hasNext()) {
                next = currentIterator.next();
                hasNext = true;
                return;
            }
            iteratorIndex++;
        }
        hasNext = false;
    }
}
