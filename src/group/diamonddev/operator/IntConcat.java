package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diamond
 */
public class IntConcat extends PrimitiveExtIterator.OfInt {

    private final List<? extends PrimitiveIterator.OfInt> iterators;
    private final int iteratorsCount;
    private int iteratorIndex;

    public IntConcat(
            PrimitiveIterator.OfInt iterator1,
            PrimitiveIterator.OfInt iterator2) {
        iterators = Arrays.asList(iterator1, iterator2);
        iteratorsCount = 2;
        iteratorIndex = 0;
    }

    public IntConcat(List<? extends PrimitiveIterator.OfInt> iterators) {
        this.iterators = new ArrayList<PrimitiveIterator.OfInt>(iterators);
        iteratorsCount = iterators.size();
        iteratorIndex = 0;
    }

    @Override
    protected void nextIteration() {
        while (iteratorIndex < iteratorsCount) {
            PrimitiveIterator.OfInt currentIterator = iterators.get(iteratorIndex);
            if (currentIterator.hasNext()) {
                next = currentIterator.nextInt();
                hasNext = true;
                return;
            }
            iteratorIndex++;
        }
        hasNext = false;
    }
}
