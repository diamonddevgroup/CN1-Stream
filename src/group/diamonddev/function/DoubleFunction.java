package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents a function which produces result from {@code double}-valued input argument.
 *
 * @param <R> the type of the result of the function
 *
 * @author Diamond
 * @see Function
 * @since 1.0.0
 */
public interface DoubleFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param value an argument
     *
     * @return the function result
     */
    R apply(double value);

    class Util {

        private Util() {
        }

        /**
         * Creates a safe {@code DoubleFunction},
         *
         * @param <R>               the type of the result of the function
         * @param throwableFunction the function that may throw an exception
         *
         * @return the function result or {@code null} if exception was thrown
         * @throws NullPointerException if {@code throwableFunction} is null
         * @see #safe(ThrowableDoubleFunction, Object)
         * @since 1.0.0
         */
        public static <R> DoubleFunction<R> safe(
                ThrowableDoubleFunction<? extends R, Throwable> throwableFunction) {
            return Util.safe(throwableFunction, null);
        }

        /**
         * Creates a safe {@code DoubleFunction},
         *
         * @param <R>               the type of the result of the function
         * @param throwableFunction the function that may throw an exception
         * @param resultIfFailed    the result which returned if exception was thrown
         *
         * @return the function result or {@code resultIfFailed}
         * @throws NullPointerException if {@code throwableFunction} is null
         * @since 1.0.0
         */
        public static <R> DoubleFunction<R> safe(
                final ThrowableDoubleFunction<? extends R, Throwable> throwableFunction,
                final R resultIfFailed) {
            Objects.requireNonNull(throwableFunction);
            return new DoubleFunction<R>() {

                @Override
                public R apply(double value) {
                    try {
                        return throwableFunction.apply(value);
                    } catch (Throwable throwable) {
                        return resultIfFailed;
                    }
                }
            };
        }

    }
}