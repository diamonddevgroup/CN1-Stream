package group.diamonddev.function;

/**
 * Represents a {@code double}-valued predicate (function with boolean type result).
 *
 * @param <E> the type of the exception
 *
 * @author Diamond
 * @see DoublePredicate
 * @since 1.0.0
 */
public interface ThrowableDoublePredicate<E extends Throwable> {

    /**
     * Tests the value for satisfying predicate.
     *
     * @param value the value to be tested
     *
     * @return {@code true} if the value matches the predicate, otherwise {@code false}
     * @throws E an exception
     */
    boolean test(double value) throws E;
}
