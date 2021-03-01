package group.diamonddev.operator;

import group.diamonddev.internal.Operators;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Arrays;

/**
 * @author Diamond
 */
public class IntSorted extends PrimitiveExtIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private int index;
    private int[] array;

    public IntSorted(PrimitiveIterator.OfInt iterator) {
        this.iterator = iterator;
        index = 0;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            array = Operators.toIntArray(iterator);
            Arrays.sort(array);
        }
        hasNext = index < array.length;
        if (hasNext) {
            next = array[index++];
        }
    }
}
