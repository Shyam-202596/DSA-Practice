# Inheritance in Java

## 1. Inheritance

Inheritance allows one class to acquire the accessible properties and behaviors of another class.

- The existing class is called the **superclass**, **parent class**, or **base class**.
- The new class is called the **subclass**, **child class**, or **derived class**.

Inheritance represents an **IS-A relationship**.

```java
class Vehicle {
}

class Bus extends Vehicle {
}
```

Here, `Bus` IS-A `Vehicle`.

---

## 2. Syntax

The `extends` keyword is used for class inheritance.

```java
class Subclass extends Superclass {
    // Fields and methods
}
```

Example:

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}

class Bus extends Vehicle {

    void displayRoute() {
        System.out.println("Displaying bus route");
    }
}
```

Usage:

```java
Bus bus = new Bus();

bus.start();
bus.displayRoute();
```

---

## 3. Important Inheritance Rules

- A Java class can directly extend only one class.
- Java does not support multiple inheritance through classes.
- A class can implement multiple interfaces.
- A subclass can become the superclass of another class.
- A class cannot directly or indirectly extend itself.
- Every class except `Object` directly or indirectly extends the `Object` class.

Invalid multiple-class inheritance:

```java
class Child extends ParentOne, ParentTwo {
    // Compile-time error
}
```

Multiple interfaces are allowed:

```java
class Child implements InterfaceOne, InterfaceTwo {
}
```

---

## 4. Types of Inheritance

### Single Inheritance

```text
Parent
  ↑
Child
```

```java
class Vehicle {
}

class Bus extends Vehicle {
}
```

### Multilevel Inheritance

```text
Vehicle
   ↑
  Bus
   ↑
ElectricBus
```

```java
class Vehicle {
}

class Bus extends Vehicle {
}

class ElectricBus extends Bus {
}
```

### Hierarchical Inheritance

```text
       Vehicle
       /     \
     Bus     Car
```

```java
class Vehicle {
}

class Bus extends Vehicle {
}

class Car extends Vehicle {
}
```

Java does not support multiple or hybrid inheritance through classes because it can create ambiguity.

Multiple inheritance of type can be achieved using interfaces.

---

## 5. Inherited Members

A subclass inherits accessible members of its superclass.

```java
class Parent {

    protected int value = 10;

    void display() {
        System.out.println(value);
    }
}

class Child extends Parent {

    void show() {
        display();
        System.out.println(value);
    }
}
```

The child can use the inherited `value` and `display()` members.

### Private Members

Private members cannot be accessed directly by a subclass.

```java
class Parent {

    private int value = 10;
}

class Child extends Parent {

    void show() {
        System.out.println(value); // Compile-time error
    }
}
```

The superclass can provide controlled access:

```java
class Parent {

    private int value = 10;

    protected int getValue() {
        return value;
    }
}

class Child extends Parent {

    void show() {
        System.out.println(getValue());
    }
}
```

The private field remains part of the parent portion of the child object, but the child cannot access it directly.

---

# Superclass Reference and Subclass Object

## 6. Upcasting

A superclass reference can refer to an object of its subclass.

```java
Vehicle vehicle = new Bus();
```

This is called **upcasting**.

Upcasting is performed automatically because every `Bus` is also a `Vehicle`.

```text
Superclass reference → Subclass object
```

Another example:

```java
Box plainBox = new BoxWeight();
```

Here:

- Reference type: `Box`
- Actual object type: `BoxWeight`

---

## 7. Accessible Members

The reference type determines which members are accessible at compile time.

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}

class Bus extends Vehicle {

    void displayRoute() {
        System.out.println("Displaying route");
    }
}
```

```java
Vehicle vehicle = new Bus();

vehicle.start();
vehicle.displayRoute(); // Compile-time error
```

`displayRoute()` cannot be accessed because it is not declared in the `Vehicle` reference type.

### Important Rule

> Reference type decides member accessibility at compile time.

However, if an accessible instance method is overridden, the actual object type decides which implementation executes.

```java
class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}

class Bus extends Vehicle {

    @Override
    void start() {
        System.out.println("Bus starts");
    }
}
```

```java
Vehicle vehicle = new Bus();

vehicle.start(); // Bus starts
```

### Compile-Time vs Runtime

- Accessible members are checked using the reference type.
- Overridden instance methods are selected using the runtime object type.

---

## 8. Downcasting

Downcasting converts a superclass reference back to a subclass reference.

```java
Vehicle vehicle = new Bus();

Bus bus = (Bus) vehicle;
bus.displayRoute();
```

Downcasting must be explicit.

Unsafe downcasting can produce `ClassCastException`.

```java
Vehicle vehicle = new Vehicle();

Bus bus = (Bus) vehicle; // ClassCastException
```

Use `instanceof` before downcasting when the runtime type is uncertain.

```java
if (vehicle instanceof Bus) {
    Bus bus = (Bus) vehicle;
    bus.displayRoute();
}
```

Modern Java also supports pattern matching:

```java
if (vehicle instanceof Bus bus) {
    bus.displayRoute();
}
```

---

# The `super` Keyword

## 9. Uses of `super`

The `super` keyword refers to the immediate superclass part of the current object.

It is mainly used to:

1. Call a superclass constructor.
2. Access a hidden superclass field.
3. Call an overridden superclass method.

---

## 10. Calling a Superclass Constructor

Use `super()` to invoke a constructor of the immediate superclass.

```java
class Box {

    private double width;
    private double height;
    private double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
}
```

```java
class BoxWeight extends Box {

    private double weight;

    BoxWeight(
        double width,
        double height,
        double depth,
        double weight
    ) {
        super(width, height, depth);
        this.weight = weight;
    }
}
```

Here:

- `Box` initializes `width`, `height`, and `depth`.
- `BoxWeight` initializes only `weight`.

This preserves encapsulation because the superclass can keep its fields private.

---

## 11. Rules of `super()`

- `super()` invokes a constructor of the immediate superclass.
- It can be used only inside a constructor.
- It must be the first statement of the constructor.
- It cannot directly skip a superclass level.
- It can pass arguments to a parameterized superclass constructor.

The following code is invalid:

```java
BoxWeight(double weight) {
    this.weight = weight;
    super(10, 20, 30); // Compile-time error
}
```

Correct version:

```java
BoxWeight(double weight) {
    super(10, 20, 30);
    this.weight = weight;
}
```

---

## 12. Implicit `super()`

If a constructor does not explicitly begin with `this()` or `super()`, the compiler inserts:

```java
super();
```

Example:

```java
class BoxWeight extends Box {

    BoxWeight() {
        System.out.println("BoxWeight constructor");
    }
}
```

It behaves like:

```java
class BoxWeight extends Box {

    BoxWeight() {
        super();
        System.out.println("BoxWeight constructor");
    }
}
```

This works only if the immediate superclass has an accessible no-argument constructor.

If the superclass has only a parameterized constructor, the subclass must call it explicitly.

```java
class Box {

    Box(double width) {
    }
}

class BoxWeight extends Box {

    BoxWeight(double width) {
        super(width);
    }
}
```

---

## 13. Constructor Execution Order

Superclass constructors execute before subclass constructors.

```java
class Box {

    Box() {
        System.out.println("Box constructor");
    }
}

class BoxWeight extends Box {

    BoxWeight() {
        System.out.println("BoxWeight constructor");
    }
}

class BoxPrice extends BoxWeight {

    BoxPrice() {
        System.out.println("BoxPrice constructor");
    }
}
```

```java
BoxPrice box = new BoxPrice();
```

Output:

```text
Box constructor
BoxWeight constructor
BoxPrice constructor
```

Execution order:

```text
Object → Box → BoxWeight → BoxPrice
```

Each `super()` call refers to the immediate superclass:

- `BoxPrice` calls `BoxWeight`.
- `BoxWeight` calls `Box`.
- `Box` calls `Object`.

---

# Copy Constructor with Inheritance

## 14. Superclass Copy Constructor

A copy constructor accepts another object and copies its fields.

```java
class Box {

    private double width;
    private double height;
    private double depth;

    Box(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    Box(Box other) {
        this.width = other.width;
        this.height = other.height;
        this.depth = other.depth;
    }
}
```

A class can access private fields of another object of the same class.

---

## 15. Subclass Copy Constructor

```java
class BoxWeight extends Box {

    private double weight;

    BoxWeight(BoxWeight other) {
        super(other);
        this.weight = other.weight;
    }
}
```

`super(other)` calls:

```java
Box(Box other)
```

This is valid because a `BoxWeight` object is also a `Box`.

The superclass constructor copies only the superclass part of the object. The subclass constructor copies the subclass-specific field.

---

# Accessing Superclass Members

## 16. Accessing a Hidden Superclass Field

If a subclass declares a field with the same name as a superclass field, the subclass field hides the superclass field.

```java
class Parent {

    int value = 10;
}

class Child extends Parent {

    int value = 20;

    void display() {
        System.out.println(value);
        System.out.println(this.value);
        System.out.println(super.value);
    }
}
```

Output:

```text
20
20
10
```

Here:

- `value` refers to the child field.
- `this.value` refers to the child field.
- `super.value` refers to the parent field.

> Fields are hidden, not overridden.

---

## 17. Calling an Overridden Superclass Method

```java
class Parent {

    void display() {
        System.out.println("Parent display");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child display");
    }

    void showParentDisplay() {
        super.display();
    }
}
```

Usage:

```java
Child child = new Child();

child.display();
child.showParentDisplay();
```

Output:

```text
Child display
Parent display
```

`super.display()` explicitly calls the immediate superclass implementation.

---

## 18. `this` vs `super`

### `this`

Refers to the current object.

```java
this.value
this.display()
this()
```

### `super`

Refers to the immediate superclass part of the current object.

```java
super.value
super.display()
super()
```

Important difference:

- `this()` calls another constructor of the same class.
- `super()` calls a constructor of the immediate superclass.
- Both must be the first constructor statement.
- Therefore, both cannot be called directly from the same constructor.

---

# `final` with Inheritance

## 19. Final Method

A final method cannot be overridden.

```java
class Parent {

    final void display() {
        System.out.println("Parent display");
    }
}
```

The following code is invalid:

```java
class Child extends Parent {

    @Override
    void display() { // Compile-time error
        System.out.println("Child display");
    }
}
```

A final method can still be inherited and called by the subclass.

```java
Child child = new Child();
child.display();
```

> Use `final` to prevent method overriding for design correctness, not as a performance optimization. Modern JVMs can optimize methods even when they are not final.

---

## 20. Final Class

A final class cannot be extended.

```java
final class SecurityToken {
}
```

The following code is invalid:

```java
class CustomToken extends SecurityToken {
    // Compile-time error
}
```

A final class is useful when:

- Inheritance must be prevented.
- Class behavior must not be modified through overriding.
- Design invariants must be protected.
- An immutable class is being created.

A final class cannot be abstract.

```java
abstract final class Example {
    // Compile-time error
}
```

Reason:

- An abstract class requires subclassing to complete its behavior.
- A final class prevents subclassing.

---

## 21. Are All Methods of a Final Class Final?

A final class cannot be extended, so none of its methods can be overridden by a subclass.

However, its methods are not required to be explicitly declared `final`.

```java
final class Utility {

    void execute() {
        System.out.println("Executing");
    }
}
```

The practical result is that `execute()` cannot be overridden because no subclass can exist.

---

# Static Methods and Inheritance

## 22. Static Method Hiding

Static methods belong to the class rather than to individual objects.

They are **hidden**, not overridden.

```java
class Parent {

    static void display() {
        System.out.println("Parent static method");
    }
}

class Child extends Parent {

    static void display() {
        System.out.println("Child static method");
    }
}
```

```java
Parent reference = new Child();

reference.display();
```

Output:

```text
Parent static method
```

Static method selection depends on the compile-time reference type.

Prefer calling static methods using the class name:

```java
Parent.display();
Child.display();
```

### Important Rule

> Runtime polymorphism does not apply to static methods.

---

## 23. Static Interface Methods

A static interface method must have a body.

```java
interface Vehicle {

    static void displayType() {
        System.out.println("Vehicle");
    }
}
```

It is called using the interface name:

```java
Vehicle.displayType();
```

Static interface methods are not inherited by implementing classes.

```java
class Bus implements Vehicle {
}
```

The following call is invalid:

```java
Bus.displayType(); // Compile-time error
```

Use:

```java
Vehicle.displayType();
```

---

# Variables and Polymorphism

## 24. Polymorphism Does Not Apply to Fields

Fields are resolved using the compile-time reference type.

```java
class Parent {

    int value = 10;
}

class Child extends Parent {

    int value = 20;
}
```

```java
Parent reference = new Child();

System.out.println(reference.value);
```

Output:

```text
10
```

The reference type is `Parent`, so `Parent.value` is selected.

For overridden methods, runtime polymorphism applies:

```java
class Parent {

    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    @Override
    void display() {
        System.out.println("Child");
    }
}
```

```java
Parent reference = new Child();

reference.display();
```

Output:

```text
Child
```

### Key Difference

- Fields are hidden and resolved using the reference type.
- Overridden instance methods are resolved using the runtime object type.
- Static methods are hidden and resolved using the reference type.

---

# Summary

- Inheritance creates an IS-A relationship.
- Java uses `extends` for class inheritance.
- A class can directly extend only one class.
- Private members cannot be accessed directly by subclasses.
- A superclass reference can refer to a subclass object.
- Reference type controls compile-time member accessibility.
- Runtime object type controls overridden instance-method execution.
- `super()` calls an immediate superclass constructor.
- `super.member` accesses an immediate superclass member.
- Superclass constructors execute before subclass constructors.
- A final method cannot be overridden.
- A final class cannot be extended.
- Static methods are hidden, not overridden.
- Fields are hidden, not overridden.
- Runtime polymorphism applies only to overridden instance methods.

---

# Important Interview Questions

## 1. Why does Java not support multiple inheritance through classes?

Multiple-class inheritance can create ambiguity when multiple parents provide the same method or state.

Java supports multiple inheritance of type through interfaces.

---

## 2. Can a superclass reference hold a subclass object?

Yes.

```java
Vehicle vehicle = new Bus();
```

This is called upcasting.

---

## 3. Which type decides accessible members?

The compile-time reference type decides which members can be accessed.

```java
Vehicle vehicle = new Bus();
```

Only members declared or inherited by `Vehicle` are directly accessible through `vehicle`.

---

## 4. Which type decides an overridden method call?

The runtime object type decides which overridden instance method executes.

```java
Vehicle vehicle = new Bus();
vehicle.start();
```

If `Bus` overrides `start()`, the `Bus` implementation executes.

---

## 5. Does a subclass inherit private members?

Private fields remain part of the parent portion of the child object, but the subclass cannot access them directly.

The superclass should provide controlled access through methods when required.

---

## 6. What is the difference between upcasting and downcasting?

Upcasting converts a subclass reference to a superclass reference and happens automatically.

```java
Vehicle vehicle = new Bus();
```

Downcasting converts a superclass reference to a subclass reference and must be explicit.

```java
Bus bus = (Bus) vehicle;
```

---

## 7. What are the uses of `super`?

`super` is used to:

- Call an immediate superclass constructor.
- Access a hidden superclass field.
- Call an overridden superclass method.

---

## 8. What happens if `super()` is not written?

If the constructor does not explicitly begin with `this()` or `super()`, the compiler inserts an implicit no-argument `super()` call.

The parent must have an accessible no-argument constructor.

---

## 9. Why does the parent constructor execute first?

The parent portion of the object must be initialized before the child-specific portion.

---

## 10. Can `this()` and `super()` be used in the same constructor?

They cannot both be called directly because each must be the first statement.

Constructor chaining can indirectly call both.

---

## 11. Are constructors inherited or overridden?

No.

Constructors belong to their declaring class. They can only be overloaded within that class.

---

## 12. Can a final method be overloaded?

Yes.

`final` prevents overriding, not overloading.

```java
class Example {

    final void display() {
    }

    final void display(int value) {
    }
}
```

---

## 13. Can a final class have non-final methods?

Yes.

However, its methods cannot be overridden because the class cannot be extended.

---

## 14. Can an abstract class be final?

No.

An abstract class requires subclassing, while a final class prevents subclassing.

---

## 15. Are static methods overridden?

No.

Static methods are hidden and selected using the compile-time reference type.

---

## 16. Does polymorphism apply to instance variables?

No.

Fields are selected using the compile-time reference type.

Runtime polymorphism applies to overridden instance methods.

---

## 17. What does `super(other)` do in a copy constructor?

It passes the object to the immediate superclass constructor.

If the superclass constructor accepts the superclass type, a subclass object can be passed because the subclass IS-A superclass.

---

## 18. What is the difference between field hiding and method overriding?

Field hiding is resolved using the reference type.

Method overriding is resolved using the runtime object type.

```java
Parent reference = new Child();

System.out.println(reference.value); // Parent field
reference.display();                 // Child method
```