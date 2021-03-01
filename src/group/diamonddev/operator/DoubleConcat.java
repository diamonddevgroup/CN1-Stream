package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diamond
 */
public class DoubleConcat extends PrimitiveExtIterator.OfDouble {

    private final List<? extends PrimitiveIterator.OfDouble> iterators;
    private final int iteratorsCount;
    private int iteratorIndex;

    public DoubleConcat(
            PrimitiveIterator.OfDouble iterator1,
            PrimitiveIterator.OfDouble iterator2) {
        iterators = Arrays.asList(iterator1, iterator2);
        iteratorsCount = 2;
        iteratorIndex = 0;
    }

    public DoubleConcat(List<? extends PrimitiveIterator.OfDouble> iterators) {
        this.iterators = new ArrayList<PrimitiveIterator.OfDouble>(iterators);
        iteratorsCount = iterators.size();
        iteratorIndex = 0;
    }

    @Override
    protected void nextIteration() {
        while (iteratorIndex < iteratorsCount) {
            PrimitiveIterator.OfDouble currentIterator = iterators.get(iteratorIndex);
            if (currentIterator.hasNext()) {
                next = currentIterator.nextDouble();
                hasNext = true;
                return;
            }
            iteratorIndex++;
        }
        hasNext = false;
    }
}
