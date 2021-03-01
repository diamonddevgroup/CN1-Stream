package group.diamonddev.function;

/**
 * Represents a function which produces an {@code double}-valued result from input argument.
 *
 * @param <T> the type of the input of the function
 *
 * @author Diamond
 * @see Function
 * @since 1.0.0
 */
public interface ToDoubleFunction<T> {

    /**
     * Applies this function to the given argument.
     *
     * @param t an argument
     *
     * @return the function result
     */
    double applyAsDouble(T t);
}
