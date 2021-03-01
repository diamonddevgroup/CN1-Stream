package group.diamonddev;

import group.diamonddev.function.BiConsumer;
import group.diamonddev.function.Function;
import group.diamonddev.function.Supplier;

/**
 * The Collector of stream data.
 *
 * @param <T> the type of input elements to the reduction operation
 * @param <A> the mutable accumulation type of the reduction operation
 * @param <R> the result type of the reduction operation
 *
 * @author Diamond
 * @see Stream#collect(Collector)
 */
public interface Collector<T, A, R> {

    /**
     * Function provides new containers.
     *
     * @return {@code Supplier}
     */
    Supplier<A> supplier();

    /**
     * Function folds elements into a container.
     *
     * @return {@code BiConsumer}
     */
    BiConsumer<A, T> accumulator();

    /**
     * Function produces result by transforming intermediate type.
     *
     * @return {@code Function}
     */
    Function<A, R> finisher();
}