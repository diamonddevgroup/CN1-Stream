package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents a supplier of {@code long}-valued results.
 *
 * @author Diamond
 * @see Supplier
 * @since 1.0.0
 */
public interface LongSupplier {

    /**
     * Gets a result.
     *
     * @return a result
     */
    long getAsLong();

    class Util {

        private Util() {
        }

        /**
         * Creates a safe {@code LongSupplier}.
         *
         * @param throwableSupplier the supplier that may throw an exception
         *
         * @return a {@code LongSupplier}
         * @throws NullPointerException if {@code throwableSupplier} is null
         * @see #safe(ThrowableLongSupplier, long)
         * @since 1.0.0
         */
        public static LongSupplier safe(ThrowableLongSupplier<Throwable> throwableSupplier) {
            return safe(throwableSupplier, 0L);
        }

        /**
         * Creates a safe {@code LongSupplier}.
         *
         * @param throwableSupplier the supplier that may throw an exception
         * @param resultIfFailed    the result which returned if exception was thrown
         *
         * @return a {@code LongSupplier}
         * @throws NullPointerException if {@code throwableSupplier} is null
         * @since 1.0.0
         */
        public static LongSupplier safe(
                final ThrowableLongSupplier<Throwable> throwableSupplier,
                final long resultIfFailed) {
            Objects.requireNonNull(throwableSupplier);
            return new LongSupplier() {

                @Override
                public long getAsLong() {
                    try {
                        return throwableSupplier.getAsLong();
                    } catch (Throwable ex) {
                        return resultIfFailed;
                    }
                }
            };
        }

    }
}
