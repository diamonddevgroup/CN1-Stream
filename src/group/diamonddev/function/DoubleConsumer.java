package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents an operation on a {@code double}-valued input argument.
 *
 * @author Diamond
 * @see Consumer
 * @since 1.0.0
 */
public interface DoubleConsumer {

    /**
     * Performs operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(double value);

    class Util {

        private Util() {
        }

        /**
         * Composes {@code DoubleConsumer} calls.
         *
         * <p>{@code c1.accept(value); c2.accept(value); }
         *
         * @param c1 the first {@code DoubleConsumer}
         * @param c2 the second {@code DoubleConsumer}
         *
         * @return a composed {@code DoubleConsumer}
         * @throws NullPointerException if {@code c1} or {@code c2} is null
         */
        public static DoubleConsumer andThen(
                final DoubleConsumer c1,
                final DoubleConsumer c2) {
            Objects.requireNonNull(c1, "c1");
            Objects.requireNonNull(c2, "c2");
            return new DoubleConsumer() {
                @Override
                public void accept(double value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        /**
         * Creates a safe {@code DoubleConsumer}.
         *
         * @param throwableConsumer the consumer that may throw an exception
         *
         * @return a {@code DoubleConsumer}
         * @throws NullPointerException if {@code throwableConsumer} is null
         * @see #safe(ThrowableDoubleConsumer, DoubleConsumer)
         * @since 1.0.0
         */
        public static DoubleConsumer safe(
                ThrowableDoubleConsumer<Throwable> throwableConsumer) {
            return safe(throwableConsumer, null);
        }

        /**
         * Creates a safe {@code DoubleConsumer}.
         *
         * @param throwableConsumer the consumer that may throw an exception
         * @param onFailedConsumer  the consumer which applies if exception was thrown
         *
         * @return a {@code DoubleConsumer}
         * @throws NullPointerException if {@code throwableConsumer} is null
         * @see #safe(ThrowableDoubleConsumer)
         * @since 1.0.0
         */
        public static DoubleConsumer safe(
                final ThrowableDoubleConsumer<Throwable> throwableConsumer,
                final DoubleConsumer onFailedConsumer) {
            Objects.requireNonNull(throwableConsumer);
            return new DoubleConsumer() {

                @Override
                public void accept(double value) {
                    try {
                        throwableConsumer.accept(value);
                    } catch (Throwable ex) {
                        if (onFailedConsumer != null) {
                            onFailedConsumer.accept(value);
                        }
                    }
                }
            };
        }

    }
}
