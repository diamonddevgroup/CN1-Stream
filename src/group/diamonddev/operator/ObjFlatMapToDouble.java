package group.diamonddev.operator;

import group.diamonddev.DoubleStream;
import group.diamonddev.function.Function;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjFlatMapToDouble<T> extends PrimitiveExtIterator.OfDouble {

    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends DoubleStream> mapper;
    private PrimitiveIterator.OfDouble inner;

    public ObjFlatMapToDouble(
            Iterator<? extends T> iterator,
            Function<? super T, ? extends DoubleStream> mapper) {
        this.iterator = iterator;
        this.mapper = mapper;
    }

    @Override
    protected void nextIteration() {
        if ((inner != null) && inner.hasNext()) {
            next = inner.next();
            hasNext = true;
            return;
        }
        while (iterator.hasNext()) {
            if (inner == null || !inner.hasNext()) {
                final T arg = iterator.next();
                final DoubleStream result = mapper.apply(arg);
                if (result != null) {
                    inner = result.iterator();
                }
            }
            if ((inner != null) && inner.hasNext()) {
                next = inner.next();
                hasNext = true;
                return;
            }
        }
        hasNext = false;
    }
}
