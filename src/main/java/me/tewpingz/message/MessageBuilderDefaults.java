package me.tewpingz.message;

public class MessageBuilderDefaults {

    private static final MessageBuilderColorPallet successColorPallet;
    private static final MessageBuilderColorPallet errorColorPallet;
    private static final MessageBuilderColorPallet normalColorPallet;

    static {
        successColorPallet = new MessageBuilderColorPallet(MessageBuilderColor.GREEN, MessageBuilderColor.WHITE, MessageBuilderColor.GRAY);
        errorColorPallet = new MessageBuilderColorPallet(MessageBuilderColor.RED, MessageBuilderColor.DARK_RED, MessageBuilderColor.GRAY);
        normalColorPallet = new MessageBuilderColorPallet(MessageBuilderColor.GOLD, MessageBuilderColor.WHITE, MessageBuilderColor.GRAY);
    }

    public static MessageBuilder success() {
        return success(true);
    }

    public static MessageBuilder success(boolean defaultSpace) {
        return new MessageBuilder(successColorPallet, defaultSpace);
    }

    public static MessageBuilder error() {
        return error(true);
    }

    public static MessageBuilder error(boolean defaultSpace) {
        return new MessageBuilder(errorColorPallet, defaultSpace);
    }

    public static MessageBuilder normal() {
        return normal(true);
    }

    public static MessageBuilder normal(boolean defaultSpace) {
        return new MessageBuilder(normalColorPallet, defaultSpace);
    }
}
