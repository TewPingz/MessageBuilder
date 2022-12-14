package me.tewpingz.message;

import lombok.Getter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class MessageBuilder {
    private static final LegacyComponentSerializer SERIALIZER = LegacyComponentSerializer.legacy('§');

    private final MessageBuilderColorPalette pallet;
    private final TextComponent.Builder componentBuilder;

    @Getter
    private boolean empty = true;

    /**
     * Simple way to create a message builder by and having default spacing
     * @param pallet the color pallet that will be used.
     */
    public MessageBuilder(MessageBuilderColorPalette pallet) {
        this.pallet = pallet;
        this.componentBuilder = Component.text();
    }

    /**
     * Append a primary color from the color pallet to the string builder
     * @param object the object that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder primary(Object object) {
        return this.primary(() -> object);
    }

    /**
     * Append a primary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the object
     * @return the message builder instance to continue building
     */
    public MessageBuilder primary(Supplier<Object> supplier) {
        return this.append(pallet.getPrimary(), supplier);
    }

    /**
     * Append a secondary color from the color pallet to the string builder
     * @param object the object that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder secondary(Object object) {
        return this.secondary(() -> object);
    }

    /**
     * Append a secondary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the object
     * @return the message builder instance to continue building
     */
    public MessageBuilder secondary(Supplier<Object> supplier) {
        return this.append(pallet.getSecondary(), supplier);
    }

    /**
     * Append a tertiary color from the color pallet to the string builder
     * @param object the object that is going to be appended
     * @return the message builder instance
     */
    public MessageBuilder tertiary(Object object) {
        return this.tertiary(() -> object);
    }

    /**
     * Append a tertiary color from the color pallet to the string builder
     * @param supplier the supplier that is providing the object
     * @return the message builder instance to continue building
     */
    public MessageBuilder tertiary(Supplier<Object> supplier) {
        return this.append(pallet.getTertiary(), supplier);
    }

    public MessageBuilder space() {
        return this.space(1);
    }

    public MessageBuilder space(int amount) {
        return this.append(Component.text(" ".repeat(amount)));
    }

    /**
     * Function to build the message
     * @return the message string
     */
    public Component build() {
        return this.componentBuilder.build();
    }

    /**
     * Function to allow you to build the message to a consumer
     * @param consumer the consumer that will be consumed.
     */
    public void build(Consumer<Component> consumer) {
        consumer.accept(this.build());
    }

    @Override
    public String toString() {
        return SERIALIZER.serialize(this.build());
    }

    public void toString(Consumer<String> consumer) {
        consumer.accept(this.toString());
    }

    /**
     * A function that passes through the builder, so you can apply what you wish.
     * @param consumer the consumer with the builder.
     */
    public MessageBuilder apply(Consumer<TextComponent.Builder> consumer) {
        consumer.accept(this.componentBuilder);
        this.empty = false;
        return this;
    }

    /**
     * Function to allow you to append what you want to the component
     * @param component the component that you want to apply to the builder.
     */
    public MessageBuilder append(Component component) {
        this.componentBuilder.append(component);
        this.empty = false;
        return this;
    }

    private MessageBuilder append(MessageBuilderColor color, Supplier<Object> supplier) {
        return this.append(Component.text(supplier.get().toString()).color(color.getTextColor()));
    }
}
