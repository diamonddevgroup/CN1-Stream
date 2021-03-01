package group.diamonddev.function;

/**
 * Represents a function which produces an {@code boolean}-valued result from input argument.
 *
 * @param <T> the type of the input of the function
 *
 * @author Diamond
 * @see Function
 */
public interface ToBooleanFunction<T> {

    /**
     * Applies this function to the given argument.
     *
     * @param t an argument
     *
     * @return the function result
     */
    boolean applyAsBoolean(T t);
}
