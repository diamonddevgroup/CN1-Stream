package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents an operation on the index and input argument.
 *
 * @param <T> the type of the input to the operation
 *
 * @author Diamond
 * @since 1.0.0
 */
public interface IndexedConsumer<T> {

    /**
     * Performs operation on argument.
     *
     * @param index the index
     * @param t     the input argument
     */
    void accept(int index, T t);

    class Util {

        private Util() {
        }

        /**
         * Wraps a {@link Consumer} and returns {@code IndexedConsumer}.
         *
         * @param <T>      the type of the input argument
         * @param consumer the consumer to wrap
         *
         * @return a wrapped {@code IndexedConsumer}
         * @throws NullPointerException if {@code consumer} is null
         */
        public static <T> IndexedConsumer<T> wrap(
                final Consumer<? super T> consumer) {
            Objects.requireNonNull(consumer);
            return new IndexedConsumer<T>() {

                @Override
                public void accept(int index, T t) {
                    consumer.accept(t);
                }
            };
        }

        /**
         * Returns an {@code IndexedConsumer} that accepts {@code IntConsumer}
         * for the index and {@code Consumer} for the object.
         *
         * <pre><code>
         *  if (c1 != null)
         *      c1.accept(index);
         *  if (c2 != null)
         *      c2.accept(object);
         * </code></pre>
         *
         * @param <T> the type of the input
         * @param c1  the {@code IntConsumer} for the index, can be null
         * @param c2  the {@code Consumer} for the object, can be null
         *
         * @return an {@code IndexedConsumer}
         */
        public static <T> IndexedConsumer<T> accept(
                final IntConsumer c1,
                final Consumer<? super T> c2) {
            return new IndexedConsumer<T>() {

                @Override
                public void accept(int index, T value) {
                    if (c1 != null) {
                        c1.accept(index);
                    }
                    if (c2 != null) {
                        c2.accept(value);
                    }
                }
            };
        }

    }
}
