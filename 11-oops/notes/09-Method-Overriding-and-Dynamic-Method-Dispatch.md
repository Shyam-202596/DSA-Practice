# Method Overriding and Dynamic Method Dispatch

# Method Overriding

## 1. Method Overriding

Method overriding occurs when a subclass provides a new implementation of an inherited instance method.

The overriding method must have:

- The same method name
- The same parameter list
- A compatible return type

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

Usage:

```java
Bus bus = new Bus();
bus.start();
```

Output:

```text
Bus starts
```

The `Bus` implementation overrides the `Vehicle` implementation.

---

## 2. The `@Override` Annotation

Use `@Override` when overriding a method.

```java
class Bus extends Vehicle {

    @Override
    void start() {
        System.out.println("Bus starts");
    }
}
```

It helps the compiler detect mistakes.

```java
class Bus extends Vehicle {

    @Override
    void starts() {
        // Compile-time error
    }
}
```

Here, `starts()` does not override `start()`.

> Always use `@Override` when overriding a method.

---

## 3. Overriding Rules

For valid method overriding:

- Inheritance must exist.
- The method name must be the same.
- The parameter list must be the same.
- The return type must be the same or covariant.
- The overriding method cannot reduce visibility.
- The overriding method must follow exception-handling rules.
- The method must be inherited and overridable.

---

## 4. Overriding vs Overloading

If the method name and parameters are the same, it is overriding.

```java
class Parent {

    void display(int value) {
    }
}

class Child extends Parent {

    @Override
    void display(int value) {
    }
}
```

If the parameter list is different, it is overloading.

```java
class Child extends Parent {

    void display(String value) {
    }
}
```

### Difference

#### Overriding

- Requires inheritance
- Same method signature
- Runtime polymorphism
- Runtime object decides the implementation

#### Overloading

- Inheritance is not required
- Different parameter lists
- Compile-time polymorphism
- Compiler decides the method

---

## 5. Access Modifier Rules

An overriding method cannot reduce the visibility of the inherited method.

### Valid

```java
class Parent {

    protected void display() {
    }
}

class Child extends Parent {

    @Override
    public void display() {
    }
}
```

Visibility is increased from `protected` to `public`.

### Invalid

```java
class Parent {

    public void display() {
    }
}

class Child extends Parent {

    @Override
    protected void display() {
        // Compile-time error
    }
}
```

Visibility order:

```text
private < default < protected < public
```

An overriding method can keep or increase visibility, but it cannot reduce it.

---

## 6. Private Methods

Private methods cannot be overridden because they are not accessible to subclasses.

```java
class Parent {

    private void display() {
        System.out.println("Parent");
    }
}
```

```java
class Child extends Parent {

    void display() {
        System.out.println("Child");
    }
}
```

`Child.display()` is a new method. It does not override `Parent.display()`.

---

## 7. Final Methods

A final method cannot be overridden.

```java
class Parent {

    final void display() {
        System.out.println("Parent");
    }
}
```

The following code is invalid:

```java
class Child extends Parent {

    @Override
    void display() {
        // Compile-time error
    }
}
```

A final method can still be inherited and called by the child class.

---

## 8. Static Methods

Static methods are hidden, not overridden.

```java
class Parent {

    static void display() {
        System.out.println("Parent");
    }
}

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

Static method selection depends on the compile-time reference type.

> Runtime polymorphism does not apply to static methods.

---

# Dynamic Method Dispatch

## 9. Dynamic Method Dispatch

Dynamic method dispatch is the mechanism through which an overridden instance method call is resolved at runtime.

It is the foundation of **runtime polymorphism** in Java.

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
vehicle.start();
```

Output:

```text
Bus starts
```

Although the reference type is `Vehicle`, the actual object is `Bus`.

Therefore, `Bus.start()` executes.

---

## 10. Reference Type vs Object Type

Consider:

```java
Vehicle vehicle = new Bus();
```

Here:

- `Vehicle` is the compile-time reference type.
- `Bus` is the runtime object type.

### Reference Type Decides

The reference type decides:

- Which methods are accessible at compile time
- Which fields are accessible
- Which static methods are selected

### Object Type Decides

The runtime object type decides:

- Which overridden instance method executes

---

## 11. Dynamic Dispatch Example

```java
class Animal {

    void makeSound() {
        System.out.println("Animal sound");
    }
}

class Dog extends Animal {

    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {

    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}
```

```java
Animal animal;

animal = new Dog();
animal.makeSound();

animal = new Cat();
animal.makeSound();
```

Output:

```text
Dog barks
Cat meows
```

The same reference type invokes different implementations based on the runtime object.

---

## 12. Why Runtime Polymorphism Is Useful

Runtime polymorphism allows code to depend on a common parent type instead of concrete implementations.

```java
class AnimalService {

    void playSound(Animal animal) {
        animal.makeSound();
    }
}
```

Usage:

```java
AnimalService service =
        new AnimalService();

service.playSound(new Dog());
service.playSound(new Cat());
```

The service does not need separate methods for every animal type.

This improves:

- Extensibility
- Loose coupling
- Maintainability
- Substitutability

---

## 13. Calling the Superclass Version

A subclass can call the overridden superclass method using `super`.

```java
class Child extends Parent {

    @Override
    void display() {
        super.display();
        System.out.println("Child display");
    }
}
```

`super.display()` calls the immediate superclass implementation.

Dynamic dispatch does not apply to an explicit `super` call.

---

# Covariant Return Type

## 14. Covariant Return Type

An overriding method can return a subtype of the return type declared by the superclass method.

This is called a **covariant return type**.

```java
class Animal {
}
```

```java
class Dog extends Animal {
}
```

```java
class Parent {

    Animal createAnimal() {
        return new Animal();
    }
}
```

```java
class Child extends Parent {

    @Override
    Dog createAnimal() {
        return new Dog();
    }
}
```

`Dog` is a subtype of `Animal`, so this is valid.

---

## 15. Covariant Return Rules

Covariant returns apply to reference types.

```java
class A {

    A getObject() {
        return new A();
    }
}

class B extends A {

    @Override
    B getObject() {
        return new B();
    }
}
```

Here, `B` is a subtype of `A`.

### Primitive Return Types

Primitive return types must match exactly.

```java
class Parent {

    int getValue() {
        return 10;
    }
}
```

The following override is invalid:

```java
class Child extends Parent {

    @Override
    long getValue() {
        return 10;
    }
}
```

`long` is not a covariant return type of `int`.

---

## 16. Benefit of Covariant Return Type

Covariant return types reduce explicit type casting.

```java
Child child = new Child();

B result = child.getObject();
```

Without a covariant return type, a cast might be required:

```java
B result = (B) child.getObject();
```

---

# Exception Rules in Overriding

## 17. Checked Exceptions

An overriding method cannot declare a broader checked exception than the superclass method.

```java
class Parent {

    void process() throws IOException {
    }
}
```

Valid override:

```java
class Child extends Parent {

    @Override
    void process() throws FileNotFoundException {
    }
}
```

`FileNotFoundException` is a subclass of `IOException`.

Invalid override:

```java
class Child extends Parent {

    @Override
    void process() throws Exception {
        // Compile-time error
    }
}
```

`Exception` is broader than `IOException`.

---

## 18. Unchecked Exceptions

An overriding method can declare unchecked exceptions.

```java
class Parent {

    void process() {
    }
}

class Child extends Parent {

    @Override
    void process() throws IllegalArgumentException {
    }
}
```

Unchecked exceptions are subclasses of `RuntimeException`.

---

# Fields and Overriding

## 19. Fields Are Not Overridden

Fields are hidden, not overridden.

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

The field is selected using the compile-time reference type.

---

## 20. Fields vs Methods

```java
class Parent {

    int value = 10;

    void display() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    int value = 20;

    @Override
    void display() {
        System.out.println("Child");
    }
}
```

```java
Parent reference = new Child();

System.out.println(reference.value);
reference.display();
```

Output:

```text
10
Child
```

Reason:

- Field access uses the reference type.
- Overridden instance-method calls use the runtime object type.

---

# Summary

- Method overriding requires inheritance.
- The subclass provides a new implementation of an inherited method.
- Method name and parameter list must be the same.
- Use `@Override` to detect mistakes.
- Different parameters result in overloading, not overriding.
- Return type must be the same or covariant.
- Primitive return types must match exactly.
- An overriding method cannot reduce visibility.
- Private methods cannot be overridden.
- Final methods cannot be overridden.
- Static methods are hidden, not overridden.
- Dynamic method dispatch resolves overridden methods at runtime.
- Reference type controls compile-time accessibility.
- Runtime object type controls overridden instance-method execution.
- Fields do not participate in runtime polymorphism.
- `super.method()` calls the immediate parent implementation.
- Checked exceptions cannot be broader in the overriding method.

---

# Important Interview Questions

## 1. What is method overriding?

Method overriding occurs when a subclass provides a new implementation of an inherited instance method with the same signature and a compatible return type.

---

## 2. Why is overriding called runtime polymorphism?

The runtime object type decides which overridden method implementation executes.

```java
Vehicle vehicle = new Bus();
vehicle.start();
```

`Bus.start()` executes at runtime.

---

## 3. What is dynamic method dispatch?

Dynamic method dispatch is the runtime process of selecting the overridden instance method based on the actual object type.

---

## 4. What is the difference between overloading and overriding?

Overloading:

- Different parameter lists
- Compile-time resolution
- Inheritance is not required

Overriding:

- Same method signature
- Runtime resolution
- Inheritance is required

---

## 5. Can the return type be changed while overriding?

Yes, for reference types, the overriding method can return a subtype of the original return type.

This is called a covariant return type.

---

## 6. Can primitive return types be covariant?

No.

Primitive return types must match exactly.

```java
int getValue()
```

cannot be overridden with:

```java
long getValue()
```

---

## 7. Can an overriding method reduce access?

No.

It can preserve or increase visibility, but it cannot reduce it.

```text
protected → public
```

is valid.

```text
public → protected
```

is invalid.

---

## 8. Can private methods be overridden?

No.

Private methods are not accessible to subclasses. A same-named child method is a new method.

---

## 9. Can final methods be overridden?

No.

A final method cannot be overridden.

---

## 10. Can static methods be overridden?

No.

Static methods are hidden and selected based on the compile-time reference type.

---

## 11. Does runtime polymorphism apply to fields?

No.

Fields are selected using the compile-time reference type.

---

## 12. Which type decides accessible methods?

The compile-time reference type decides which methods can be called.

```java
Vehicle vehicle = new Bus();
```

Only methods available through `Vehicle` are directly accessible.

---

## 13. Which type decides the overridden method implementation?

The actual runtime object type decides which overridden method executes.

---

## 14. Can constructors be overridden?

No.

Constructors are not inherited, so they cannot be overridden.

---

## 15. Can an overriding method throw a broader checked exception?

No.

It can throw:

- The same checked exception
- A narrower checked exception
- No checked exception

---

## 16. Can an overriding method throw an unchecked exception?

Yes.

Unchecked exceptions are not restricted by the checked-exception overriding rule.

---

## 17. What happens when `super.method()` is called?

It directly calls the immediate superclass implementation.

```java
super.display();
```

---

## 18. Is the superclass instance method hidden after overriding?

No.

The method is overridden, not hidden. It can still be accessed inside the subclass using `super.method()`.

The term **method hiding** is used for static methods.