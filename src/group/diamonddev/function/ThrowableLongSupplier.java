package group.diamonddev.function;

/**
 * Represents a supplier of {@code long}-valued results.
 *
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see LongSupplier
 * @since 1.0.0
 */
public interface ThrowableLongSupplier<E extends Throwable> {

    /**
     * Gets a result.
     *
     * @return a result
     * @throws E an exception
     */
    long getAsLong() throws E;
}
