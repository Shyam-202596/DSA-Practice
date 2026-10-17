# Interfaces in Java

## 1. Interface

An interface defines a contract that implementing classes must follow.

It mainly specifies **what a class should do**, without requiring how it should perform that behavior.

```java
interface Vehicle {

    void start();

    void stop();
}
```

An interface cannot be instantiated directly.

```java
Vehicle vehicle = new Vehicle(); // Compile-time error
```

---

## 2. Why Interfaces Are Used

Interfaces are mainly used for:

- Abstraction
- Loose coupling
- Runtime polymorphism
- Multiple inheritance of type
- Defining common behavior for unrelated classes
- Creating extensible and testable applications

For example, unrelated classes can implement the same interface:

```java
interface Printable {

    void print();
}
```

```java
class Invoice implements Printable {

    @Override
    public void print() {
        System.out.println("Printing invoice");
    }
}
```

```java
class Report implements Printable {

    @Override
    public void print() {
        System.out.println("Printing report");
    }
}
```

---

# Multiple Inheritance

## 3. Multiple Inheritance Through Classes

Java does not support multiple inheritance through classes.

The following declaration is invalid:

```java
class Child extends ParentOne, ParentTwo {
    // Compile-time error
}
```

One reason is the ambiguity that can occur when two parent classes define the same method.

```text
ParentOne → display()
ParentTwo → display()
        \   /
         Child
```

The child class would not know which inherited implementation should be used.

---

## 4. Multiple Inheritance Through Interfaces

A class can implement multiple interfaces.

```java
interface Printable {

    void print();
}
```

```java
interface Scannable {

    void scan();
}
```

```java
class MultiFunctionPrinter
        implements Printable, Scannable {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }
}
```

Interfaces avoid multiple inheritance of class state because they do not contain normal instance fields.

---

# Interface Members

## 5. Abstract Methods

A method declared without a body inside an interface is implicitly:

```text
public abstract
```

Example:

```java
interface Vehicle {

    void start();
}
```

It is equivalent to:

```java
interface Vehicle {

    public abstract void start();
}
```

The implementing method must be declared `public`.

```java
class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }
}
```

The following implementation is invalid:

```java
class Bus implements Vehicle {

    @Override
    void start() { // Compile-time error
        System.out.println("Bus starts");
    }
}
```

This reduces visibility from `public` to package-private.

---

## 6. Interface Variables

Variables declared inside an interface are implicitly:

```text
public static final
```

Example:

```java
interface Vehicle {

    int MAX_SPEED = 120;
}
```

It is equivalent to:

```java
interface Vehicle {

    public static final int MAX_SPEED = 120;
}
```

Interface variables:

- Must be initialized.
- Belong to the interface.
- Cannot be reassigned.
- Are accessible using the interface name.

```java
System.out.println(Vehicle.MAX_SPEED);
```

The following operation is invalid:

```java
Vehicle.MAX_SPEED = 150; // Compile-time error
```

> An interface cannot maintain per-object state because it cannot contain normal instance variables.

---

## 7. Types of Interface Methods

A modern Java interface can contain:

- Abstract methods
- Default methods
- Static methods
- Private methods
- Private static methods

```java
interface Vehicle {

    void start();

    default void stop() {
        log("Vehicle stopped");
    }

    static void displayType() {
        staticLog("Vehicle");
    }

    private void log(String message) {
        System.out.println(message);
    }

    private static void staticLog(String message) {
        System.out.println(message);
    }
}
```

---

# Implementing an Interface

## 8. The `implements` Keyword

A class implements an interface using the `implements` keyword.

```java
interface Vehicle {

    void start();

    void stop();
}
```

```java
class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }

    @Override
    public void stop() {
        System.out.println("Bus stops");
    }
}
```

A concrete class must implement all abstract methods of the interface.

If it does not implement every method, it must be declared abstract.

```java
abstract class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }
}
```

A concrete subclass must implement the remaining method:

```java
class ElectricBus extends Bus {

    @Override
    public void stop() {
        System.out.println("Electric bus stops");
    }
}
```

---

## 9. Additional Class Members

An implementing class can define its own additional fields and methods.

```java
class Bus implements Vehicle {

    private String route;

    @Override
    public void start() {
        System.out.println("Bus starts");
    }

    @Override
    public void stop() {
        System.out.println("Bus stops");
    }

    public void displayRoute() {
        System.out.println(route);
    }
}
```

The interface only defines the required contract. It does not limit the class from adding its own functionality.

---

# Interface Reference

## 10. Interface Reference and Implementing Object

An interface reference can refer to an object of any class that implements that interface.

```java
Vehicle vehicle = new Bus();
```

Here:

- `Vehicle` is the reference type.
- `Bus` is the actual object type.

Only methods available through the interface reference are directly accessible.

```java
vehicle.start();
vehicle.stop();
```

A class-specific method cannot be accessed directly:

```java
vehicle.displayRoute(); // Compile-time error
```

---

## 11. Runtime Polymorphism

The actual runtime object decides which implementation executes.

```java
interface PaymentService {

    void pay();
}
```

```java
class CardPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment through card");
    }
}
```

```java
class UpiPayment implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Payment through UPI");
    }
}
```

```java
PaymentService service = new CardPayment();
service.pay();

service = new UpiPayment();
service.pay();
```

Output:

```text
Payment through card
Payment through UPI
```

This allows calling code to depend on the interface without knowing the exact implementation.

---

## 12. Loose Coupling

Consider a service that directly depends on a concrete class:

```java
class OrderService {

    private final CardPayment payment =
            new CardPayment();
}
```

This creates tight coupling.

A better approach is to depend on an interface:

```java
class OrderService {

    private final PaymentService paymentService;

    OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    void placeOrder() {
        paymentService.pay();
    }
}
```

Usage:

```java
PaymentService paymentService =
        new UpiPayment();

OrderService orderService =
        new OrderService(paymentService);

orderService.placeOrder();
```

This makes the code easier to:

- Extend
- Test
- Maintain
- Replace with another implementation

---

# Extending Interfaces

## 13. Interface Inheritance

An interface can extend another interface.

```java
interface Vehicle {

    void start();
}
```

```java
interface ElectricVehicle extends Vehicle {

    void charge();
}
```

A concrete class must implement methods from both interfaces.

```java
class ElectricBus implements ElectricVehicle {

    @Override
    public void start() {
        System.out.println("Electric bus starts");
    }

    @Override
    public void charge() {
        System.out.println("Electric bus charges");
    }
}
```

---

## 14. Extending Multiple Interfaces

An interface can extend multiple interfaces.

```java
interface Printable {

    void print();
}
```

```java
interface Scannable {

    void scan();
}
```

```java
interface MultiFunctionDevice
        extends Printable, Scannable {

    void copy();
}
```

The implementing class must implement all inherited methods.

```java
class Printer implements MultiFunctionDevice {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void copy() {
        System.out.println("Copying");
    }
}
```

---

# Default Methods

## 15. Default Interface Method

A default method contains a method body and uses the `default` keyword.

```java
interface Vehicle {

    default void stop() {
        System.out.println("Vehicle stopped");
    }
}
```

The implementing class can use the default implementation:

```java
class Bus implements Vehicle {
}
```

```java
Bus bus = new Bus();
bus.stop();
```

The implementing class can also override it:

```java
class Bus implements Vehicle {

    @Override
    public void stop() {
        System.out.println("Bus stopped");
    }
}
```

---

## 16. Purpose of Default Methods

Default methods allow an existing interface to add new behavior without forcing all implementing classes to change immediately.

Without a default method:

```java
interface Vehicle {

    void start();

    void stop();
}
```

Every concrete implementation must implement `stop()`.

With a default method:

```java
interface Vehicle {

    void start();

    default void stop() {
        System.out.println("Vehicle stopped");
    }
}
```

Existing implementations can use the default behavior.

---

# Default Method Conflict Rules

## 17. Class Method Has Priority

A class implementation takes priority over an interface default method.

```java
class Parent {

    public void display() {
        System.out.println("Parent display");
    }
}
```

```java
interface Printable {

    default void display() {
        System.out.println("Printable display");
    }
}
```

```java
class Child extends Parent implements Printable {
}
```

```java
Child child = new Child();
child.display();
```

Output:

```text
Parent display
```

This rule is commonly known as:

> Class wins over interface.

---

## 18. Conflict Between Two Interfaces

If two unrelated interfaces define the same default method, the implementing class must override it.

```java
interface First {

    default void display() {
        System.out.println("First");
    }
}
```

```java
interface Second {

    default void display() {
        System.out.println("Second");
    }
}
```

The following class is invalid:

```java
class Example implements First, Second {
    // Compile-time error
}
```

The conflict must be resolved explicitly:

```java
class Example implements First, Second {

    @Override
    public void display() {
        First.super.display();
    }
}
```

Both implementations can also be called:

```java
class Example implements First, Second {

    @Override
    public void display() {
        First.super.display();
        Second.super.display();
    }
}
```

---

## 19. More Specific Interface Wins

If one interface extends another and both provide the same default method, the more specific child interface wins.

```java
interface Parent {

    default void display() {
        System.out.println("Parent");
    }
}
```

```java
interface Child extends Parent {

    @Override
    default void display() {
        System.out.println("Child");
    }
}
```

```java
class Example implements Child {
}
```

```java
new Example().display();
```

Output:

```text
Child
```

---

# Static Interface Methods

## 20. Static Methods

A static interface method belongs to the interface itself.

```java
interface Vehicle {

    static void displayType() {
        System.out.println("Vehicle");
    }
}
```

It must be called using the interface name:

```java
Vehicle.displayType();
```

A static interface method:

- Must have a body.
- Cannot be abstract.
- Is not inherited by implementing classes.
- Is not inherited by subinterfaces.
- Cannot be overridden.

The following call is invalid:

```java
class Bus implements Vehicle {
}

Bus.displayType(); // Compile-time error
```

---

# Private Interface Methods

## 21. Private Methods

Private interface methods are used to share internal logic between default methods.

```java
interface Vehicle {

    default void start() {
        validate();
        System.out.println("Vehicle starts");
    }

    default void stop() {
        validate();
        System.out.println("Vehicle stops");
    }

    private void validate() {
        System.out.println("Validating vehicle");
    }
}
```

A private interface method:

- Must have a body.
- Is accessible only inside the interface.
- Is not inherited.
- Cannot be overridden.
- Cannot be abstract.

Private static methods can support other static or non-static interface methods.

---

# Nested Interfaces

## 22. Nested Interface

An interface declared inside a class or another interface is called a **nested interface**.

```java
class NumberValidator {

    public interface Validator {

        boolean isNotNegative(int number);
    }
}
```

Implementation:

```java
class PositiveNumberValidator
        implements NumberValidator.Validator {

    @Override
    public boolean isNotNegative(int number) {
        return number >= 0;
    }
}
```

Usage:

```java
public class Main {

    public static void main(String[] args) {
        NumberValidator.Validator validator =
                new PositiveNumberValidator();

        System.out.println(
                validator.isNotNegative(10)
        );

        System.out.println(
                validator.isNotNegative(-12)
        );
    }
}
```

Output:

```text
true
false
```

The nested interface is accessed using:

```java
OuterClass.NestedInterface
```

---

## 23. Access Modifiers for Interfaces

A top-level interface can be:

- `public`
- Package-private

```java
public interface Vehicle {
}
```

```java
interface Vehicle {
}
```

A top-level interface cannot be `private` or `protected`.

A nested interface declared inside a class can use:

- `public`
- `protected`
- Package-private
- `private`

A nested interface declared inside another interface is implicitly `public static`.

---

# Method Visibility When Overriding

## 24. Implementing Interface Methods

Abstract interface methods are implicitly `public`.

Therefore, their implementations must also be public.

```java
interface Vehicle {

    void start();
}
```

Correct implementation:

```java
class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }
}
```

Incorrect implementation:

```java
class Bus implements Vehicle {

    @Override
    protected void start() {
        // Compile-time error
    }
}
```

An overriding method cannot reduce the visibility of the inherited method.

For class inheritance:

```text
protected → protected or public
public    → public
```

---

# Interface vs Abstract Class

## 25. Main Differences

### Interface

- Defines a contract or capability.
- Supports multiple inheritance of type.
- Cannot contain normal instance fields.
- Does not have constructors.
- Abstract methods are implicitly public.
- Fields are implicitly `public static final`.
- Can contain default, static, and private methods.

### Abstract Class

- Represents a common base for related classes.
- Can contain instance state.
- Can have constructors.
- Can contain abstract and concrete methods.
- Can use different access modifiers.
- A class can extend only one abstract or concrete class.

### Selection Guideline

Use an interface when:

- Unrelated classes need the same capability.
- Multiple contracts are required.
- Loose coupling is important.

Use an abstract class when:

- Classes are closely related.
- Common state is required.
- Shared implementation is required.
- Constructors are needed.

---

# Summary

- An interface defines a contract.
- A class implements an interface using `implements`.
- A class can implement multiple interfaces.
- Abstract interface methods are implicitly `public abstract`.
- Interface fields are implicitly `public static final`.
- Interface fields must be initialized.
- An implementing method must be declared `public`.
- Interface references support runtime polymorphism.
- Interfaces help achieve abstraction and loose coupling.
- An interface can extend one or more interfaces.
- Default methods provide optional shared behavior.
- Class methods take priority over interface default methods.
- Conflicting default methods must be resolved explicitly.
- Static interface methods belong to the interface.
- Static interface methods are not inherited.
- Private interface methods provide internal code reuse.
- Top-level interfaces can be public or package-private.
- Runtime polymorphism applies to overridden instance methods.

---

# Important Interview Questions

## 1. Why does Java not support multiple inheritance through classes?

Multiple parent classes may contain the same method or state, creating ambiguity.

Java supports multiple inheritance of type through interfaces.

---

## 2. Can an interface contain method implementations?

Yes.

Modern Java interfaces can contain:

- Default methods
- Static methods
- Private methods
- Private static methods

---

## 3. Can an interface maintain object state?

No.

Interface fields are always `public static final`, so they are constants shared at the interface level.

---

## 4. Can a class implement multiple interfaces?

Yes.

```java
class Printer implements Printable, Scannable {
}
```

---

## 5. Can an interface extend multiple interfaces?

Yes.

```java
interface Device extends Printable, Scannable {
}
```

---

## 6. Why must an interface method implementation be public?

An abstract interface method is implicitly `public`.

An overriding or implementing method cannot reduce its visibility.

---

## 7. Can we create an interface reference?

Yes.

```java
PaymentService service =
        new CardPayment();
```

The reference can point to any object whose class implements the interface.

---

## 8. What is the purpose of default methods?

Default methods allow an interface to add behavior without immediately breaking existing implementing classes.

---

## 9. What happens when two interfaces have the same default method?

The implementing class must override the method and resolve the conflict.

```java
class Example implements First, Second {

    @Override
    public void display() {
        First.super.display();
    }
}
```

---

## 10. What happens when a class method and interface default method conflict?

The class method takes priority.

This is known as the **class wins** rule.

---

## 11. Are static interface methods inherited?

No.

They must be called using the interface name.

```java
Vehicle.displayType();
```

---

## 12. Can static interface methods be overridden?

No.

Static methods belong to the interface and do not participate in runtime polymorphism.

---

## 13. Can an interface have a constructor?

No.

An interface cannot be instantiated and does not maintain per-object state.

---

## 14. Can an interface be declared final?

No.

An interface is designed to be implemented or extended. Declaring it final would contradict its purpose.

---

## 15. Can an interface have private methods?

Yes.

Private interface methods are used as internal helper methods for default and static methods.

---

## 16. What is the difference between `extends` and `implements`?

- A class extends another class.
- A class implements an interface.
- An interface extends another interface.

```java
class Bus extends Vehicle
        implements Transport {
}
```

---

## 17. Do interface method calls have significant performance overhead?

Normally, this should not influence application design.

Modern JVMs use runtime optimizations such as method inlining and devirtualization. Prefer interfaces for good design unless profiling identifies a real performance problem.

---

## 18. Interface or abstract class: which should be preferred?

Use an interface for contracts, capabilities, loose coupling, and multiple type inheritance.

Use an abstract class for shared state, constructors, and common implementation among closely related classes.