package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents an operation on a {@code boolean}-valued input argument.
 *
 * @author Diamond
 * @see Consumer
 * @since 1.0.0
 */
public interface BooleanConsumer {

    /**
     * Performs operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(boolean value);

    class Util {

        private Util() {
        }

        /**
         * Composes {@code BooleanConsumer} calls.
         *
         * <p>{@code c1.accept(value); c2.accept(value); }
         *
         * @param c1 the first {@code BooleanConsumer}
         * @param c2 the second {@code BooleanConsumer}
         *
         * @return a composed {@code BooleanConsumer}
         * @throws NullPointerException if {@code c1} or {@code c2} is null
         */
        public static BooleanConsumer andThen(
                final BooleanConsumer c1,
                final BooleanConsumer c2) {
            Objects.requireNonNull(c1, "c1");
            Objects.requireNonNull(c2, "c2");
            return new BooleanConsumer() {
                @Override
                public void accept(boolean value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

    }
}
