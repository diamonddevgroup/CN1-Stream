package group.diamonddev.operator;

import group.diamonddev.IntStream;
import group.diamonddev.function.Function;
import group.diamonddev.iterator.PrimitiveExtIterator;
import group.diamonddev.iterator.PrimitiveIterator;

import java.util.Iterator;

/**
 * @author Diamond
 */
public class ObjFlatMapToInt<T> extends PrimitiveExtIterator.OfInt {

    private final Iterator<? extends T> iterator;
    private final Function<? super T, ? extends IntStream> mapper;
    private PrimitiveIterator.OfInt inner;

    public ObjFlatMapToInt(
            Iterator<? extends T> iterator,
            Function<? super T, ? extends IntStream> mapper) {
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
                final IntStream result = mapper.apply(arg);
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
