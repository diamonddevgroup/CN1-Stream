package group.diamonddev.function;

/**
 * Represents a function which produces result from {@code int}-valued input argument.
 *
 * @param <R> the type of the result of the function
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see IntFunction
 * @since 1.0.0
 */
public interface ThrowableIntFunction<R, E extends Throwable> {

    /**
     * Applies this function to the given argument.
     *
     * @param value the function argument
     *
     * @return the function result
     * @throws E an exception
     */
    R apply(int value) throws E;
}