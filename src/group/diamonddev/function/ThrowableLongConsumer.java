package group.diamonddev.function;

/**
 * Represents an operation on a {@code long}-valued input argument.
 *
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see LongConsumer
 * @since 1.0.0
 */
public interface ThrowableLongConsumer<E extends Throwable> {

    /**
     * Performs operation on the given argument.
     *
     * @param value the input argument
     *
     * @throws E an exception
     */
    void accept(long value) throws E;
}
