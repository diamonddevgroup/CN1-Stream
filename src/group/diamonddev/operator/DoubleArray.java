package group.diamonddev.operator;

import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleArray extends PrimitiveIterator.OfDouble {

    private final double[] values;
    private int index;

    public DoubleArray(double[] values) {
        this.values = values;
        index = 0;
    }

    @Override
    public double nextDouble() {
        return values[index++];
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }
}
