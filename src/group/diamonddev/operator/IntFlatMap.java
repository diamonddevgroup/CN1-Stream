package group.diamonddev.operator;

import group.diamonddev.IntStream;
import group.diamonddev.function.IntFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class IntFlatMap extends PrimitiveIterator.OfInt {

    private final PrimitiveIterator.OfInt iterator;
    private final IntFunction<? extends IntStream> mapper;
    private PrimitiveIterator.OfInt inner;
    private IntStream innerStream;

    public IntFlatMap(
            PrimitiveIterator.OfInt iterator,
            IntFunction<? extends IntStream> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    public boolean hasNext() {
        if (inner != null && inner.hasNext()) {
            return true;
        }
        while (iterator.hasNext()) {
            if (innerStream != null) {
                innerStream.close();
                innerStream = null;
            }
            final int arg = iterator.nextInt();
            final IntStream result = mapper.apply(arg);
            if (result == null) {
                continue;
            }
            innerStream = result;
            if (result.iterator().hasNext()) {
                inner = result.iterator();
                return true;
            }
        }
        if (innerStream != null) {
            innerStream.close();
            innerStream = null;
        }
        return false;
    }

    @Override
    public int nextInt() {
        if (inner == null) {
            throw new NoSuchElementException();
        }
        return inner.nextInt();
    }
}
