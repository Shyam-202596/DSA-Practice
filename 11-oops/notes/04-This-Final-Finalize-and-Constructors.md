# `this`, `final`, `finalize()` and Constructors in Java

## 1. The `this` Keyword

The `this` keyword refers to the **current object**.

It represents the object on which the current instance method or constructor was invoked.

```java
class Employee {

    void displayCurrentObject() {
        System.out.println(this);
    }
}
```

Usage:

```java
Employee employee = new Employee();

employee.displayCurrentObject();
System.out.println(employee);
```

Both statements print a representation of the same object.

> `this` is available only in an instance context. It cannot be used directly inside a static method.

---

## 2. Using `this` to Resolve Variable Shadowing

Variable shadowing occurs when a method parameter or local variable has the same name as an instance variable.

```java
class Employee {

    private int id;

    Employee(int id) {
        id = id;
    }
}
```

The above assignment does not update the instance variable.

Both occurrences of `id` refer to the constructor parameter.

Use `this` to refer to the instance variable:

```java
class Employee {

    private int id;

    Employee(int id) {
        this.id = id;
    }
}
```

Here:

- `this.id` refers to the instance variable.
- `id` refers to the constructor parameter.

---

## 3. Calling an Instance Method Using `this`

The `this` keyword can be used to call another instance method of the same object.

```java
class Employee {

    void displayName() {
        System.out.println("Ram");
    }

    void displayDetails() {
        this.displayName();
    }
}
```

Using `this` is optional in this case.

```java
void displayDetails() {
    displayName();
}
```

Both calls have the same result.

---

## 4. Calling Another Constructor Using `this()`

The `this()` constructor call is used to invoke another constructor of the same class.

```java
class Employee {

    private int id;
    private String name;

    Employee() {
        this(0, "Unknown");
    }

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

This process is called **constructor chaining within the same class**.

### Important Rules

- `this()` must be the first statement in a constructor.
- It can be used only inside a constructor.
- It calls another constructor of the same class.
- Recursive constructor calls are not allowed.

The following code is invalid:

```java
class Employee {

    Employee() {
        System.out.println("Creating employee");
        this(0); // Compile-time error
    }

    Employee(int id) {
    }
}
```

`this()` is not the first statement.

---

## 5. Passing `this` as an Argument

The current object can be passed to another method using `this`.

```java
class Printer {

    void print(Employee employee) {
        System.out.println(employee);
    }
}
```

```java
class Employee {

    void printCurrentObject(Printer printer) {
        printer.print(this);
    }
}
```

This is useful when another object needs access to the current object.

---

## 6. Returning `this`

An instance method can return the current object.

```java
class Employee {

    private String name;

    Employee setName(String name) {
        this.name = name;
        return this;
    }

    void display() {
        System.out.println(name);
    }
}
```

Usage:

```java
Employee employee = new Employee()
        .setName("Ram");

employee.display();
```

Returning `this` is commonly used in:

- Method chaining
- Fluent APIs
- Builder patterns

---

## 7. `this` Cannot Be Used in a Static Context

A static method belongs to the class, not to a specific object.

Therefore, `this` cannot be used inside a static method.

```java
class Employee {

    static void display() {
        System.out.println(this); // Compile-time error
    }
}
```

There may be no current object when a static method is executed.

---

# The `final` Keyword

## 8. Uses of `final`

The `final` keyword can be applied to:

1. Variables
2. Methods
3. Classes
4. Parameters
5. Local variables

Its meaning depends on where it is used.

---

## 9. Final Variable

A final variable can be assigned only once.

```java
final int maximumAttempts = 3;
```

Reassignment is not allowed:

```java
maximumAttempts = 5; // Compile-time error
```

A final variable must be initialized exactly once before it is used.

---

## 10. Initializing Final Fields

A final instance field can be initialized:

### At Declaration

```java
class FileManager {

    final int fileOpen = 2;
}
```

### Inside an Instance Initializer Block

```java
class FileManager {

    final int fileOpen;

    {
        fileOpen = 2;
    }
}
```

### Inside Every Constructor

```java
class FileManager {

    final int fileOpen;

    FileManager() {
        fileOpen = 2;
    }

    FileManager(int status) {
        fileOpen = status;
    }
}
```

Every constructor must ensure that the blank final field is initialized.

The following code does not compile:

```java
class FileManager {

    final int fileOpen;

    FileManager() {
        // fileOpen is not initialized
    }
}
```

---

## 11. Final Local Variable

A local variable can also be final.

```java
void display() {
    final int value;

    value = 10;

    System.out.println(value);
}
```

It can be assigned later, but only once.

```java
value = 20; // Compile-time error
```

A final variable that is declared without an initial value is called a **blank final variable**.

---

## 12. Constant Naming Convention

Constants are usually declared using:

```java
static final
```

Their names are written in uppercase with words separated by underscores.

```java
class FileManager {

    static final int FILE_OPEN = 2;
    static final int FILE_CLOSED = 0;
}
```

`final` alone prevents reassignment for a particular field.

`static final` creates one shared constant associated with the class.

Usage:

```java
System.out.println(FileManager.FILE_OPEN);
```

---

## 13. Final Primitive Variable

When a primitive variable is final, its value cannot be changed after initialization.

```java
final int count = 10;

count = 20; // Compile-time error
```

This provides value-level immutability for that variable.

---

## 14. Final Reference Variable

When a reference variable is final, the reference cannot point to another object.

```java
final StringBuilder builder = new StringBuilder("Java");
```

Reassignment is not allowed:

```java
builder = new StringBuilder("Spring"); // Compile-time error
```

However, the referenced object's internal state can still change:

```java
builder.append(" OOP");

System.out.println(builder); // Java OOP
```

### Important Rule

> `final` makes the reference fixed, not necessarily the referenced object immutable.

```text
final reference ───> mutable object
       fixed           can change
```

---

## 15. Final Reference vs Immutable Object

A final reference and an immutable object are different concepts.

### Final Reference to a Mutable Object

```java
final List<String> names = new ArrayList<>();

names.add("Ram");
names.add("Shyam");
```

The list can still be modified.

Only reassignment is prevented:

```java
names = new ArrayList<>(); // Compile-time error
```

### Final Reference to an Immutable Object

```java
final String name = "Java";
```

A `String` object is immutable, so its internal value cannot change.

An operation creates a new object:

```java
name.concat(" OOP");
```

The final reference cannot be reassigned to the newly created object:

```java
name = name.concat(" OOP"); // Compile-time error
```

For strong immutability, both are important:

- The reference should not be reassigned.
- The referenced object should be immutable or safely encapsulated.

---

## 16. Final Method

A final method cannot be overridden by a subclass.

```java
class Parent {

    final void display() {
        System.out.println("Parent display");
    }
}
```

The following subclass is invalid:

```java
class Child extends Parent {

    @Override
    void display() { // Compile-time error
        System.out.println("Child display");
    }
}
```

A final method may still be inherited and called by the subclass.

```java
Child child = new Child();
child.display();
```

---

## 17. Final Class

A final class cannot be extended.

```java
final class Utility {
}
```

The following declaration is invalid:

```java
class AdvancedUtility extends Utility {
    // Compile-time error
}
```

A final class is useful when:

- Inheritance must be prevented.
- Class behavior must not be modified through overriding.
- An immutable class is being designed.
- Security or design invariants must be protected.

Example:

```java
public final class EmployeeId {

    private final int value;

    public EmployeeId(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
```

---

## 18. Final Parameter

A method parameter can be declared final.

```java
void display(final int value) {
    System.out.println(value);
}
```

The parameter cannot be reassigned inside the method:

```java
void display(final int value) {
    value = 20; // Compile-time error
}
```

For a final reference parameter, the object's state may still be mutable.

```java
void addName(final List<String> names) {
    names.add("Ram"); // Allowed
}
```

But the parameter cannot refer to another list:

```java
void addName(final List<String> names) {
    names = new ArrayList<>(); // Compile-time error
}
```

---

# The `finalize()` Method

## 19. What Was `finalize()`?

Historically, `finalize()` was a method inherited from the `Object` class.

It was intended to allow an object to perform cleanup before its memory was reclaimed by the garbage collector.

```java
@Override
protected void finalize() throws Throwable {
    try {
        System.out.println("Cleaning resources");
    } finally {
        super.finalize();
    }
}
```

However, `finalize()` should not be used in modern Java applications.

---

## 20. Why `finalize()` Should Not Be Used

The execution of `finalize()` is unpredictable.

There is no guarantee:

- When it will execute
- Whether it will execute before program termination
- Whether resource cleanup will happen on time

Finalization also introduces:

- Performance problems
- Security risks
- Object resurrection issues
- Unpredictable resource retention
- Difficult-to-debug behavior

> `finalize()` was deprecated in Java 9 and deprecated for removal in Java 18.

Do not depend on garbage collection for closing files, streams, database connections, sockets, or other external resources.

---

## 21. Use Try-With-Resources Instead

Resources implementing `AutoCloseable` should be managed using try-with-resources.

```java
try (BufferedReader reader =
         new BufferedReader(new FileReader("data.txt"))) {

    System.out.println(reader.readLine());

} catch (IOException exception) {
    exception.printStackTrace();
}
```

The resource is closed automatically when the block finishes, including when an exception occurs.

For application code, prefer:

- `AutoCloseable`
- Try-with-resources
- Explicit `close()` methods

`Cleaner` may be considered only for specialized low-level cleanup needs. It should not replace deterministic resource management.

---

## 22. `final`, `finally`, and `finalize()`

These three terms are completely different.

### `final`

A keyword used with variables, methods, and classes.

```java
final int value = 10;
```

### `finally`

A block used in exception handling.

```java
try {
    System.out.println("Try block");
} finally {
    System.out.println("Cleanup block");
}
```

### `finalize()`

A deprecated method historically associated with garbage collection.

```java
protected void finalize() throws Throwable {
}
```

It should not be used in modern Java code.

---

# Constructors in Java

## 23. Constructor

A constructor is a special member of a class used to initialize an object.

```java
class Box {

    Box() {
        System.out.println("Box object created");
    }
}
```

The constructor is invoked during object creation:

```java
Box box = new Box();
```

In this statement:

- `Box` on the left is the reference type.
- `box` is the reference variable.
- `new` allocates memory for the object.
- `Box()` invokes the constructor.

---

## 24. Constructor Characteristics

A constructor:

- Has the same name as its class.
- Does not have any return type.
- Does not use even `void`.
- Runs during object creation.
- Initializes the state of an object.
- Can be overloaded.
- Is not inherited.
- Cannot be overridden.
- Can use access modifiers.
- Cannot be `abstract`, `static`, `final`, or `synchronized`.

### Important Correction

A constructor does not have an implicit return type.

It has **no return type at all**.

The following is a method, not a constructor:

```java
class Box {

    void Box() {
        System.out.println("This is a method");
    }
}
```

Because `void` is present, `Box()` is treated as a normal method.

---

## 25. No-Argument Constructor

A constructor that accepts no argument is called a no-argument constructor.

```java
class Box {

    Box() {
        System.out.println("No-argument constructor");
    }
}
```

Usage:

```java
Box box = new Box();
```

A no-argument constructor may be:

- Written explicitly by the developer
- Supplied by the compiler as a default constructor

---

## 26. Default Constructor

If a class declares no constructor, the compiler provides a default constructor.

```java
class Box {
}
```

Conceptually, the compiler provides something similar to:

```java
class Box {

    Box() {
        super();
    }
}
```

### Important Rule

The compiler provides a default constructor only when the class declares no constructor at all.

If any constructor is declared, the compiler does not add a default constructor.

```java
class Box {

    Box(int length) {
    }
}
```

The following statement now fails:

```java
Box box = new Box(); // Compile-time error
```

To support it, a no-argument constructor must be written explicitly:

```java
class Box {

    Box() {
    }

    Box(int length) {
    }
}
```

---

## 27. Parameterized Constructor

A constructor that accepts arguments is called a parameterized constructor.

```java
class Box {

    private final int length;
    private final int width;

    Box(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
```

Usage:

```java
Box box = new Box(10, 20);
```

Parameterized constructors allow objects to be initialized with different states.

---

## 28. Constructor Overloading

A class can have multiple constructors with different parameter lists.

```java
class Box {

    private int length;
    private int width;

    Box() {
        this(0, 0);
    }

    Box(int length) {
        this(length, length);
    }

    Box(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
```

Usage:

```java
Box first = new Box();
Box second = new Box(10);
Box third = new Box(10, 20);
```

This is called constructor overloading.

---

# Inheritance and Constructors

## 29. Constructor Execution Order

When a child-class object is created, the parent-class constructor runs before the child-class constructor.

```java
class Base {

    Base() {
        System.out.println("Base Class Constructor Called");
    }
}
```

```java
class Derived extends Base {

    Derived() {
        System.out.println("Derived Class Constructor Called");
    }
}
```

```java
public class Main {

    public static void main(String[] args) {
        Derived derived = new Derived();
    }
}
```

Output:

```text
Base Class Constructor Called
Derived Class Constructor Called
```

The constructor execution order is:

```text
Object → Base → Derived
```

Parent state must be initialized before child-specific initialization begins.

---

## 30. Implicit `super()` Call

If the first statement of a constructor is not `this()` or `super()`, the compiler inserts an implicit call to:

```java
super();
```

Example:

```java
class Derived extends Base {

    Derived() {
        System.out.println("Derived constructor");
    }
}
```

It behaves like:

```java
class Derived extends Base {

    Derived() {
        super();
        System.out.println("Derived constructor");
    }
}
```

The implicit `super()` calls the no-argument constructor of the direct parent class.

> The compiler inserts this call. It should not be described as the JVM choosing and adding the constructor call.

---

## 31. Parameterized Child Constructor Still Calls `super()`

A parameterized child constructor also receives an implicit `super()` call when no explicit constructor call is provided.

```java
class Derived extends Base {

    Derived(int value) {
        System.out.println(value);
    }
}
```

It behaves like:

```java
class Derived extends Base {

    Derived(int value) {
        super();
        System.out.println(value);
    }
}
```

This requires the parent class to have an accessible no-argument constructor.

---

## 32. Parent Without a No-Argument Constructor

Consider a parent class that has only a parameterized constructor:

```java
class Base {

    Base(int value) {
        System.out.println("Base value: " + value);
    }
}
```

The following child class does not compile:

```java
class Derived extends Base {

    Derived() {
        // Compiler attempts to insert super()
    }
}
```

It fails because `Base` does not have a no-argument constructor.

The child constructor must explicitly call the available parent constructor:

```java
class Derived extends Base {

    Derived() {
        super(10);

        System.out.println("Derived constructor");
    }
}
```

---

## 33. Rules of `super()`

The `super()` constructor call:

- Invokes a constructor of the direct parent class.
- Must be the first statement in the child constructor.
- Can be used only inside a constructor.
- May pass arguments to a parent constructor.

```java
class Employee {

    private final String name;

    Employee(String name) {
        this.name = name;
    }
}
```

```java
class Developer extends Employee {

    private final String technology;

    Developer(String name, String technology) {
        super(name);
        this.technology = technology;
    }
}
```

The following is invalid:

```java
Developer(String name, String technology) {
    this.technology = technology;
    super(name); // Compile-time error
}
```

---

## 34. `this()` vs `super()`

### `this()`

Calls another constructor of the same class.

```java
Box() {
    this(0);
}
```

### `super()`

Calls a constructor of the direct parent class.

```java
Derived() {
    super();
}
```

Both must be the first statement of a constructor.

Therefore, a constructor