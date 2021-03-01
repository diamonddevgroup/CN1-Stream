package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents a function which supply a result.
 *
 * @param <T> the type of the result
 *
 * @author Diamond
 */
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();

    class Util {

        private Util() {
        }

        /**
         * Creates a safe {@code Supplier}.
         *
         * @param <T>               the type of the result
         * @param throwableSupplier the supplier that may throw an exception
         *
         * @return a {@code Supplier}
         * @throws NullPointerException if {@code throwableSupplier} is null
         * @see #safe(ThrowableSupplier, Object)
         * @since 1.0.0
         */
        public static <T> Supplier<T> safe(
                ThrowableSupplier<? extends T, Throwable> throwableSupplier) {
            return Util.safe(throwableSupplier, null);
        }

        /**
         * Creates a safe {@code Supplier}.
         *
         * @param <T>               the type of the result
         * @param throwableSupplier the supplier that may throw an exception
         * @param resultIfFailed    the result which returned if exception was thrown
         *
         * @return a {@code Supplier}
         * @throws NullPointerException if {@code throwableSupplier} is null
         * @since 1.0.0
         */
        public static <T> Supplier<T> safe(
                final ThrowableSupplier<? extends T, Throwable> throwableSupplier,
                final T resultIfFailed) {
            Objects.requireNonNull(throwableSupplier);
            return new Supplier<T>() {

                @Override
                public T get() {
                    try {
                        return throwableSupplier.get();
                    } catch (Throwable ex) {
                        return resultIfFailed;
                    }
                }
            };
        }

    }
}
