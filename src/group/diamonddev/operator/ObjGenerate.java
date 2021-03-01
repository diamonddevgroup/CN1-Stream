package group.diamonddev.operator;

import group.diamonddev.function.Supplier;
import group.diamonddev.iterator.LsaIterator;

/**
 * @author Diamond
 */
public class ObjGenerate<T> extends LsaIterator<T> {

    private final Supplier<T> supplier;

    public ObjGenerate(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public T nextIteration() {
        return supplier.get();
    }
}
