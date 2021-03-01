package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents a function which produces result from the index and input argument.
 *
 * @param <R> the type of the result of the function
 *
 * @author Diamond
 * @since 1.0.0
 */
public interface IndexedDoubleFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param index the index
     * @param value an argument
     *
     * @return the function result
     */
    R apply(int index, double value);

    class Util {

        private Util() {
        }

        /**
         * Wraps {@link DoubleFunction} and returns {@code IndexedDoubleFunction}.
         *
         * @param <R>      the type of the result
         * @param function the function to wrap
         *
         * @return a wrapped {@code IndexedDoubleFunction}
         * @throws NullPointerException if {@code function} is null
         */
        public static <R> IndexedDoubleFunction<R> wrap(
                final DoubleFunction<? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedDoubleFunction<R>() {
                @Override
                public R apply(int index, double value) {
                    return function.apply(value);
                }
            };
        }

    }
}
