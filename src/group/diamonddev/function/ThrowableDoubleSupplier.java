package group.diamonddev.function;

/**
 * Represents a supplier of {@code double}-valued results.
 *
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see DoubleSupplier
 * @since 1.0.0
 */
public interface ThrowableDoubleSupplier<E extends Throwable> {

    /**
     * Gets a result.
     *
     * @return a result
     * @throws E an exception
     */
    double getAsDouble() throws E;
}
