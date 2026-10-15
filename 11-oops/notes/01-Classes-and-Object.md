# Classes and Objects in Java

## 1. Class

A **class** is a blueprint or template used to create objects.

- It defines the data that an object can store.
- It defines the operations that an object can perform.
- A class creates a new user-defined data type.

```java
class Box {
    int length;
    int width;

    void display() {
        System.out.println(length + " " + width);
    }
}
```

A class is a **logical construct** because it only defines the structure and behavior of objects.

---

## 2. Object

An **object** is an instance of a class.

```java
Box box = new Box();
```

Here:

- `Box` is the class.
- `box` is a reference variable.
- `new Box()` creates the actual object.

An object has **physical existence** because memory is allocated for it at runtime.

> A class defines what an object should contain, while an object represents the actual data stored in memory.

---

## 3. Properties of an Object

Every object has three essential properties:

### State

The current values stored inside the object represent its state.

```java
box.length = 10;
box.width = 20;
```

Here, `length` and `width` represent the state of the object.

### Behavior

The operations that an object can perform represent its behavior.

```java
box.display();
```

Methods define the behavior of an object.

### Identity

Identity uniquely distinguishes one object from another, even when both objects contain the same data.

```java
Box box1 = new Box();
Box box2 = new Box();
```

`box1` and `box2` refer to two different objects with separate identities.

---

## 4. Reference Variable and Object Creation

Object creation can be written in two steps:

```java
Box myBox;          // Reference variable declaration
myBox = new Box();  // Object creation
```

### Step 1: Reference Declaration

```java
Box myBox;
```

This creates a reference variable named `myBox`.

- No `Box` object is created yet.
- If it is a local variable, it must be initialized before use.
- If it is an instance variable, its default value is `null`.

### Step 2: Object Creation

```java
myBox = new Box();
```

This creates a `Box` object and stores its reference in `myBox`.

Combined form:

```java
Box myBox = new Box();
```

---

## 5. The `new` Keyword

The `new` keyword creates an object dynamically at runtime.

General syntax:

```java
ClassName referenceVariable = new ClassName();
```

Example:

```java
Bus bus = new Bus();
```

The `new` keyword:

1. Allocates memory for the object.
2. Calls the class constructor.
3. Initializes the object.
4. Returns a reference to the created object.

> A Java reference should not be treated as an actual memory address. The JVM manages the object’s memory location internally.

Unlike C or C++ pointers, Java references:

- Cannot be manipulated using pointer arithmetic.
- Cannot point to an arbitrary memory location.
- Cannot be converted and modified like integers.

This makes Java safer than languages that allow direct pointer manipulation.

---

## 6. Constructor Invocation

In this statement:

```java
Box box = new Box();
```

`Box()` represents a constructor call.

A constructor defines what happens when an object is created.

```java
class Box {
    int length;

    Box() {
        length = 10;
    }
}
```

When `new Box()` runs, the constructor initializes `length` with `10`.

---

## 7. Primitive Types and Objects

Primitive types do not require the `new` keyword.

```java
int number = 10;
char grade = 'A';
boolean active = true;
```

Java primitive types are not objects. They directly store simple values and are designed for efficiency.

Examples of primitive types:

```text
byte, short, int, long
float, double
char
boolean
```

Their corresponding wrapper classes are:

```text
Byte, Short, Integer, Long
Float, Double
Character
Boolean
```

Example:

```java
Integer number = Integer.valueOf(10);
```

---

## 8. Assigning One Reference to Another

Consider:

```java
Box b1 = new Box();
Box b2 = b1;
```

Only **one object** is created.

Both `b1` and `b2` refer to the same object.

```text
b1 ──┐
     ├──> Box object
b2 ──┘
```

Therefore, a modification through one reference is visible through the other.

```java
b2.length = 50;

System.out.println(b1.length); // 50
```

### Important Rule

> Assigning one reference variable to another copies the reference, not the object.

It does not:

- Create a new object.
- Allocate memory for another object.
- Copy the object’s data.

To create a separate object, explicit copying is required.

```java
Box b1 = new Box();
Box b2 = new Box();

b2.length = b1.length;
```

---

## 9. Dot Operator

The dot operator `.` is used to access the members of an object.

```java
box.length = 10;
box.display();
```

It connects the reference variable with:

- Instance variables
- Instance methods

Although it is commonly called the **dot operator**, the Java specification categorizes `.` as a **separator**.

---

## 10. Parameter vs Argument

Consider the following method:

```java
int square(int number) {
    return number * number;
}
```

Here, `number` is a **parameter**.

When the method is called:

```java
int result = square(10);
```

Here, `10` is an **argument**.

### Definition

- **Parameter:** A variable declared in the method definition.
- **Argument:** The actual value supplied during the method call.

```java
void display(int value) {  // value is a parameter
    System.out.println(value);
}

display(100);               // 100 is an argument
```

---

## 11. Understanding LHS and RHS

```java
Bus bus = new Bus();
```

### Left-Hand Side

```java
Bus bus
```

- Declares the reference variable.
- The declared type is checked by the compiler.
- It determines which members are accessible at compile time.

### Right-Hand Side

```java
new Bus()
```

- Creates the actual object at runtime.
- Memory allocation and object initialization are managed by the JVM.
- It determines the actual runtime object type.

### SDE-2 Perspective

This difference becomes important in polymorphism:

```java
Vehicle vehicle = new Bus();
```

Here:

- Reference type: `Vehicle`
- Actual object type: `Bus`
- Accessible methods are checked using the reference type.
- Overridden method execution is decided using the runtime object type.

---

## Interview Key Points

1. A **class** is a blueprint, while an **object** is an instance of that class.
2. A class is a logical definition; an object gets memory at runtime.
3. An object has **state, behavior, and identity**.
4. A reference variable stores a reference to an object, not the complete object.
5. The `new` keyword allocates memory, invokes the constructor, and returns an object reference.
6. Java references cannot be manipulated like C or C++ pointers.
7. Assigning one reference to another does not create a copy of the object.
8. Multiple references can point to the same object.
9. A parameter is declared by a method; an argument is passed during a method call.
10. The reference type controls compile-time access, while the actual object type affects runtime method execution.

### Common Interview Question

**How many objects are created here?**

```java
Box b1 = new Box();
Box b2 = b1;
```

**Answer:** Only one object is created. `b1` and `b2` refer to the same object.