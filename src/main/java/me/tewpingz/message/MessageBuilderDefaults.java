package me.tewpingz.message;

public class MessageBuilderDefaults {

    private static final MessageBuilderColorPalette successColorPallet;
    private static final MessageBuilderColorPalette errorColorPallet;
    private static final MessageBuilderColorPalette normalColorPallet;

    static {
        successColorPallet = new MessageBuilderColorPalette(MessageBuilderColor.GREEN, MessageBuilderColor.WHITE, MessageBuilderColor.GRAY);
        errorColorPallet = new MessageBuilderColorPalette(MessageBuilderColor.RED, MessageBuilderColor.DARK_RED, MessageBuilderColor.GRAY);
        normalColorPallet = new MessageBuilderColorPalette(MessageBuilderColor.GOLD, MessageBuilderColor.WHITE, MessageBuilderColor.GRAY);
    }

    public static MessageBuilder success() {
        return new MessageBuilder(successColorPallet);
    }

    public static MessageBuilder error() {
        return new MessageBuilder(errorColorPallet);
    }

    public static MessageBuilder normal() {
        return new MessageBuilder(normalColorPallet);
    }
}
