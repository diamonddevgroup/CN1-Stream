package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Diamond
 */
public class LongConcat extends PrimitiveExtIterator.OfLong {

    private final List<? extends PrimitiveIterator.OfLong> iterators;
    private final int iteratorsCount;
    private int iteratorIndex;

    public LongConcat(
            PrimitiveIterator.OfLong iterator1,
            PrimitiveIterator.OfLong iterator2) {
        iterators = Arrays.asList(iterator1, iterator2);
        iteratorsCount = 2;
        iteratorIndex = 0;
    }

    public LongConcat(List<? extends PrimitiveIterator.OfLong> iterators) {
        this.iterators = new ArrayList<PrimitiveIterator.OfLong>(iterators);
        iteratorsCount = iterators.size();
        iteratorIndex = 0;
    }

    @Override
    protected void nextIteration() {
        while (iteratorIndex < iteratorsCount) {
            PrimitiveIterator.OfLong currentIterator = iterators.get(iteratorIndex);
            if (currentIterator.hasNext()) {
                next = currentIterator.nextLong();
                hasNext = true;
                return;
            }
            iteratorIndex++;
        }
        hasNext = false;
    }
}
