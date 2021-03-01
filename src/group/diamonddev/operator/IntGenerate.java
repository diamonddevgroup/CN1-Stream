package group.diamonddev.operator;

import group.diamonddev.function.IntSupplier;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class IntGenerate extends PrimitiveIterator.OfInt {

    private final IntSupplier supplier;

    public IntGenerate(IntSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public int nextInt() {
        return supplier.getAsInt();
    }
}
