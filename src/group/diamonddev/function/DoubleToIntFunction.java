package group.diamonddev.function;

/**
 * Represents a function which produces an {@code int}-valued result from input argument.
 *
 * @author Diamond
 * @see Function
 * @since 1.0.0
 */
public interface DoubleToIntFunction {

    /**
     * Applies this function to the given argument.
     *
     * @param value an argument
     *
     * @return the function result
     */
    int applyAsInt(double value);
}
