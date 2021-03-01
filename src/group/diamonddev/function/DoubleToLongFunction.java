package group.diamonddev.function;

/**
 * Represents a function which produces an {@code long}-valued result from input argument.
 *
 * @author Diamond
 * @see Function
 * @since 1.0.0
 */
public interface DoubleToLongFunction {

    /**
     * Applies this function to the given argument.
     *
     * @param value an argument
     *
     * @return the function result
     */
    long applyAsLong(double value);
}
