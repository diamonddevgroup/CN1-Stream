package group.diamonddev.operator;

import group.diamonddev.internal.Operators;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Arrays;

/**
 * @author Diamond
 */
public class DoubleSorted extends PrimitiveExtIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private int index;
    private double[] array;

    public DoubleSorted(PrimitiveIterator.OfDouble iterator) {
        this.iterator = iterator;
        index = 0;
    }

    @Override
    protected void nextIteration() {
        if (!isInit) {
            array = Operators.toDoubleArray(iterator);
            Arrays.sort(array);
        }
        hasNext = index < array.length;
        if (hasNext) {
            next = array[index++];
        }
    }
}
