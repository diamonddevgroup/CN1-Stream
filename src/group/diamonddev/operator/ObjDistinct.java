package group.diamonddev.operator;

import group.diamonddev.iterator.LsaExtIterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Diamond
 */
public class ObjDistinct<T> extends LsaExtIterator<T> {

    private final Iterator<? extends T> iterator;
    private final Set<T> set;

    public ObjDistinct(Iterator<? extends T> iterator) {
        this.iterator = iterator;
        set = new HashSet<T>();
    }

    @Override
    protected void nextIteration() {
        while (hasNext = iterator.hasNext()) {
            next = iterator.next();
            if (set.add(next)) {
                return;
            }
        }
    }
}
