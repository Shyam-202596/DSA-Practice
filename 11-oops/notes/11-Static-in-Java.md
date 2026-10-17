# Static Keyword in Java

## 1. The `static` Keyword

The `static` keyword makes a member belong to the class rather than to individual objects.

It can be used with:

- Variables
- Methods
- Initialization blocks
- Nested classes

```java
class Employee {

    static String company = "Microsoft";
}
```

The static variable belongs to the `Employee` class and is shared by all its objects.

---

## 2. Static vs Instance Members

### Static Member

A static member belongs to the class.

```java
class Employee {

    static String company = "Microsoft";
}
```

It can be accessed using the class name:

```java
System.out.println(Employee.company);
```

### Instance Member

An instance member belongs to an object.

```java
class Employee {

    String name;
}
```

It requires an object:

```java
Employee employee = new Employee();
employee.name = "Ram";
```

### Key Difference

```text
Static member   → One shared member for the class
Instance member → Separate member for every object
```

---

# Static Variables

## 3. Static Variable

A static variable is also called a **class variable**.

Only one shared copy exists per loaded class, regardless of how many objects are created.

```java
class Employee {

    static String company = "Microsoft";

    String name;

    Employee(String name) {
        this.name = name;
    }
}
```

Usage:

```java
Employee first = new Employee("Ram");
Employee second = new Employee("Shyam");

System.out.println(Employee.company);
System.out.println(first.company);
System.out.println(second.company);
```

All references access the same static variable.

The preferred approach is:

```java
Employee.company
```

Accessing static members through an object is allowed but discouraged because it reduces readability.

---

## 4. Shared Static Variable

```java
class Counter {

    static int count;

    Counter() {
        count++;
    }
}
```

```java
new Counter();
new Counter();
new Counter();

System.out.println(Counter.count);
```

Output:

```text
3
```

The `count` variable is shared by all `Counter` objects.

---

## 5. Static Constant

Constants are commonly declared using:

```java
static final
```

```java
class Configuration {

    static final int MAX_RETRY_COUNT = 3;
}
```

Usage:

```java
System.out.println(
        Configuration.MAX_RETRY_COUNT
);
```

Static constants conventionally use uppercase names with underscores.

---

# Static Methods

## 6. Static Method

A static method belongs to the class rather than to an object.

```java
class Calculator {

    static int add(int first, int second) {
        return first + second;
    }
}
```

It can be called using the class name:

```java
int result = Calculator.add(10, 20);
```

No `Calculator` object is required.

---

## 7. Accessing Static Members

A static method can directly access static members.

```java
class Example {

    static int value = 10;

    static void display() {
        System.out.println(value);
    }
}
```

Usage:

```java
Example.display();
```

A class name is optional inside the same class:

```java
static void display() {
    System.out.println(Example.value);
}
```

---

## 8. Accessing Instance Members from a Static Method

A static method cannot directly access an instance member.

```java
class Human {

    String message = "Hello World";

    static void display() {
        System.out.println(message);
        // Compile-time error
    }
}
```

The static method does not know which `Human` object should provide the value.

An object reference must be supplied explicitly:

```java
class Human {

    String message = "Hello World";

    static void display(Human human) {
        System.out.println(human.message);
    }

    public static void main(String[] args) {
        Human kunal = new Human();
        kunal.message = "Kunal's message";

        Human.display(kunal);
    }
}
```

Output:

```text
Kunal's message
```

### Important Rule

> A static method can access an instance member through an explicit object reference.

---

## 9. Calling Instance Methods from a Static Method

A static method cannot directly call an instance method.

```java
class Example {

    void instanceMethod() {
        System.out.println("Instance method");
    }

    static void staticMethod() {
        instanceMethod(); // Compile-time error
    }
}
```

It can be called through an object:

```java
static void staticMethod() {
    Example example = new Example();
    example.instanceMethod();
}
```

---

## 10. Instance Methods and Static Members

An instance method can directly access both:

- Static members
- Instance members

```java
class Employee {

    static String company = "Microsoft";

    String name = "Ram";

    void display() {
        System.out.println(name);
        System.out.println(company);
    }
}
```

An instance method has access to the current object through `this`.

---

## 11. `this` and `super` in Static Methods

A static method cannot use `this` or `super`.

```java
class Parent {
}

class Child extends Parent {

    static void display() {
        System.out.println(this);
        System.out.println(super.toString());
        // Compile-time error
    }
}
```

Reason:

- `this` refers to the current object.
- `super` refers to the superclass part of the current object.
- A static method does not execute for a specific object.

---

# The `main()` Method

## 12. Why Is `main()` Static?

The standard Java entry-point method is:

```java
public static void main(String[] args) {
}
```

It is static so that the JVM can invoke it without creating an object of the application class.

```java
public class Application {

    public static void main(String[] args) {
        System.out.println("Application started");
    }
}
```

The JVM invokes `main()` through the class.

---

# Static Initialization Blocks

## 13. Static Block

A static initialization block is used to initialize static data that requires multiple statements or calculations.

```java
class UseStatic {

    static int first = 3;
    static int second;

    static {
        System.out.println(
                "Static block initialized"
        );

        second = first * 4;
    }
}
```

A static block executes once when the class is initialized.

---

## 14. Complete Static Example

```java
class UseStatic {

    static int first = 3;
    static int second;

    static {
        System.out.println(
                "Static block initialized"
        );

        second = first * 4;
    }

    static void display(int value) {
        System.out.println("value = " + value);
        System.out.println("first = " + first);
        System.out.println("second = " + second);
    }

    public static void main(String[] args) {
        display(42);
    }
}
```

Output:

```text
Static block initialized
value = 42
first = 3
second = 12
```

---

## 15. Static Initialization Order

Static fields and static blocks execute in textual order.

```java
class Example {

    static int first = initializeFirst();

    static {
        System.out.println("Static block");
    }

    static int second = initializeSecond();

    static int initializeFirst() {
        System.out.println("First field");
        return 10;
    }

    static int initializeSecond() {
        System.out.println("Second field");
        return 20;
    }
}
```

Initialization order:

```text
First field
Static block
Second field
```

Order matters because static initializers may depend on previously initialized fields.

---

## 16. When Is a Class Initialized?

A class is generally initialized on its first active use, such as:

- Creating an object of the class
- Calling a static method
- Accessing a non-constant static field
- Using reflection that triggers initialization

Example:

```java
Example.display();
```

This may trigger initialization of `Example` before `display()` executes.

> Loading and initialization are related but different JVM phases. A static block executes during class initialization.

---

## 17. Multiple Static Blocks

A class can contain multiple static blocks.

```java
class Example {

    static {
        System.out.println("First block");
    }

    static {
        System.out.println("Second block");
    }
}
```

They execute once in textual order:

```text
First block
Second block
```

---

# Static Methods and Inheritance

## 18. Static Method Hiding

Static methods are hidden, not overridden.

```java
class Parent {

    static void display() {
        System.out.println("Parent");
    }
}
```

```java
class Child extends Parent {

    static void display() {
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
Parent
```

The method is selected using the compile-time reference type.

---

## 19. Why Static Methods Are Not Overridden

Method overriding uses runtime object type.

Static methods belong to the class and are resolved using the compile-time type.

```java
Parent reference = new Child();
reference.display();
```

Because the reference type is `Parent`, `Parent.display()` executes.

Prefer calling static methods using the class name:

```java
Parent.display();
Child.display();
```

> Runtime polymorphism does not apply to static methods.

---

## 20. Static Method Hiding Rules

A child static method can hide an inherited static method with the same signature.

```java
class Parent {

    public static void display() {
    }
}
```

```java
class Child extends Parent {

    public static void display() {
    }
}
```

An instance method cannot override a static method:

```java
class Child extends Parent {

    void display() {
        // Compile-time error
    }
}
```

Similarly, a static method cannot hide an inherited instance method.

---

# Static Interface Methods

## 21. Static Methods in Interfaces

An interface can have static methods with a body.

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

Static interface methods are not inherited by:

- Implementing classes
- Child interfaces

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

# Static Nested Classes

## 22. Static Nested Class

A class declared static inside another class is called a **static nested class**.

```java
class Outer {

    static class Nested {
    }
}
```

Only a nested class can be explicitly declared static.

A top-level class cannot be declared static.

Invalid:

```java
static class Employee {
    // Compile-time error
}
```

---

## 23. Creating a Static Nested Class Object

A static nested class does not require an object of the outer class.

```java
class Outer {

    static class Nested {

        void display() {
            System.out.println(
                    "Static nested class"
            );
        }
    }
}
```

Usage:

```java
Outer.Nested nested =
        new Outer.Nested();

nested.display();
```

No `Outer` object is required.

---

## 24. Static Nested Class Example

```java
public class Outer {

    static class Test {

        private final String name;

        Test(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Test first = new Test("Kunal");
        Test second = new Test("Rahul");

        System.out.println(first.name);
        System.out.println(second.name);
    }
}
```

Output:

```text
Kunal
Rahul
```

A static nested class can have multiple objects.

The word `static` does not make the nested class a singleton.

---

## 25. Accessing Outer-Class Members

A static nested class can directly access static members of its outer class.

```java
class Outer {

    private static int staticValue = 10;

    static class Nested {

        void display() {
            System.out.println(staticValue);
        }
    }
}
```

It cannot directly access instance members of the outer class.

```java
class Outer {

    private int instanceValue = 20;

    static class Nested {

        void display() {
            System.out.println(instanceValue);
            // Compile-time error
        }
    }
}
```

An explicit outer-class object is required:

```java
class Outer {

    private int instanceValue = 20;

    static class Nested {

        void display(Outer outer) {
            System.out.println(
                    outer.instanceValue
            );
        }
    }
}
```

---

## 26. Static Nested Class vs Inner Class

### Static Nested Class

- Declared using `static`
- Does not require an outer-class object
- Has no implicit reference to an outer object
- Cannot directly access outer instance members

```java
Outer.Nested nested =
        new Outer.Nested();
```

### Inner Class

- Does not use `static`
- Requires an outer-class object
- Has an implicit reference to its outer object
- Can directly access outer instance members

```java
Outer outer = new Outer();

Outer.Inner inner =
        outer.new Inner();
```

A static nested class is technically not an inner class. Non-static nested classes are called inner classes. 【1-e845b6】

---

# Static Import

## 27. Static Import

Static import allows static members to be used without the class name.

```java
import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
```

Usage:

```java
double result = sqrt(25);
double circumference = 2 * PI * 10;
```

Without static import:

```java
double result = Math.sqrt(25);
```

Use static imports carefully because excessive use can reduce readability.

---

# Common Uses of Static

## 28. Utility Methods

Utility methods usually do not depend on object state.

```java
final class NumberUtils {

    private NumberUtils() {
    }

    static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
```

Usage:

```java
boolean result =
        NumberUtils.isEven(10);
```

---

## 29. Factory Methods

Static methods can create and return objects.

```java
class Employee {

    private final String name;

    private Employee(String name) {
        this.name = name;
    }

    static Employee of(String name) {
        return new Employee(name);
    }
}
```

Usage:

```java
Employee employee =
        Employee.of("Ram");
```

---

## 30. Shared Counters

```java
class Employee {

    private static int nextId = 1;

    private final int id;

    Employee() {
        id = nextId++;
    }

    int getId() {
        return id;
    }
}
```

Each object receives a different ID, while `nextId` remains shared.

---

# Important Considerations

## 31. Static Mutable State

Mutable static variables are shared across all objects and threads.

```java
class Counter {

    static int count;
}
```

This can create:

- Unexpected shared-state changes
- Thread-safety problems
- Difficult unit testing
- Hidden dependencies

Avoid unnecessary global mutable state.

Prefer constants:

```java
static final int MAX_RETRY_COUNT = 3;
```

---

## 32. Static Members and Memory

Static members belong to the class representation managed by the JVM.

It is not fully accurate to simply say that static members are always stored in one specific memory section, because JVM implementation details can vary.

The important program-level rule is:

> Static state is associated with the class and shared by its objects.

---

# Summary

- A static member belongs to the class.
- An instance member belongs to an object.
- One static field is shared by all objects of that loaded class.
- Static members should be accessed using the class name.
- A static method can directly access only static members.
- Instance members can be accessed from static methods through an explicit object.
- Static methods cannot use `this` or `super`.
- The `main()` method is static so the JVM can invoke it without an application object.
- Static blocks execute once during class initialization.
- Static fields and blocks execute in textual order.
- Static methods are hidden, not overridden.
- Runtime polymorphism does not apply to static methods.
- Static interface methods are not inherited.
- Only nested classes can be explicitly static.
- A static nested class does not need an outer-class object.
- A static nested class can have multiple objects.
- A static nested class cannot directly access outer instance members.
- Avoid unnecessary mutable static state.

---

# Important Interview Questions

## 1. What does `static` mean in Java?

A static member belongs to the class rather than to an individual object.

---

## 2. What is the difference between static and instance variables?

A static variable has one shared value associated with the class.

An instance variable has a separate value for each object.

---

## 3. Can a static method access an instance variable?

Not directly.

It must use an explicit object reference.

```java
static void display(Employee employee) {
    System.out.println(employee.name);
}
```

---

## 4. Can an instance method access static members?

Yes.

An instance method can access both static and instance members.

---

## 5. Why cannot a static method use `this`?

`this` represents the current object.

A static method belongs to the class and may run without any current object.

---

## 6. Why cannot a static method use `super`?

`super` refers to the superclass part of the current object.

A static method has no current object.

---

## 7. Why is `main()` static?

It allows the JVM to invoke the application entry point without first creating an object of the class.

---

## 8. When does a static block execute?

It executes once when the class is initialized by the JVM.

---

## 9. Can a class have multiple static blocks?

Yes.

They execute once in textual order during class initialization.

---

## 10. Are static methods overridden?

No.

Static methods are hidden and selected using the compile-time reference type.

---

## 11. What is static method hiding?

It occurs when a subclass declares a static method with the same signature as an inherited static method.

```java
class Parent {

    static void display() {
    }
}

class Child extends Parent {

    static void display() {
    }
}
```

---

## 12. Does runtime polymorphism apply to static methods?

No.

Runtime polymorphism applies to overridden instance methods.

---

## 13. Can a top-level class be static?

No.

Only a nested class can be explicitly declared static.

---

## 14. What is a static nested class?

It is a class declared static inside another class.

It does not require an instance of the enclosing class.

```java
Outer.Nested nested =
        new Outer.Nested();
```

---

## 15. Is a static nested class a singleton?

No.

Multiple objects of a static nested class can be created.

```java
Outer.Nested first =
        new Outer.Nested();

Outer.Nested second =
        new Outer.Nested();
```

---

## 16. Can a static nested class access outer instance members?

Not directly.

It requires an explicit outer-class object.

---

## 17. What is the difference between a static nested class and an inner class?

A static nested class does not require an outer-class object.

An inner class is associated with an outer-class object and can directly access its instance members.

---

## 18. Are static interface methods inherited?

No.

They must be called using the interface name.

```java
Vehicle.displayType();
```

---

## 19. Can static methods be overloaded?

Yes.

```java
static void display(int value) {
}

static void display(String value) {
}
```

Overloading is resolved at compile time.

---

## 20. Can a static method be abstract?

No.

An abstract method requires overriding, while a static method belongs to the class and does not participate in runtime overriding.

---

## 21. Can a static method be final?

Yes.

```java
static final void display() {
}
```

However, static methods are hidden rather than overridden. `final` prevents the child class from declaring a same-signature static method.

---

## 22. Why should mutable static variables be used carefully?

They create shared global state, which can cause:

- Thread-safety issues
- Unexpected changes
- Difficult testing
- Tight coupling

---

## 23. Does accessing a compile-time constant initialize the class?

Not necessarily.

A `static final` primitive or `String` compile-time constant may be inlined by the compiler, so accessing it may not trigger initialization of the declaring class.

---

## 24. What is the best way to access a static member?

Use the class name:

```java
Employee.company
Calculator.add(10, 20)
```

Avoid accessing static members through object references.