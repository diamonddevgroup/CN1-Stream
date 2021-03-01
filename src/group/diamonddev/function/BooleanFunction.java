package group.diamonddev.function;

/**
 * Represents a function which produces result from {@code boolean}-valued input argument.
 *
 * @param <R> the type of the result of the function
 *
 * @author Diamond
 * @see Function
 * @since 1.0.0
 */
public interface BooleanFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value an argument
     *
     * @return the function result
     */
    R apply(boolean value);
}