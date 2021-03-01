package group.diamonddev.operator;

import group.diamonddev.function.DoubleSupplier;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class DoubleGenerate extends PrimitiveIterator.OfDouble {

    private final DoubleSupplier supplier;

    public DoubleGenerate(DoubleSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public double nextDouble() {
        return supplier.getAsDouble();
    }
}
