# Method Overloading and Returning Objects in Java

# Method Overloading

## 1. Method Overloading

Method overloading allows multiple methods in the same class to have the same name but different parameter lists.

```java
class Calculator {

    int add(int first, int second) {
        return first + second;
    }

    double add(double first, double second) {
        return first + second;
    }
}
```

The compiler selects the appropriate method based on the arguments passed during the method call.

```java
Calculator calculator = new Calculator();

calculator.add(10, 20);
calculator.add(10.5, 20.5);
```

Method overloading is also known as **compile-time polymorphism** or **static polymorphism**.

---

## 2. Valid Ways to Overload a Method

A method can be overloaded by changing:

### Number of Parameters

```java
class Calculator {

    int add(int first, int second) {
        return first + second;
    }

    int add(int first, int second, int third) {
        return first + second + third;
    }
}
```

### Type of Parameters

```java
class Calculator {

    int add(int first, int second) {
        return first + second;
    }

    double add(double first, double second) {
        return first + second;
    }
}
```

### Order of Parameter Types

```java
class Printer {

    void print(int value, String message) {
        System.out.println(value + " " + message);
    }

    void print(String message, int value) {
        System.out.println(message + " " + value);
    }
}
```

Changing parameter names does not create overloading:

```java
void display(int first) {
}

void display(int second) {
    // Compile-time error
}
```

Both methods have the same signature:

```text
display(int)
```

---

## 3. Return Type and Method Overloading

Return type alone cannot be used to overload a method.

The following code is invalid:

```java
class Calculator {

    int calculate(int value) {
        return value;
    }

    double calculate(int value) {
        return value;
    }
}
```

Both methods have the same name and parameter list.

The compiler cannot select a method based only on where or how the returned value is used.

### Important Rule

> Method signature includes the method name and parameter types. Return type is not part of the method signature used for overloading.

---

## 4. Overload Resolution

When an overloaded method is called, the compiler selects the most suitable method.

The compiler generally checks:

1. Exact type match
2. Primitive widening
3. Boxing or unboxing
4. Varargs

Example:

```java
class OverloadDemo {

    void test(int value) {
        System.out.println("test(int)");
    }

    void test(double value) {
        System.out.println("test(double)");
    }
}
```

```java
OverloadDemo demo = new OverloadDemo();

demo.test(10);
```

Output:

```text
test(int)
```

The exact `int` match is preferred over conversion to `double`.

---

## 5. Primitive Widening in Overloading

Java can use primitive widening when no exact method match exists.

```java
class OverloadDemo {

    void test(double value) {
        System.out.println(
                "Inside test(double): " + value
        );
    }
}
```

```java
public class Main {

    public static void main(String[] args) {
        OverloadDemo demo = new OverloadDemo();

        int number = 88;

        demo.test(number);
        demo.test(123.2);
    }
}
```

Output:

```text
Inside test(double): 88.0
Inside test(double): 123.2
```

For this call:

```java
demo.test(number);
```

Java converts:

```text
int → double
```

because `test(int)` is not available.

If both methods exist:

```java
void test(int value) {
    System.out.println("test(int)");
}

void test(double value) {
    System.out.println("test(double)");
}
```

Then:

```java
demo.test(88);
```

calls:

```text
test(int)
```

because an exact match is preferred.

---

## 6. Primitive Widening Order

Some common widening conversions are:

```text
byte → short → int → long → float → double
char → int → long → float → double
```

Example:

```java
class Example {

    void display(long value) {
        System.out.println("long");
    }

    void display(double value) {
        System.out.println("double");
    }
}
```

```java
Example example = new Example();

example.display(10);
```

Output:

```text
long
```

`int → long` is preferred because it is a closer widening conversion than `int → double`.

Java does not automatically perform narrowing for overload resolution:

```java
class Example {

    void display(byte value) {
        System.out.println("byte");
    }
}
```

```java
example.display(10); // Compile-time error
```

An explicit cast is required:

```java
example.display((byte) 10);
```

---

## 7. Boxing and Widening

Consider:

```java
class Example {

    void display(long value) {
        System.out.println("long");
    }

    void display(Integer value) {
        System.out.println("Integer");
    }
}
```

```java
example.display(10);
```

Output:

```text
long
```

Primitive widening is preferred over boxing:

```text
int → long
```

is preferred over:

```text
int → Integer
```

---

## 8. Varargs and Overloading

Varargs allow a method to accept a variable number of arguments.

```java
class Calculator {

    int add(int first, int second) {
        return first + second;
    }

    int add(int... values) {
        int result = 0;

        for (int value : values) {
            result += value;
        }

        return result;
    }
}
```

```java
calculator.add(10, 20);
```

The fixed-argument method is preferred over the varargs method.

```java
calculator.add(10, 20, 30);
```

The varargs method is selected because no fixed three-argument method exists.

---

## 9. Ambiguous Method Calls

Sometimes the compiler cannot determine which overloaded method is more suitable.

```java
class Printer {

    void print(String value) {
        System.out.println("String");
    }

    void print(StringBuilder value) {
        System.out.println("StringBuilder");
    }
}
```

The following call is ambiguous:

```java
Printer printer = new Printer();

printer.print(null); // Compile-time error
```

`null` can be passed to both `String` and `StringBuilder`, and neither type is more specific than the other.

The ambiguity can be resolved using a cast:

```java
printer.print((String) null);
```

---

## 10. Static Methods Can Be Overloaded

Static methods can be overloaded.

```java
class Utility {

    static void display(int value) {
        System.out.println("Integer: " + value);
    }

    static void display(String value) {
        System.out.println("String: " + value);
    }
}
```

```java
Utility.display(10);
Utility.display("Java");
```

Overloading is decided at compile time based on the method arguments.

---

## 11. Constructors Can Be Overloaded

Constructors can also be overloaded by changing their parameter lists.

```java
class Employee {

    private int id;
    private String name;

    Employee() {
        this(0, "Unknown");
    }

    Employee(int id) {
        this(id, "Unknown");
    }

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
```

This allows objects to be initialized in different ways.

---

## 12. Method Overloading vs Method Overriding

### Method Overloading

- Usually occurs within the same class.
- Uses the same method name.
- Requires different parameter lists.
- Is resolved at compile time.
- Return type alone cannot create overloading.

### Method Overriding

- Requires inheritance.
- Uses the same method name and parameter list.
- Provides a new implementation in the subclass.
- Is resolved at runtime for instance methods.
- Supports runtime polymorphism.

---

# Returning Objects

## 13. Returning an Object

A method can return an object reference.

```java
class Test {

    int value;

    Test(int value) {
        this.value = value;
    }

    Test incrementByTen() {
        Test result = new Test(value + 10);
        return result;
    }
}
```

Usage:

```java
public class Main {

    public static void main(String[] args) {
        Test first = new Test(2);

        Test second =
                first.incrementByTen();

        System.out.println(
                "first.value: " + first.value
        );

        System.out.println(
                "second.value: " + second.value
        );
    }
}
```

Output:

```text
first.value: 2
second.value: 12
```

The original object is not modified.

A new `Test` object is created and its reference is returned.

---

## 14. What Is Actually Returned?

Java does not return the complete object from the method.

It returns a reference to the object.

```java
Test incrementByTen() {
    return new Test(value + 10);
}
```

The returned reference is assigned to:

```java
Test second = first.incrementByTen();
```

Conceptually:

```text
second ───> new Test object
```

---

## 15. Returning the Same Object

A method can return the current object using `this`.

```java
class Employee {

    private String name;

    Employee setName(String name) {
        this.name = name;
        return this;
    }
}
```

Usage:

```java
Employee employee =
        new Employee().setName("Ram");
```

Returning `this` is commonly used for:

- Method chaining
- Fluent APIs
- Builder patterns

---

## 16. Returning a New Object

A method can create and return a new object.

```java
class Counter {

    private final int value;

    Counter(int value) {
        this.value = value;
    }

    Counter increment() {
        return new Counter(value + 1);
    }

    int getValue() {
        return value;
    }
}
```

Usage:

```java
Counter first = new Counter(10);
Counter second = first.increment();

System.out.println(first.getValue());  // 10
System.out.println(second.getValue()); // 11
```

This approach is commonly used when designing immutable classes.

---

## 17. Returning an Existing Object

A method can also return an already existing object.

```java
class EmployeeService {

    private Employee employee;

    EmployeeService(Employee employee) {
        this.employee = employee;
    }

    Employee getEmployee() {
        return employee;
    }
}
```

The method returns the existing reference. It does not automatically create a copy.

```java
Employee first = service.getEmployee();
Employee second = service.getEmployee();
```

Both references may point to the same object:

```text
first  ──┐
         ├──> Employee object
second ──┘
```

---

## 18. Object Lifetime and Garbage Collection

An object created inside a method does not automatically disappear when the method finishes.

```java
Test createObject() {
    Test object = new Test(10);
    return object;
}
```

The local variable `object` goes out of scope after the method completes, but the returned object remains reachable through the caller's reference.

```java
Test result = createObject();
```

The object becomes eligible for garbage collection only when it is no longer reachable through any live reference.

> Garbage collection timing is controlled by the JVM. There is no guarantee that an eligible object will be collected immediately or during a specific GC cycle.

---

## 19. Returning Mutable Objects

Returning a mutable internal object directly can expose the internal state of a class.

```java
class Team {

    private final List<String> members =
            new ArrayList<>();

    List<String> getMembers() {
        return members;
    }
}
```

The caller can modify the original list:

```java
team.getMembers().clear();
```

A safer approach is to return a defensive copy:

```java
class Team {

    private final List<String> members =
            new ArrayList<>();

    List<String> getMembers() {
        return new ArrayList<>(members);
    }
}
```

An unmodifiable copy can also be returned:

```java
List<String> getMembers() {
    return List.copyOf(members);
}
```

---

# Summary

- Method overloading allows multiple methods with the same name.
- Overloaded methods must have different parameter lists.
- Parameters may differ by number, type, or order.
- Return type alone cannot overload a method.
- Method overloading is resolved at compile time.
- An exact type match is preferred.
- Primitive widening is used when no exact match exists.
- Primitive widening is preferred over boxing.
- Fixed-argument methods are preferred over varargs.
- Ambiguous overload calls cause compile-time errors.
- Static methods and constructors can be overloaded.
- A method can return an object reference.
- A method may return a new object, an existing object, or `this`.
- Returning an existing object does not create a copy.
- An object remains alive while it is reachable.
- Garbage collection timing is not guaranteed.
- Avoid exposing mutable internal objects directly.

---

# Important Interview Questions

## 1. What is method overloading?

Method overloading means defining multiple methods with the same name but different parameter lists.

```java
void display(int value) {
}

void display(String value) {
}
```

---

## 2. Why is method overloading called compile-time polymorphism?

The compiler determines which overloaded method should execute based on the arguments present at the call site.

---

## 3. Can methods be overloaded by changing only the return type?

No.

```java
int calculate(int value) {
    return value;
}

double calculate(int value) {
    return value;
}
```

This causes a compile-time error because both methods have the same signature.

---

## 4. What changes can create valid method overloading?

A method can be overloaded by changing:

- Number of parameters
- Parameter types
- Order of different parameter types

---

## 5. Does changing parameter names create overloading?

No.

```java
void display(int first) {
}

void display(int second) {
}
```

Both methods have the same signature.

---

## 6. Which method is selected when an exact match and widening conversion are both available?

The exact match is selected.

```java
void display(int value) {
}

void display(double value) {
}
```

```java
display(10);
```

This calls `display(int)`.

---

## 7. Which is preferred: widening or boxing?

Primitive widening is preferred over boxing.

```java
void display(long value) {
}

void display(Integer value) {
}
```

```java
display(10);
```

This calls `display(long)`.

---

## 8. Which is preferred: fixed arguments or varargs?

A fixed-argument method is preferred.

```java
void display(int first, int second) {
}

void display(int... values) {
}
```

```java
display(10, 20);
```

This calls the fixed-argument method.

---

## 9. Can static methods be overloaded?

Yes.

Static methods can be overloaded by changing their parameter lists.

---

## 10. Can constructors be overloaded?

Yes.

A class can contain multiple constructors with different parameter lists.

---

## 11. What causes an ambiguous overloaded method call?

Ambiguity occurs when multiple methods are equally suitable and the compiler cannot select one.

```java
void display(String value) {
}

void display(StringBuilder value) {
}
```

```java
display(null); // Compile-time error
```

---

## 12. Can Java automatically perform narrowing during overload resolution?

No.

An explicit cast is required.

```java
void display(byte value) {
}

display((byte) 10);
```

---

## 13. What does a method return when its return type is a class?

It returns a reference to an object of that class or its subclass.

```java
Employee getEmployee() {
    return new Employee();
}
```

---

## 14. Does returning an object create a copy?

No.

Returning an object normally returns its reference. A copy is created only when the program explicitly creates one.

---

## 15. Can a method return `this`?

Yes.

Returning `this` returns a reference to the current object.

```java
Employee setName(String name) {
    this.name = name;
    return this;
}
```

---

## 16. What happens to an object created inside a method?

It remains alive if its reference is returned or stored somewhere reachable.

It becomes eligible for garbage collection when no live reference can reach it.

---

## 17. Is an eligible object immediately garbage-collected?

No.

Eligibility does not guarantee immediate collection. The JVM decides when garbage collection runs.

---

## 18. What is the difference between returning `this` and returning a new object?

Returning `this` returns the same current object.

```java
return this;
```

Returning `new` creates and returns a separate object.

```java
return new Counter(value + 1);
```

---

## 19. Why should mutable internal objects not be returned directly?

The caller may modify the object's internal state without validation.

Return a defensive or unmodifiable copy when necessary.

```java
return List.copyOf(members);
```

---

## 20. What is the difference between overloading and overriding?

Overloading:

- Different parameter lists
- Usually within the same class
- Compile-time resolution

Overriding:

- Same method signature
- Requires inheritance
- Runtime resolution for instance methods