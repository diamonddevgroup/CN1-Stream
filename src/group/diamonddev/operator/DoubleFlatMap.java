package group.diamonddev.operator;

import group.diamonddev.DoubleStream;
import group.diamonddev.function.DoubleFunction;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.NoSuchElementException;

/**
 * @author Diamond
 */
public class DoubleFlatMap extends PrimitiveIterator.OfDouble {

    private final PrimitiveIterator.OfDouble iterator;
    private final DoubleFunction<? extends DoubleStream> mapper;
    private PrimitiveIterator.OfDouble inner;
    private DoubleStream innerStream;

    public DoubleFlatMap(
            PrimitiveIterator.OfDouble iterator,
            DoubleFunction<? extends DoubleStream> mapper) {
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
            final double arg = iterator.nextDouble();
            final DoubleStream result = mapper.apply(arg);
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
    public double nextDouble() {
        if (inner == null) {
            throw new NoSuchElementException();
        }
        return inner.nextDouble();
    }
}
