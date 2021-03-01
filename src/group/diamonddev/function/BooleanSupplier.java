package group.diamonddev.function;

/**
 * Represents a supplier of {@code boolean}-valued results.
 *
 * @author Diamond
 * @see Supplier
 * @since 1.0.0
 */
public interface BooleanSupplier {

    /**
     * Gets a result.
     *
     * @return a result
     */
    boolean getAsBoolean();
}
