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
public interface IndexedIntFunction<R> {

    /**
     * Applies this function to the given argument.
     *
     * @param index the index
     * @param value an argument
     *
     * @return the function result
     */
    R apply(int index, int value);

    class Util {

        private Util() {
        }

        /**
         * Wraps {@link IntFunction} and returns {@code IndexedIntFunction}.
         *
         * @param <R>      the type of the result
         * @param function the function to wrap
         *
         * @return a wrapped {@code IndexedIntFunction}
         * @throws NullPointerException if {@code function} is null
         */
        public static <R> IndexedIntFunction<R> wrap(
                final IntFunction<? extends R> function) {
            Objects.requireNonNull(function);
            return new IndexedIntFunction<R>() {
                @Override
                public R apply(int index, int value) {
                    return function.apply(value);
                }
            };
        }

    }
}
