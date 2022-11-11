package me.tewpingz.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

@Getter
@RequiredArgsConstructor
public class MessageBuilderColor {
    public static final MessageBuilderColor GOLD = new MessageBuilderColor(NamedTextColor.GOLD);
    public static final MessageBuilderColor YELLOW = new MessageBuilderColor(NamedTextColor.YELLOW);
    public static final MessageBuilderColor DARK_RED = new MessageBuilderColor(NamedTextColor.DARK_RED);
    public static final MessageBuilderColor RED = new MessageBuilderColor(NamedTextColor.RED);
    public static final MessageBuilderColor DARK_GREEN = new MessageBuilderColor(NamedTextColor.DARK_GREEN);
    public static final MessageBuilderColor GREEN = new MessageBuilderColor(NamedTextColor.GREEN);
    public static final MessageBuilderColor DARK_AQUA = new MessageBuilderColor(NamedTextColor.DARK_AQUA);
    public static final MessageBuilderColor AQUA = new MessageBuilderColor(NamedTextColor.AQUA);
    public static final MessageBuilderColor DARK_BLUE = new MessageBuilderColor(NamedTextColor.DARK_BLUE);
    public static final MessageBuilderColor BLUE = new MessageBuilderColor(NamedTextColor.BLUE);
    public static final MessageBuilderColor DARK_PURPLE = new MessageBuilderColor(NamedTextColor.DARK_PURPLE);
    public static final MessageBuilderColor PURPLE = new MessageBuilderColor(NamedTextColor.LIGHT_PURPLE);
    public static final MessageBuilderColor DARK_GRAY = new MessageBuilderColor(NamedTextColor.DARK_GRAY);
    public static final MessageBuilderColor GRAY = new MessageBuilderColor(NamedTextColor.GRAY);
    public static final MessageBuilderColor WHITE = new MessageBuilderColor(NamedTextColor.WHITE);
    public static final MessageBuilderColor BLACK = new MessageBuilderColor(NamedTextColor.BLACK);

    private final TextColor textColor;

    public MessageBuilderColor(int red, int green, int blue) {
        this.textColor = TextColor.color(red, green, blue);
    }

    public MessageBuilderColor(String hex) {
        this.textColor = TextColor.fromHexString(hex);
    }

    public MessageBuilderColor(NamedTextColor color) {
        this.textColor = color;
    }
}
