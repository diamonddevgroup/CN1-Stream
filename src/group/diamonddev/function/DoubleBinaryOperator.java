package group.diamonddev.function;

/**
 * Represents an operation on two {@code double}-valued operands
 * that produces a {@code double}-valued result.
 *
 * @author Diamond
 * @see BinaryOperator
 * @since 1.0.0
 */
public interface DoubleBinaryOperator {

    /**
     * Applies this operator to the given operands.
     *
     * @param left  the first operand
     * @param right the second operand
     *
     * @return the operator result
     */
    double applyAsDouble(double left, double right);
}
