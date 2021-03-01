package group.diamonddev.operator;

import group.diamonddev.LongStream;
import group.diamonddev.function.LongFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class LongFlatMap extends PrimitiveIterator.OfLong {

    private final PrimitiveIterator.OfLong iterator;
    private final LongFunction<? extends LongStream> mapper;
    private PrimitiveIterator.OfLong inner;
    private LongStream innerStream;

    public LongFlatMap(
            PrimitiveIterator.OfLong iterator,
            LongFunction<? extends LongStream> mapper) {
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
            final long arg = iterator.nextLong();
            final LongStream result = mapper.apply(arg);
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
    public long nextLong() {
        if (inner == null) {
            throw new NoSuchElementException();
        }
        return inner.nextLong();
    }
}
