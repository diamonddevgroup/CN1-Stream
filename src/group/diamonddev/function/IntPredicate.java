package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents a predicate (function with boolean type result).
 *
 * @author Diamond
 */
public interface IntPredicate {

    /**
     * Tests the value for satisfying predicate.
     *
     * @param value the value to be tested
     *
     * @return {@code true} if the value matches the predicate, otherwise {@code false}
     */
    boolean test(int value);

    class Util {

        private Util() {
        }

        /**
         * Applies logical AND to predicates.
         *
         * @param p1 the first predicate
         * @param p2 the second predicate
         *
         * @return a composed {@code IntPredicate}
         * @throws NullPointerException if {@code p1} or {@code p2} is null
         */
        public static IntPredicate and(
                final IntPredicate p1,
                final IntPredicate p2) {
            Objects.requireNonNull(p1, "predicate1");
            Objects.requireNonNull(p2, "predicate2");
            return new IntPredicate() {
                @Override
                public boolean test(int value) {
                    return p1.test(value) && p2.test(value);
                }
            };
        }

        /**
         * Applies logical OR to predicates.
         *
         * @param p1 the first predicate
         * @param p2 the second predicate
         *
         * @return a composed {@code IntPredicate}
         * @throws NullPointerException if {@code p1} or {@code p2} is null
         */
        public static IntPredicate or(
                final IntPredicate p1,
                final IntPredicate p2) {
            Objects.requireNonNull(p1, "predicate1");
            Objects.requireNonNull(p2, "predicate2");
            return new IntPredicate() {
                @Override
                public boolean test(int value) {
                    return p1.test(value) || p2.test(value);
                }
            };
        }

        /**
         * Applies logical XOR to predicates.
         *
         * @param p1 the first predicate
         * @param p2 the second predicate
         *
         * @return a composed {@code IntPredicate}
         * @throws NullPointerException if {@code p1} or {@code p2} is null
         */
        public static IntPredicate xor(
                final IntPredicate p1,
                final IntPredicate p2) {
            Objects.requireNonNull(p1, "predicate1");
            Objects.requireNonNull(p2, "predicate2");
            return new IntPredicate() {
                @Override
                public boolean test(int value) {
                    return p1.test(value) ^ p2.test(value);
                }
            };
        }

        /**
         * Applies logical negation to predicate.
         *
         * @param p1 the predicate to be negated
         *
         * @return a composed {@code IntPredicate}
         * @throws NullPointerException if {@code p1} is null
         */
        public static IntPredicate negate(final IntPredicate p1) {
            Objects.requireNonNull(p1);
            return new IntPredicate() {
                @Override
                public boolean test(int value) {
                    return !p1.test(value);
                }
            };
        }

        /**
         * Creates a safe {@code IntPredicate}.
         *
         * @param throwablePredicate the predicate that may throw an exception
         *
         * @return an {@code IntPredicate} or {@code false} if exception was thrown
         * @see #safe(ThrowableIntPredicate, boolean)
         * @since 1.0.0
         */
        public static IntPredicate safe(ThrowableIntPredicate<Throwable> throwablePredicate) {
            return safe(throwablePredicate, false);
        }

        /**
         * Creates a safe {@code IntPredicate}.
         *
         * @param throwablePredicate the predicate that may throw an exception
         * @param resultIfFailed     the result which returned if exception was thrown
         *
         * @return an {@code IntPredicate} or {@code resultIfFailed}
         * @throws NullPointerException if {@code throwablePredicate} is null
         * @since 1.0.0
         */
        public static IntPredicate safe(
                final ThrowableIntPredicate<Throwable> throwablePredicate,
                final boolean resultIfFailed) {
            Objects.requireNonNull(throwablePredicate);
            return new IntPredicate() {

                @Override
                public boolean test(int value) {
                    try {
                        return throwablePredicate.test(value);
                    } catch (Throwable throwable) {
                        return resultIfFailed;
                    }
                }
            };
        }

    }
}
