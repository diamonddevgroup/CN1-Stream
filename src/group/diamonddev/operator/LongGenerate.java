package group.diamonddev.operator;

import group.diamonddev.function.LongSupplier;
import group.diamonddev.iterator.PrimitiveIterator;

/**
 * @author Diamond
 */
public class LongGenerate extends PrimitiveIterator.OfLong {

    private final LongSupplier supplier;

    public LongGenerate(LongSupplier supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public long nextLong() {
        return supplier.getAsLong();
    }
}
