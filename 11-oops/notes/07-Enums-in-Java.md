# Enums in Java

## 1. Enum

An **enum** is a special Java type used to represent a fixed set of named constants.

```java
enum Color {
    RED,
    GREEN,
    BLUE
}
```

Usage:

```java
Color color = Color.RED;
```

Enums provide:

- Type safety
- Readable constants
- A fixed set of allowed values
- Support for fields, constructors, and methods
- Support for `switch`

---

## 2. Enum Declaration

An enum is declared using the `enum` keyword.

```java
enum Direction {
    NORTH,
    SOUTH,
    EAST,
    WEST
}
```

An enum can be declared:

- As a top-level type
- Inside a class
- Inside another enum
- Inside an interface

A local enum cannot be declared inside a method.

### Enum Inside a Class

```java
class TrafficSignal {

    enum Light {
        RED,
        YELLOW,
        GREEN
    }
}
```

Usage:

```java
TrafficSignal.Light light =
        TrafficSignal.Light.RED;
```

---

## 3. Enum Constants Are Objects

Every enum constant is a single object of the enum type.

```java
enum Color {
    RED,
    GREEN,
    BLUE
}
```

Conceptually, these constants behave like:

```java
public static final Color RED;
public static final Color GREEN;
public static final Color BLUE;
```

The compiler and JVM manage their creation.

We cannot create enum objects explicitly:

```java
Color color = new Color(); // Compile-time error
```

---

## 4. Enum and `java.lang.Enum`

Every enum implicitly extends:

```java
java.lang.Enum
```

A Java enum behaves like a specialized class derived from:

```java
Enum<Color>
```

Because Java supports single class inheritance, an enum cannot extend another class.

```java
enum Color extends Base {
    // Compile-time error
}
```

However, an enum can implement one or more interfaces.

```java
interface Printable {

    void print();
}
```

```java
enum Color implements Printable {

    RED,
    GREEN,
    BLUE;

    @Override
    public void print() {
        System.out.println(name());
    }
}
```

---

## 5. Can an Enum Be Extended?

An enum cannot extend another class because it already extends `java.lang.Enum`.

An enum also cannot be extended by another class or enum.

```java
class CustomColor extends Color {
    // Compile-time error
}
```

Therefore, an enum cannot be used as a superclass.

---

## 6. Comparing Enum Constants

Enum constants can safely be compared using `==`.

```java
Color first = Color.RED;
Color second = Color.RED;

System.out.println(first == second); // true
```

This works because each enum constant has exactly one instance.

The `equals()` method can also be used:

```java
System.out.println(first.equals(second)); // true
```

For enums, `==` is generally preferred because it is:

- Simple
- Type-safe
- Null-safe when the known constant is on the left

```java
Color color = null;

if (Color.RED == color) {
    System.out.println("Red");
}
```

---

## 7. Comparing Different Enum Types

Consider two different enum types:

```java
enum Color {
    RED
}

enum Signal {
    RED
}
```

The following comparison is invalid:

```java
Color.RED == Signal.RED; // Compile-time error
```

They belong to different enum types, even though they have the same name and ordinal position.

Using `equals()` returns `false`:

```java
System.out.println(
        Color.RED.equals(Signal.RED)
); // false
```

---

# Built-In Enum Methods

## 8. `values()`

The compiler adds a `values()` method to every enum.

It returns an array containing all constants in declaration order.

```java
enum Color {
    RED,
    GREEN,
    BLUE
}
```

```java
Color[] colors = Color.values();

for (Color color : colors) {
    System.out.println(color);
}
```

Output:

```text
RED
GREEN
BLUE
```

> `values()` is generated separately for every enum by the compiler. It is not declared directly in `java.lang.Enum`.

---

## 9. `ordinal()`

The `ordinal()` method returns the position of an enum constant in its declaration.

Indexing starts from `0`.

```java
enum Color {
    RED,
    GREEN,
    BLUE
}
```

```java
System.out.println(Color.RED.ordinal());   // 0
System.out.println(Color.GREEN.ordinal()); // 1
System.out.println(Color.BLUE.ordinal());  // 2
```

### Important Warning

Do not use `ordinal()` for:

- Database storage
- API values
- Business logic
- Persistent identifiers

Changing the order of constants changes their ordinal values.

Use an explicit field instead:

```java
enum Status {

    PENDING(1),
    APPROVED(2),
    REJECTED(3);

    private final int code;

    Status(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
```

---

## 10. `valueOf()`

The `valueOf()` method returns an enum constant whose name exactly matches the given string.

```java
Color color = Color.valueOf("RED");

System.out.println(color); // RED
```

The comparison is case-sensitive:

```java
Color.valueOf("red"); // IllegalArgumentException
```

It throws `IllegalArgumentException` if the constant does not exist:

```java
Color.valueOf("BLACK"); // IllegalArgumentException
```

Passing `null` causes `NullPointerException`.

---

## 11. Safe String Conversion

When input may contain invalid values, handle the conversion safely.

```java
static Color findColor(String value) {
    if (value == null) {
        return null;
    }

    try {
        return Color.valueOf(
                value.trim().toUpperCase()
        );
    } catch (IllegalArgumentException exception) {
        return null;
    }
}
```

Usage:

```java
Color color = findColor("green");

System.out.println(color); // GREEN
```

---

## 12. `name()` and `toString()`

The `name()` method returns the exact declared name of the constant.

```java
System.out.println(Color.RED.name()); // RED
```

By default, `toString()` also returns the constant name:

```java
System.out.println(Color.RED.toString()); // RED
```

However, `toString()` can be overridden:

```java
enum Color {

    RED;

    @Override
    public String toString() {
        return "Red Color";
    }
}
```

```java
System.out.println(Color.RED.name());
System.out.println(Color.RED.toString());
```

Output:

```text
RED
Red Color
```

### Difference

- `name()` always returns the exact declared constant name.
- `toString()` can return a customized value.

---

# Enum Fields and Constructors

## 13. Enum with Fields

An enum can contain instance fields.

```java
enum OrderStatus {

    PENDING("Order is pending"),
    SHIPPED("Order has been shipped"),
    DELIVERED("Order has been delivered");

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
```

Usage:

```java
OrderStatus status = OrderStatus.SHIPPED;

System.out.println(status.getDescription());
```

Output:

```text
Order has been shipped
```

Each enum constant can store its own associated data.

---

## 14. Enum Constructor

An enum can contain a constructor.

The constructor executes separately for each enum constant when the enum class is initialized.

```java
enum Color {

    RED("FF0000"),
    GREEN("00FF00"),
    BLUE("0000FF");

    private final String hexCode;

    Color(String hexCode) {
        this.hexCode = hexCode;
    }

    public String getHexCode() {
        return hexCode;
    }
}
```

Conceptually:

```text
RED   → Color("FF0000")
GREEN → Color("00FF00")
BLUE  → Color("0000FF")
```

Usage:

```java
System.out.println(Color.RED.getHexCode());
```

Output:

```text
FF0000
```

---

## 15. Enum Constructor Rules

- An enum constructor cannot be called directly.
- An enum constructor cannot be `public` or `protected`.
- It can be explicitly `private`.
- It can have no access modifier.
- It is implicitly private when no modifier is used.
- Enum objects cannot be created using `new`.
- The constructor initializes each enum constant.

Valid constructor:

```java
enum Color {

    RED;

    private Color() {
    }
}
```

Also valid:

```java
enum Color {

    RED;

    Color() {
    }
}
```

Invalid constructor:

```java
enum Color {

    RED;

    public Color() {
        // Compile-time error
    }
}
```

---

# Methods in Enums

## 16. Concrete Methods

An enum can contain concrete methods.

```java
enum Operation {

    ADD,
    SUBTRACT;

    public int calculate(int first, int second) {
        if (this == ADD) {
            return first + second;
        }

        return first - second;
    }
}
```

Usage:

```java
int result = Operation.ADD.calculate(10, 5);

System.out.println(result); // 15
```

---

## 17. Abstract Methods in Enums

An enum can contain abstract methods.

Each enum constant must provide its implementation.

```java
enum Operation {

    ADD {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },

    SUBTRACT {
        @Override
        public int calculate(int first, int second) {
            return first - second;
        }
    };

    public abstract int calculate(
            int first,
            int second
    );
}
```

Usage:

```java
System.out.println(
        Operation.ADD.calculate(10, 5)
); // 15

System.out.println(
        Operation.SUBTRACT.calculate(10, 5)
); // 5
```

This is called **constant-specific behavior**.

---

## 18. Enum Implementing an Interface

An enum can implement one or more interfaces.

```java
interface Calculable {

    int calculate(int first, int second);
}
```

```java
enum Operation implements Calculable {

    ADD {
        @Override
        public int calculate(int first, int second) {
            return first + second;
        }
    },

    MULTIPLY {
        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    }
}
```

An interface reference can refer to an enum constant:

```java
Calculable operation = Operation.ADD;

System.out.println(
        operation.calculate(10, 5)
); // 15
```

---

# Enum with `switch`

## 19. Using Enum in a Switch Statement

Enums can be used directly with `switch`.

```java
enum Day {
    MONDAY,
    SATURDAY,
    SUNDAY
}
```

```java
Day day = Day.SATURDAY;

switch (day) {
    case MONDAY:
        System.out.println("Working day");
        break;

    case SATURDAY:
    case SUNDAY:
        System.out.println("Weekend");
        break;
}
```

Output:

```text
Weekend
```

Inside a `case`, use only the enum constant name:

```java
case MONDAY:
```

Do not use the enum type name:

```java
case Day.MONDAY: // Compile-time error
```

---

## 20. Enum with Switch Expression

Modern Java supports switch expressions.

```java
String dayType = switch (day) {
    case MONDAY -> "Working day";
    case SATURDAY, SUNDAY -> "Weekend";
};
```

```java
System.out.println(dayType);
```

Output:

```text
Weekend
```

---

# Main Method Inside Enum

## 21. Enum with `main()`

An enum can contain a `main()` method.

```java
enum Color {

    RED,
    GREEN,
    BLUE;

    public static void main(String[] args) {
        for (Color color : Color.values()) {
            System.out.println(color);
        }
    }
}
```

An enum is a valid Java type, so its `main()` method can be used as an application entry point.

---

# Enum Collections

## 22. `EnumSet`

`EnumSet` is a specialized set implementation for enum constants.

```java
import java.util.EnumSet;

enum Permission {
    READ,
    WRITE,
    DELETE
}
```

```java
EnumSet<Permission> permissions =
        EnumSet.of(
                Permission.READ,
                Permission.WRITE
        );
```

```java
System.out.println(permissions);
```

Output:

```text
[READ, WRITE]
```

Use `EnumSet` instead of a general-purpose set when all elements belong to the same enum type.

Useful methods include:

```java
EnumSet.allOf(Permission.class);
EnumSet.noneOf(Permission.class);
EnumSet.of(Permission.READ);
```

---

## 23. `EnumMap`

`EnumMap` is a specialized map whose keys are enum constants.

```java
import java.util.EnumMap;

enum Day {
    MONDAY,
    SATURDAY,
    SUNDAY
}
```

```java
EnumMap<Day, String> schedule =
        new EnumMap<>(Day.class);

schedule.put(Day.MONDAY, "Development");
schedule.put(Day.SATURDAY, "Revision");
schedule.put(Day.SUNDAY, "Rest");
```

```java
System.out.println(
        schedule.get(Day.MONDAY)
);
```

Output:

```text
Development
```

Use `EnumMap` when enum constants are used as map keys.

---

# Summary

- An enum represents a fixed set of named constants.
- An enum is declared using the `enum` keyword.
- Every enum constant is a single object of the enum type.
- Every enum implicitly extends `java.lang.Enum`.
- An enum cannot extend another class.
- An enum cannot be used as a superclass.
- An enum can implement multiple interfaces.
- Enum objects cannot be created explicitly using `new`.
- Enum constants can safely be compared using `==`.
- `values()` returns all constants in declaration order.
- `ordinal()` returns the declaration position starting from zero.
- `valueOf()` converts an exact string name into an enum constant.
- `valueOf()` is case-sensitive.
- Do not use `ordinal()` as a persistent identifier.
- `name()` returns the exact declared constant name.
- `toString()` can be overridden.
- An enum can contain fields, constructors, and methods.
- Enum constructors cannot be `public` or `protected`.
- An enum can contain abstract methods.
- Constants can provide constant-specific behavior.
- Enums can be used with `switch`.
- `EnumSet` is designed for sets of enum constants.
- `EnumMap` is designed for maps with enum keys.

---

# Important Interview Questions

## 1. What is an enum in Java?

An enum is a special Java type that represents a fixed set of named constants.

```java
enum Status {
    PENDING,
    APPROVED,
    REJECTED
}
```

---

## 2. Is an enum a class?

An enum is a special class type.

Every enum implicitly extends:

```java
java.lang.Enum
```

Its constants are objects of the enum type.

---

## 3. Can an enum extend another class?

No.

Every enum already extends `java.lang.Enum`, and Java supports only single class inheritance.

---

## 4. Can an enum implement an interface?

Yes.

```java
enum Operation implements Calculable {
    // Constants and implementations
}
```

An enum can implement multiple interfaces.

---

## 5. Can we create an enum object using `new`?

No.

Enum constants are predefined objects created and managed by the Java runtime.

```java
Color color = new Color(); // Compile-time error
```

---

## 6. Can an enum constructor be public?

No.

An enum constructor can be private or package-private. It cannot be public or protected.

---

## 7. When is an enum constructor executed?

It executes once for each enum constant when the enum class is initialized.

---

## 8. Can an enum have fields?

Yes.

Each enum constant can store its own associated data.

```java
enum Status {

    SUCCESS(200),
    ERROR(500);

    private final int code;

    Status(int code) {
        this.code = code;
    }
}
```

---

## 9. Can an enum have abstract methods?

Yes.

Each enum constant must provide an implementation when the enum declares an abstract method.

```java
enum Operation {

    ADD {
        @Override
        int calculate(int first, int second) {
            return first + second;
        }
    };

    abstract int calculate(int first, int second);
}
```

---

## 10. Should enums be compared using `==` or `equals()`?

Both work, but `==` is generally preferred.

Each enum constant has only one instance, so identity comparison is safe.

```java
Color.RED == Color.RED
```

---

## 11. What does `values()` return?

It returns an array containing all enum constants in declaration order.

```java
Color[] colors = Color.values();
```

---

## 12. Is `values()` declared in `java.lang.Enum`?

No.

The Java compiler generates `values()` separately for every enum type.

---

## 13. What does `valueOf()` do?

It returns the enum constant whose declared name exactly matches the given string.

```java
Color color = Color.valueOf("RED");
```

It is case-sensitive and throws `IllegalArgumentException` for an invalid name.

---

## 14. What happens when `null` is passed to `valueOf()`?

It throws `NullPointerException`.

```java
Color.valueOf(null);
```

---

## 15. Why should `ordinal()` not be stored in a database?

The ordinal depends on the declaration order.

Reordering or inserting constants can change ordinal values and corrupt persisted meaning.

Use an explicit field instead:

```java
enum Status {

    PENDING(1),
    APPROVED(2);

    private final int code;

    Status(int code) {
        this.code = code;
    }
}
```

---

## 16. What is the difference between `name()` and `toString()`?

- `name()` always returns the exact declared constant name.
- `toString()` can be overridden to return a customized value.

---

## 17. Can an enum contain a `main()` method?

Yes.

An enum can contain static methods, including a valid `main()` method.

---

## 18. Can an enum be extended?

No.

An enum cannot be used as a superclass.

---

## 19. Can two constants from different enums be equal?

No.

Constants from different enum types represent different objects, even if their names or ordinal values are the same.

```java
Color.RED.equals(Signal.RED); // false
```

---

## 20. What are `EnumSet` and `EnumMap`?

- `EnumSet` is a specialized set for enum constants.
- `EnumMap` is a specialized map that uses enum constants as keys.

---

## 21. Why should an enum be preferred over integer constants?

Enums provide:

- Compile-time type safety
- Better readability
- Restricted valid values
- Support for fields and methods
- Easy use with `switch`

Example:

```java
void updateStatus(OrderStatus status) {
}
```

Only valid `OrderStatus` constants can be passed.

---

## 22. Can an enum constant have its own method implementation?

Yes.

An enum constant can have constant-specific behavior.

```java
enum Operation {

    ADD {
        @Override
        int calculate(int first, int second) {
            return first + second;
        }
    },

    MULTIPLY {
        @Override
        int calculate(int first, int second) {
            return first * second;
        }
    };

    abstract int calculate(int first, int second);
}
```