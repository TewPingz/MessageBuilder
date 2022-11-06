package me.tewpingz.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MessageBuilderColor {

    // RED
    DARK_RED('4'),
    RED('c'),

    // YELLOW
    GOLD('6'),
    YELLOW('e'),

    // GREEN
    DARK_GREEN('2'),
    GREEN('a'),

    // AQUA
    DARK_AQUA('3'),
    AQUA('b'),

    // BLUE
    DARK_BLUE('1'),
    BLUE('9'),

    // PURPLE
    DARK_PURPLE('5'),
    PURPLE('d'),

    // GRAY
    DARK_GRAY('8'),
    GRAY('7'),

    // DEFAULTS
    RESET('r'),
    BLACK('0'),
    WHITE('f');

    private final char chatCode;

    /**
     * Function to allow you to quickly convert the message builder color to a chat color
     * @return a string with the color code symbol and the chat code together
     */
    public String toChatColor() {
        return "§" + this.chatCode;
    }

}
