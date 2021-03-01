package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents an operation on the index and input {@code long}-valued operand
 * that produces a {@code long}-valued result.
 *
 * @author Diamond
 * @see LongUnaryOperator
 * @since 1.0.0
 */
public interface IndexedLongUnaryOperator {

    /**
     * Applies this operator to the given operand.
     *
     * @param index   the index
     * @param operand the operand
     *
     * @return the operator result
     */
    long applyAsLong(int index, long operand);

    class Util {

        private Util() {
        }

        /**
         * Wraps {@link LongUnaryOperator} and returns {@code IndexedLongUnaryOperator}.
         *
         * @param function the function to wrap
         *
         * @return a wrapped {@code IndexedLongUnaryOperator}
         * @throws NullPointerException if {@code function} is null
         */
        public static IndexedLongUnaryOperator wrap(
                final LongUnaryOperator function) {
            Objects.requireNonNull(function);
            return new IndexedLongUnaryOperator() {
                @Override
                public long applyAsLong(int index, long value) {
                    return function.applyAsLong(value);
                }
            };
        }
    }
}
