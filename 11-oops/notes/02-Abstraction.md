# Abstract Class and Abstract Methods in Java

## 1. Abstract Class

An **abstract class** is a class declared using the `abstract` keyword.

It provides a generalized structure that can be shared by its subclasses.

```java
abstract class Shape {
    abstract void draw();
}
```

An abstract class can contain:

- Abstract methods
- Concrete methods
- Constructors
- Instance variables
- Static variables
- Final and non-final variables
- Static methods

The main purpose of an abstract class is to provide common functionality while forcing subclasses to implement specific behavior.

---

## 2. Abstract Method

An **abstract method** is a method declared without a body.

### Syntax

```java
abstract returnType methodName(parameterList);
```

### Example

```java
abstract void draw();
```

An abstract method only defines the method contract. Its implementation must be provided by a subclass.

Abstract methods are sometimes called the **subclass's responsibility** because the parent class does not provide their implementation.

---

## 3. Abstract Class Example

```java
abstract class Shape {

    abstract void draw();

    void display() {
        System.out.println("This is a shape");
    }
}
```

Here:

- `draw()` is an abstract method.
- `display()` is a concrete method.

A subclass must implement the `draw()` method.

```java
class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}
```

Usage:

```java
Circle circle = new Circle();

circle.draw();
circle.display();
```

---

## 4. Rules of Abstract Classes

### Rule 1: An Abstract Class Cannot Be Instantiated

We cannot directly create an object of an abstract class.

```java
abstract class Shape {
    abstract void draw();
}
```

The following statement causes a compile-time error:

```java
Shape shape = new Shape();
```

However, we can create an object of its concrete subclass.

```java
Shape shape = new Circle();
```

---

### Rule 2: A Class Containing an Abstract Method Must Be Abstract

If a class contains at least one abstract method, the class must also be declared `abstract`.

```java
abstract class Shape {
    abstract void draw();
}
```

The following declaration is invalid:

```java
class Shape {
    abstract void draw(); // Compile-time error
}
```

---

### Rule 3: An Abstract Class May Have No Abstract Methods

It is valid to declare a class abstract even if it does not contain any abstract method.

```java
abstract class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}
```

This is useful when we want to prevent direct object creation and allow the class to be used only through inheritance.

---

### Rule 4: A Concrete Subclass Must Implement All Abstract Methods

A concrete subclass must implement all inherited abstract methods.

```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}
```

If the subclass does not implement all abstract methods, it must also be declared abstract.

```java
abstract class Circle extends Shape {
    // draw() is not implemented
}
```

---

### Rule 5: Abstract Methods Cannot Have a Body

An abstract method only contains a method declaration followed by a semicolon.

```java
abstract void draw();
```

The following declaration is invalid:

```java
abstract void draw() {
    System.out.println("Drawing");
}
```

If a method has a body, it is a concrete method and should not be declared abstract.

---

## 5. Abstract Class Constructor

An abstract class can have a constructor.

```java
abstract class Vehicle {

    String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }
}
```

Although an abstract class cannot be instantiated directly, its constructor runs when a subclass object is created.

```java
class Bus extends Vehicle {

    Bus(String brand) {
        super(brand);
    }
}
```

Usage:

```java
Bus bus = new Bus("Volvo");
```

When the `Bus` object is created:

1. The `Vehicle` constructor executes first.
2. The `Bus` constructor executes after it.

### Important Point

A constructor itself cannot be declared `abstract`.

The following declaration is invalid:

```java
abstract Vehicle();
```

A constructor initializes an object, while an abstract method represents behavior that must be implemented by subclasses.

### Constructor Access Modifier

An abstract class constructor is commonly declared `protected` because it is mainly used by subclasses.

```java
abstract class Vehicle {

    protected Vehicle() {
        System.out.println("Vehicle constructor");
    }
}
```

A `public` constructor is also allowed, but the abstract class still cannot be instantiated directly.

---

## 6. Static Methods in an Abstract Class

An abstract class can contain static methods.

```java
abstract class Vehicle {

    static void displayType() {
        System.out.println("This is a vehicle");
    }
}
```

A static method can be called using the class name.

```java
Vehicle.displayType();
```

However, a static method cannot be declared abstract.

The following declaration is invalid:

```java
abstract static void displayType();
```

### Reason

- An abstract method must be overridden by a subclass.
- A static method belongs to the class, not to an object.
- Static methods are hidden, not overridden using runtime polymorphism.

Therefore, `abstract` and `static` cannot be used together for a method.

---

## 7. Abstract Class Reference

An abstract class cannot be instantiated, but its reference can be created.

```java
Shape shape;
```

The reference can point to an object of a concrete subclass.

```java
Shape shape = new Circle();
```

This is called **upcasting**.

It supports runtime polymorphism.

```java
abstract class Shape {

    abstract void draw();
}

class Circle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle extends Shape {

    @Override
    void draw() {
        System.out.println("Drawing a rectangle");
    }
}
```

```java
Shape shape = new Circle();
shape.draw(); // Drawing a circle

shape = new Rectangle();
shape.draw(); // Drawing a rectangle
```

The overridden method executed at runtime depends on the actual object.

---

## 8. Concrete Methods in an Abstract Class

An abstract class can contain fully implemented methods.

```java
abstract class Employee {

    abstract double calculateSalary();

    void displayCompany() {
        System.out.println("Microsoft");
    }
}
```

Here:

- `calculateSalary()` must be implemented by subclasses.
- `displayCompany()` provides shared functionality to all subclasses.

This allows an abstract class to provide both:

- Abstraction through abstract methods
- Code reuse through concrete methods

---

# Abstract Class vs Interface

Both abstract classes and interfaces are used to achieve abstraction, but they serve different design purposes.

---

## 9. Methods

### Abstract Class

An abstract class can contain:

- Abstract methods
- Concrete methods
- Static methods
- Final methods
- Private methods

```java
abstract class Vehicle {

    abstract void start();

    void stop() {
        System.out.println("Vehicle stopped");
    }

    static void displayType() {
        System.out.println("Vehicle");
    }
}
```

### Interface

An interface can contain:

- Abstract methods
- Default methods
- Static methods
- Private methods
- Private static methods

```java
interface Vehicle {

    void start();

    default void stop() {
        System.out.println("Vehicle stopped");
    }

    static void displayType() {
        System.out.println("Vehicle");
    }
}
```

Interface methods without a body are implicitly:

```java
public abstract
```

For example:

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

---

## 10. Variables

### Abstract Class Variables

An abstract class can contain:

- Instance variables
- Static variables
- Final variables
- Non-final variables

```java
abstract class Vehicle {

    String brand;
    static int count;
    final int wheels = 4;
}
```

### Interface Variables

Variables declared inside an interface are implicitly:

```java
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

An interface cannot contain normal instance variables.

---

## 11. Constructors

### Abstract Class

An abstract class can have constructors.

```java
abstract class Vehicle {

    protected Vehicle() {
        System.out.println("Vehicle created");
    }
}
```

The constructor is executed when a subclass object is created.

### Interface

An interface cannot have constructors because interfaces cannot be instantiated and do not maintain object state.

---

## 12. Inheritance

An abstract class is inherited using the `extends` keyword.

```java
class Bus extends Vehicle {
}
```

An interface is implemented using the `implements` keyword.

```java
class Bus implements Transport {
}
```

---

## 13. Multiple Inheritance

A Java class can extend only one class.

```java
class Bus extends Vehicle {
}
```

The following is not allowed:

```java
class Bus extends Vehicle, Machine {
}
```

However, a class can implement multiple interfaces.

```java
class Bus implements Vehicle, Transport, GPS {
}
```

This allows multiple inheritance of type and behavior contracts.

---

## 14. Extending and Implementing

An interface can extend one or more interfaces.

```java
interface SmartVehicle extends Vehicle, GPS {
}
```

An interface cannot extend a class.

An abstract class can:

- Extend another class
- Implement one or more interfaces

```java
abstract class SmartVehicle
        extends Vehicle
        implements GPS, Transport {
}
```

---

## 15. Access Modifiers

### Abstract Class

An abstract class can have members with different access modifiers:

- `private`
- Default
- `protected`
- `public`

```java
abstract class Vehicle {

    private String id;
    protected String brand;
    public int speed;
}
```

### Interface

Interface fields are always:

```java
public static final
```

Interface abstract methods are always:

```java
public abstract
```

Therefore, a class implementing an interface method must declare it `public`.

```java
interface Vehicle {
    void start();
}

class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }
}
```

Using weaker access causes a compile-time error:

```java
class Bus implements Vehicle {

    @Override
    void start() { // Compile-time error
        System.out.println("Bus starts");
    }
}
```

---

## 16. State

An abstract class can maintain object state using instance variables.

```java
abstract class Vehicle {

    private String brand;

    Vehicle(String brand) {
        this.brand = brand;
    }

    String getBrand() {
        return brand;
    }
}
```

An interface cannot maintain per-object state because its fields are constants.

---

## 17. Abstract Class vs Interface Summary

### Use an Abstract Class When

- Subclasses are closely related.
- Multiple subclasses need shared code.
- Common object state must be maintained.
- Constructors are required.
- Protected or private members are required.
- Subclasses need a common base implementation.

### Use an Interface When

- Unrelated classes must follow the same contract.
- Multiple inheritance of type is required.
- The focus is on capability or behavior.
- Implementation details should remain separate.
- Different classes need to provide their own implementations.

---

## 18. Example: Abstract Class and Interface Together

```java
interface Flyable {

    void fly();
}
```

```java
abstract class Bird {

    private final String name;

    protected Bird(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    abstract void makeSound();

    void eat() {
        System.out.println(name + " is eating");
    }
}
```

```java
class Eagle extends Bird implements Flyable {

    Eagle(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println("Eagle makes a sound");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
    }
}
```

Usage:

```java
Bird bird = new Eagle("Golden Eagle");

bird.makeSound();
bird.eat();

Flyable flyable = (Flyable) bird;
flyable.fly();
```

In this example:

- `Bird` provides common state and implementation.
- `Flyable` defines a capability contract.
- `Eagle` extends the abstract class and implements the interface.

---

# SDE-2 Interview Points

## 19. Important Points

1. An abstract class cannot be instantiated directly.
2. An abstract class may or may not contain abstract methods.
3. A class containing an abstract method must be declared abstract.
4. A concrete subclass must implement all inherited abstract methods.
5. Otherwise, the subclass must also be declared abstract.
6. An abstract class can contain constructors.
7. An abstract class constructor executes during subclass object creation.
8. A constructor cannot be declared abstract.
9. An abstract class can contain static methods.
10. A static method cannot be abstract.
11. An abstract class reference can point to a concrete subclass object.
12. Abstract classes support code reuse and runtime polymorphism.
13. A class can extend only one abstract or concrete class.
14. A class can implement multiple interfaces.
15. Interface fields are implicitly `public static final`.
16. Interface abstract methods are implicitly `public abstract`.
17. An interface can have `default` and `static` methods.
18. Modern Java interfaces can also have private helper methods.
19. Static methods are hidden, not overridden.
20. Prefer an abstract class for shared state and implementation.
21. Prefer an interface for defining capabilities and contracts.

---

# Common Interview Questions

## Question 1: Can we create an object of an abstract class?

**Answer:** No. An abstract class cannot be instantiated directly.

```java
abstract class Shape {
}

Shape shape = new Shape(); // Compile-time error
```

However, its reference can point to a concrete subclass object.

```java
Shape shape = new Circle();
```

---

## Question 2: Can an abstract class have a constructor?

**Answer:** Yes.

Its constructor executes when a subclass object is created. It is used to initialize fields inherited by subclasses.

---

## Question 3: Can a constructor be abstract?

**Answer:** No.

A constructor initializes an object and is not inherited or overridden by subclasses.

---

## Question 4: Can an abstract class have no abstract methods?

**Answer:** Yes.

A class may be declared abstract only to prevent direct object creation or to provide a common base class.

```java
abstract class Vehicle {

    void start() {
        System.out.println("Vehicle starts");
    }
}
```

---

## Question 5: Can an abstract class contain static methods?

**Answer:** Yes.

```java
abstract class Vehicle {

    static void display() {
        System.out.println("Vehicle");
    }
}
```

---

## Question 6: Can a static method be abstract?

**Answer:** No.

Abstract methods require overriding, while static methods belong to the class and are hidden instead of overridden.

---

## Question 7: What happens if a subclass does not implement all abstract methods?

**Answer:** The subclass must also be declared abstract.

```java
abstract class Shape {
    abstract void draw();
}

abstract class Circle extends Shape {
}
```

---

## Question 8: Can an abstract class implement an interface?

**Answer:** Yes.

An abstract class does not need to implement every interface method immediately.

```java
interface Vehicle {
    void start();

    void stop();
}

abstract class Bus implements Vehicle {

    @Override
    public void start() {
        System.out.println("Bus starts");
    }
}
```

The concrete subclass must implement the remaining methods.

```java
class ElectricBus extends Bus {

    @Override
    public void stop() {
        System.out.println("Electric bus stops");
    }
}
```

---

## Question 9: What is the main difference between an abstract class and an interface?

**Answer:**

An abstract class represents a common base for closely related classes and can maintain state and provide shared implementation.

An interface defines a contract or capability that can be implemented by related or unrelated classes.

---

## Question 10: When should we prefer an interface over an abstract class?

**Answer:** Prefer an interface when:

- Multiple classes need to follow the same contract.
- The classes may be unrelated.
- Multiple inheritance of type is required.
- Shared object state is not required.

---

## Question 11: Can an interface extend multiple interfaces?

**Answer:** Yes.

```java
interface SmartVehicle extends Vehicle, GPS {
}
```

This provides multiple inheritance between interfaces.

---

## Question 12: Why are abstract class references useful?

**Answer:** They support runtime polymorphism.

```java
Shape shape = new Circle();
shape.draw();
```

The method implementation is selected according to the actual runtime object.