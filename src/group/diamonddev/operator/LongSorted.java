package group.diamonddev.operator;

import group.diamonddev.internal.Operators;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Arrays;

/**
 * @author Diamond
 */
public class LongSorted extends PrimitiveExtIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private int index;
    private long[] array;

    public LongSorted(PrimitiveIterator.OfLong iterator) {
        this.iterator = iterator;
        index = 0;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            array = Operators.toLongArray(iterator);
            Arrays.sort(array);
        }
        hasNext = index < array.length;
        if (hasNext) {
            next = array[index++];
        }
    }
}
