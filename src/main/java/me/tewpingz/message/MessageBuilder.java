package me.tewpingz.message;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MessageBuilder {

    private final MessageBuilderColorPallet pallet;
    private final StringBuilder stringBuilder;
    private final boolean defaultSpace;

    private String endedWithCode = null;

    /**
     * Simple way to create a message builder by and having default spacing
     * @param pallet the color pallet that will be used.
     */
    public MessageBuilder(MessageBuilderColorPallet pallet) {
        this(pallet, true);
    }

    /**
     * Simple way to create a message builder
     * @param pallet the color pallet that will be used.
     * @param defaultSpace whether spacing should be used or not
     */
    public MessageBuilder(MessageBuilderColorPallet pallet, boolean defaultSpace) {
        this.pallet = pallet;
        this.stringBuilder = new StringBuilder();
        this.defaultSpace = defaultSpace;
    }

    /**
     * Append a primary color from the color pallet to the string builder
     * @param string the string that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder primary(String string) {
        return this.primary(() -> string);
    }

    /**
     * Append a primary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the string
     * @return the message builder instance to continue building
     */
    public MessageBuilder primary(Supplier<String> supplier) {
        this.append(pallet.getPrimary().toChatColor(), supplier);
        return this;
    }

    /**
     * Append a secondary color from the color pallet to the string builder
     * @param string the string that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder secondary(String string) {
        return this.secondary(() -> string);
    }

    /**
     * Append a secondary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the string
     * @return the message builder instance to continue building
     */
    public MessageBuilder secondary(Supplier<String> supplier) {
        this.append(pallet.getSecondary().toChatColor(), supplier);
        return this;
    }

    /**
     * Append a tertiary color from the color pallet to the string builder
     * @param string the string that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder tertiary(String string) {
        return this.tertiary(() -> string);
    }

    /**
     * Append a tertiary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the string
     * @return the message builder instance to continue building
     */
    public MessageBuilder tertiary(Supplier<String> supplier) {
        this.append(pallet.getTertiary().toChatColor(), supplier);
        return this;
    }

    /**
     * Function to build the message
     * @return the message string
     */
    public String build() {
        return this.stringBuilder.toString();
    }

    /**
     * Function to allow you to build the message to a consumer
     * @param consumer the consumer that will be consumed.
     */
    public void build(Consumer<String> consumer) {
        consumer.accept(this.build());
    }

    private void append(String chatColor, Supplier<String> supplier) {
        if (this.endedWithCode == null || !this.endedWithCode.equalsIgnoreCase(chatColor)) {
            this.stringBuilder.append(chatColor);
        }
        this.stringBuilder.append(supplier.get());

        // Check if default spacing is enabled
        if (this.defaultSpace) {
            this.stringBuilder.append(" "); // If it is, add a space
        }

        this.endedWithCode = chatColor; // Track our previous chat color, so we don't have to reuse it and then make the string long for no reason.
    }
}
