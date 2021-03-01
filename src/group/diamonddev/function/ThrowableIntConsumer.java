package group.diamonddev.function;

/**
 * Represents an operation on {@code int}-valued input argument.
 *
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see IntConsumer
 * @since 1.0.0
 */
public interface ThrowableIntConsumer<E extends Throwable> {

    /**
     * Performs operation on the given argument.
     *
     * @param value the input argument
     *
     * @throws E an exception
     */
    void accept(int value) throws E;
}
