package group.diamonddev.function;

/**
 * Represents an operation on a single int-valued operand that produces an int-valued result.
 * This is the primitive type specialization of UnaryOperator for the int.
 *
 * @author Diamond
 */
public interface IntUnaryOperator {

    /**
     * Applies this operator to the given operand.
     *
     * @param operand the operand
     *
     * @return the operator result
     */
    int applyAsInt(int operand);

    class Util {

        private Util() {
        }

        /**
         * Returns a unary operator that always returns its input argument.
         *
         * @return a unary operator that always returns its input argument
         */
        public static IntUnaryOperator identity() {
            return new IntUnaryOperator() {
                @Override
                public int applyAsInt(int operand) {
                    return operand;
                }
            };
        }
    }
}
