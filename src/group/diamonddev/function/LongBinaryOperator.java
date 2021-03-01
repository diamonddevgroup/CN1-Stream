package group.diamonddev.function;

/**
 * Represents an operation on two {@code long}-valued operands
 * that produces a {@code long}-valued result.
 *
 * @author Diamond
 * @see BinaryOperator
 * @since 1.0.0
 */
public interface LongBinaryOperator {

    /**
     * Applies this operator to the given operands.
     *
     * @param left  the first operand
     * @param right the second operand
     *
     * @return the operator result
     */
    long applyAsLong(long left, long right);
}
