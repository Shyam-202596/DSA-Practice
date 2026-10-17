# Enums in Java

## 1. Enum

An **enum** is a special Java type that represents a fixed set of named constants.

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
- Fixed set of allowed values
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
- Inside another enum or interface

A local enum declaration inside a method is not allowed.

### Inside a Class

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

Conceptually, the constants behave like:

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

Conceptually:

```java
enum Color {
    RED,
    GREEN,
    BLUE
}
```

behaves like a specialized class derived from:

```java
Enum<Color>
```

Because Java supports single class inheritance, an enum cannot extend another class.

```java
enum Color extends Base {
    // Compile-time error
}
```

An enum can implement one or more interfaces:

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

Every enum is implicitly final when none of its constants has a class body.

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

For enum constants, `==` is generally preferred because it is:

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

## 7. Different Enum Types Cannot Be Compared Using `==`

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

The constants belong to different enum types, even though they have the same name and ordinal position.

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

It returns all constants in declaration order.

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

> `values()` is generated for each enum by the compiler. It is not declared directly in `java.lang.Enum`.

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

The `valueOf()` method returns the enum constant whose name exactly matches the given string.

```java
Color color = Color.valueOf("RED");

System.out.println(color); // RED
```

The comparison is case-sensitive:

```java
Color.valueOf("red"); // IllegalArgumentException
```

It also throws `IllegalArgumentException` if the name does not exist:

```java
Color.valueOf("BLACK"); // IllegalArgumentException
```

Passing `null` causes `NullPointerException`.

---

## 11. Safe String Conversion