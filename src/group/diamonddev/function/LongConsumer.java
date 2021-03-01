package group.diamonddev.function;

import group.diamonddev.Objects;

/**
 * Represents an operation on a {@code long}-valued input argument.
 *
 * @author Diamond
 * @see Consumer
 * @since 1.0.0
 */
public interface LongConsumer {

    /**
     * Performs operation on the given argument.
     *
     * @param value the input argument
     */
    void accept(long value);

    class Util {

        private Util() {
        }

        /**
         * Composes {@code LongConsumer} calls.
         *
         * <p>{@code c1.accept(value); c2.accept(value); }
         *
         * @param c1 the first {@code LongConsumer}
         * @param c2 the second {@code LongConsumer}
         *
         * @return a composed {@code LongConsumer}
         * @throws NullPointerException if {@code c1} or {@code c2} is null
         */
        public static LongConsumer andThen(
                final LongConsumer c1,
                final LongConsumer c2) {
            Objects.requireNonNull(c1, "c1");
            Objects.requireNonNull(c2, "c2");
            return new LongConsumer() {
                @Override
                public void accept(long value) {
                    c1.accept(value);
                    c2.accept(value);
                }
            };
        }

        /**
         * Creates a safe {@code LongConsumer}.
         *
         * @param throwableConsumer the consumer that may throw an exception
         *
         * @return a {@code LongConsumer}
         * @throws NullPointerException if {@code throwableConsumer} is null
         * @see #safe(ThrowableLongConsumer, LongConsumer)
         * @since 1.0.0
         */
        public static LongConsumer safe(
                ThrowableLongConsumer<Throwable> throwableConsumer) {
            return safe(throwableConsumer, null);
        }

        /**
         * Creates a safe {@code LongConsumer}.
         *
         * @param throwableConsumer the consumer that may throw an exception
         * @param onFailedConsumer  the consumer which applies if exception was thrown
         *
         * @return a {@code LongConsumer}
         * @throws NullPointerException if {@code throwableConsumer} is null
         * @see #safe(ThrowableLongConsumer)
         * @since 1.0.0
         */
        public static LongConsumer safe(
                final ThrowableLongConsumer<Throwable> throwableConsumer,
                final LongConsumer onFailedConsumer) {
            Objects.requireNonNull(throwableConsumer);
            return new LongConsumer() {

                @Override
                public void accept(long value) {
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
