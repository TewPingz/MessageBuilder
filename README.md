# Message Builder (Minecraft)

A simple message builder that allows you to create messages with themes in a very convenient manner.

## Examples

### Using the message builder defaults

#### Using the builder
```java
public class Main {
    public static void main(String[] args) {
        MessageBuilderDefaults.normal()
                .primary("Hello")
                .primary("World")
                .secondary("I am world")
                .tertiary("(PS you are also world)")
                .build(System.out::println);
    }
}
```

#### Expected output
```
§6Hello World §fI am world §7(PS you are also world) 
```

### Using the message builder with custom colors

#### Making the pallet and constructing the message
```java
public class Main {
    public static void main(String[] args) {
        MessageBuilderColorPallet pallet = new MessageBuilderColorPallet(MessageBuilderColor.YELLOW, MessageBuilderColor.WHITE, MessageBuilderColor.GRAY);
        new MessageBuilder(pallet)
                .primary("Hello")
                .primary("World")
                .secondary("I am world")
                .tertiary("(PS you are also world)")
                .build(System.out::println);
    }
}
```

#### Expected output
```
§eHello World §fI am world §7(PS you are also world) 
```

## Importing with maven

Build the project first by cloning this repository and running ``mvn clean install``.
Then follow it by importing the repository into your project.

```
<dependency>
    <groupId>me.tewpingz.message</groupId>
    artifactId>MessageBuilder</artifactId>
    <version>1.0</version>
</dependency>
```