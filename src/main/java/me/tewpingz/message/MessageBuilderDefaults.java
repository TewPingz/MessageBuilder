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
        return new MessageBuilder(successColorPallet);
    }

    public static MessageBuilder error() {
        return new MessageBuilder(errorColorPallet);
    }

    public static MessageBuilder normal() {
        return new MessageBuilder(normalColorPallet);
    }
}
