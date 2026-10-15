# Access Modifiers in Java

## 1. Access Control

**Access control** determines where a class, method, constructor, or variable can be accessed.

Access control helps us:

- Protect the internal state of an object.
- Prevent direct access to sensitive data.
- Expose only the required functionality.
- Implement encapsulation.
- Reduce unwanted dependencies between classes.

Usually, fields are restricted and accessed through methods.

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
}
```

Here, `balance` cannot be accessed directly from outside the class.

---

## 2. Types of Access Modifiers

Java provides four access levels:

1. `public`
2. `protected`
3. Default or package-private
4. `private`

> Default access does not use any keyword. It is also known as package-private access.

---

## 3. Accessibility Table

| Modifier | Same Class | Same Package | Subclass in Same Package | Subclass in Different Package | Different Package and Non-Subclass |
|---|---:|---:|---:|---:|---:|
| `public` | Yes | Yes | Yes | Yes | Yes |
| `protected` | Yes | Yes | Yes | Yes, through inheritance | No |
| Default | Yes | Yes | Yes | No | No |
| `private` | Yes | No | No | No | No |

### Accessibility Order

From most restrictive to least restrictive:

```text
private < default < protected < public
```

---

# Public Access Modifier

## 4. `public`

A `public` member can be accessed from anywhere, provided that its containing class is also accessible.

```java
package packageone;

public class Calculator {

    public int add(int first, int second) {
        return first + second;
    }
}
```

It can be accessed from another package:

```java
package packagetwo;

import packageone.Calculator;

public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int result = calculator.add(10, 20);
        System.out.println(result);
    }
}
```

### Important Point

A `public` member inside a package-private class is not accessible outside the package because the containing class itself is not accessible.

```java
class Calculator {

    public void calculate() {
        System.out.println("Calculating");
    }
}
```

The `Calculator` class cannot be accessed outside its package.

---

# Private Access Modifier

## 5. `private`

A `private` member can be accessed only inside the class in which it is declared.

```java
class Employee {

    private double salary;

    public void setSalary(double salary) {
        if (salary > 0) {
            this.salary = salary;
        }
    }

    public double getSalary() {
        return salary;
    }
}
```

The following direct access is not allowed:

```java
Employee employee = new Employee();

employee.salary = 50000; // Compile-time error
```

The field must be accessed through its public methods:

```java
employee.setSalary(50000);

System.out.println(employee.getSalary());
```

### Important Points

- A private member is not directly accessible outside its declaring class.
- A private member is not directly accessible in a subclass.
- A private member is not overridden by a subclass because it is not inherited as an accessible member.
- Private access is commonly used to implement encapsulation.

---

## 6. Private Members and Inheritance

Consider the following parent class:

```java
class Parent {

    private int value = 10;
}
```

The child class cannot directly access `value`.

```java
class Child extends Parent {

    void display() {
        System.out.println(value); // Compile-time error
    }
}
```

The parent class can provide a method to access it:

```java
class Parent {

    private int value = 10;

    protected int getValue() {
        return value;
    }
}
```

```java
class Child extends Parent {

    void display() {
        System.out.println(getValue());
    }
}
```

The private field remains part of the parent-class state inside the child object, but the child class cannot access it directly.

---

# Default Access

## 7. Default or Package-Private Access

When no access modifier is specified, the member gets default access.

```java
class Employee {

    int employeeId;

    void display() {
        System.out.println(employeeId);
    }
}
```

Default members are accessible:

- Inside the same class
- Inside other classes of the same package
- Inside subclasses located in the same package

They are not accessible outside the package.

> Default access does not mean `public`. It means package-private.

---

## 8. Default Access Example

```java
package packageone;

public class Employee {

    int employeeId = 101;

    void display() {
        System.out.println(employeeId);
    }
}
```

A class from the same package can access these members:

```java
package packageone;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();

        System.out.println(employee.employeeId);
        employee.display();
    }
}
```

A class from another package cannot access them:

```java
package packagetwo;

import packageone.Employee;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();

        System.out.println(employee.employeeId); // Compile-time error
        employee.display();                      // Compile-time error
    }
}
```

---

# Protected Access Modifier

## 9. `protected`

A `protected` member is accessible:

- Inside its own class
- By any class in the same package
- By a subclass in the same package
- By a subclass in a different package, through inheritance

```java
package packageone;

public class Base {

    protected void display() {
        System.out.println("Inside Base");
    }
}
```

Inside the same package, `protected` works similarly to default access.

```java
package packageone;

public class Helper {

    void show() {
        Base base = new Base();
        base.display();
    }
}
```

`Helper` can access `display()` because it belongs to the same package.

---

## 10. Protected Access in a Different Package

Consider a subclass in a different package:

```java
package packagetwo;

import packageone.Base;

public class Derived extends Base {

    public void show() {
        display();
        new Derived().display();
    }
}
```

Both calls are valid:

```java
display();
new Derived().display();
```

The inherited `protected` method is accessible inside `Derived`.

---

## 11. Important Protected Rule Across Packages

In a different package, a subclass cannot access a protected member using a superclass object.

```java
package packagetwo;

import packageone.Base;

public class Derived extends Base {

    public void show() {
        Base base = new Base();

        base.display(); // Compile-time error
    }
}
```

Even though `Derived` extends `Base`, the protected member cannot be accessed through a plain `Base` reference or object in a different package.

The following calls are allowed:

```java
display();
this.display();
new Derived().display();
```

The following call is not allowed:

```java
new Base().display();
```

### Important Rule

When a subclass accesses a protected instance member from a different package, the member must be accessed:

- Through inheritance using `this`
- Using `super`
- Through a reference whose compile-time type is the current subclass or its subclass

It cannot be accessed through a reference whose compile-time type is only the superclass.

---

## 12. Understanding the Protected Rule

Consider:

```java
package parentpackage;

public class Parent {

    protected int value = 10;
}
```

In another package:

```java
package childpackage;

import parentpackage.Parent;

public class Child extends Parent {

    void example() {
        Child child = new Child();
        child.value = 20; // Allowed

        Parent parent = new Child();
        parent.value = 30; // Compile-time error
    }
}
```

Even though the runtime object in the second case is `Child`, the compile-time type of `parent` is `Parent`.

For cross-package protected access, the compile-time reference type matters.

---

## 13. Access Through a Further Subclass

Consider another subclass of `Child`:

```java
package childpackage;

public class GrandChild extends Child {
}
```

The following access is allowed inside `Child`:

```java
package childpackage;

public class Child extends Parent {

    void example() {
        GrandChild grandChild = new GrandChild();

        grandChild.value = 30;
    }
}
```

This is allowed because `GrandChild` is a subclass of `Child`.

The protected member is being accessed through a reference whose type belongs to the current subclass hierarchy.

---

## 14. General Protected Rule

Suppose:

```java
class C {
    protected int member;
}
```

A subclass `S` exists in another package:

```java
class S extends C {
}
```

Inside `S`, protected access is allowed when the reference type is `S` or a subclass of `S`.

Conceptually:

```java
S object = new S();
object.member = 10; // Allowed
```

It is not allowed through a reference of type `C`:

```java
C object = new S();
object.member = 10; // Not allowed in a different package
```

### Why Does This Restriction Exist?

Suppose `C` has two unrelated subclasses:

```text
       C
      / \
     S   S2
```

Class `S` should not be allowed to manipulate the protected state of an unrelated subclass `S2`.

`S2` may have its own rules and internal implementation.

Java therefore allows a subclass to work with protected state only through its own inheritance branch.

---

## 15. Protected Example with Sibling Subclasses

```java
package parentpackage;

public class Parent {

    protected int value;
}
```

First subclass:

```java
package childpackage;

import parentpackage.Parent;

public class FirstChild extends Parent {

    void update() {
        FirstChild first = new FirstChild();
        first.value = 10; // Allowed

        SecondChild second = new SecondChild();
        second.value = 20; // Compile-time error
    }
}
```

Second subclass:

```java
package childpackage;

import parentpackage.Parent;

public class SecondChild extends Parent {
}
```

`FirstChild` and `SecondChild` are sibling subclasses.

`FirstChild` cannot access the inherited protected field through a `SecondChild` reference across package boundaries.

---

## 16. Protected Access Using `this` and `super`

Inside a subclass, inherited protected members can be accessed using `this` or `super`.

```java
package packagetwo;

import packageone.Base;

public class Derived extends Base {

    public void show() {
        display();
        this.display();
        super.display();
    }
}
```

All three calls refer to the inherited protected method.

### Difference

```java
this.display();
```

Starts method lookup from the current object type.

```java
super.display();
```

Explicitly refers to the superclass implementation.

This difference becomes important when the subclass overrides the method.

---

## 17. Protected Method Overriding

```java
class Parent {

    protected void display() {
        System.out.println("Parent display");
    }
}
```

```java
class Child extends Parent {

    @Override
    public void display() {
        System.out.println("Child display");
    }
}
```

A subclass can increase the visibility of an overridden method.

Here, visibility is increased from:

```text
protected → public
```

A subclass cannot reduce visibility.

The following is invalid:

```java
class Child extends Parent {

    @Override
    private void display() { // Compile-time error
        System.out.println("Child display");
    }
}
```

---

# Access Modifiers with Classes

## 18. Top-Level Class Access

A top-level class can use only:

- `public`
- Default or package-private access

Valid declarations:

```java
public class Employee {
}
```

```java
class Employee {
}
```

Invalid declarations:

```java
private class Employee {
}
```

```java
protected class Employee {
}
```

A top-level class cannot be declared `private` or `protected`.

---

## 19. Nested Class Access

A nested class can use all four access levels.

```java
class Outer {

    public class PublicNested {
    }

    protected class ProtectedNested {
    }

    class DefaultNested {
    }

    private class PrivateNested {
    }
}
```

Nested classes are members of their enclosing class, so member-level access modifiers can be applied to them.

---

# Access Modifiers and Constructors

## 20. Constructor Access

Constructors can use all four access levels.

```java
class Example {

    public Example(int value) {
    }

    protected Example(String value) {
    }

    Example(double value) {
    }

    private Example() {
    }
}
```

Constructor access controls where objects can be created.

### Public Constructor

```java
public Example() {
}
```

The object can be created from any accessible package.

### Protected Constructor

```java
protected Example() {
}
```

It can be used within the same package and through subclass construction.

### Default Constructor

```java
Example() {
}
```

It can be used only within the same package.

### Private Constructor

```java
private Example() {
}
```

It prevents object creation outside the class.

Private constructors are commonly used in:

- Singleton classes
- Utility classes
- Factory-method patterns
- Classes that should not be instantiated directly

---

# Access Modifiers and Encapsulation

## 21. Encapsulation Example

Encapsulation means hiding internal data and providing controlled access through methods.

```java
class BankAccount {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Deposit amount must be positive"
            );
        }

        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        return true;
    }
}
```

The field is private so that invalid changes cannot be made directly.

The following operation is prevented:

```java
BankAccount account = new BankAccount();

account.balance = -5000; // Compile-time error
```

Instead, all changes must pass through validated business methods.

---

## 22. Avoid Exposing Mutable Internal Data

Making a field private is not always enough.

```java
class Team {

    private List<String> members = new ArrayList<>();

    public List<String> getMembers() {
        return members;
    }
}
```

The caller can modify the internal list:

```java
team.getMembers().clear();
```

A safer approach is to return an unmodifiable view or defensive copy.

```java
class Team {

    private final List<String> members = new ArrayList<>();

    public List<String> getMembers() {
        return List.copyOf(members);
    }
}
```

This protects the internal state of the object.

---

# SDE-2 Interview Points

## 23. Important Points

1. Java has four access levels: `public`, `protected`, default, and `private`.
2. Default access is also known as package-private access.
3. Default members are accessible only within the same package.
4. `private` members are accessible only inside their declaring class.
5. Private members cannot be accessed directly by subclasses.
6. `protected` members are accessible to all classes in the same package.
7. A subclass in another package can access inherited protected members.
8. Cross-package protected access is restricted by the reference's compile-time type.
9. A cross-package subclass cannot access a protected member using a superclass reference.
10. The subclass can use `this`, `super`, or its own subclass-type reference.
11. A subclass can increase the visibility of an overridden method.
12. A subclass cannot reduce the visibility of an overridden method.
13. Top-level classes can be only `public` or package-private.
14. Nested classes can use all four access modifiers.
15. Constructors can use all four access modifiers.
16. Access modifiers are important for encapsulation and API design.
17. Fields should generally be kept private.
18. Public getters should not expose mutable internal state directly.
19. Use the least permissive access level that satisfies the requirement.

---

# Common Interview Questions

## Question 1: What is the difference between default and protected access?

**Answer:**

Both are accessible within the same package.

The difference appears outside the package:

- A default member is not accessible outside its package.
- A protected member can be accessed by a subclass in another package through inheritance.

---

## Question 2: Is default access the same as public access?

**Answer:** No.

A default member is accessible only within its package, while a public member can be accessed from any package if its containing class is accessible.

---

## Question 3: Can a subclass access private members of its parent class?

**Answer:** Not directly.

The parent class can provide protected or public methods to offer controlled access.

---

## Question 4: Can a protected member be accessed by a non-subclass?

**Answer:**

- Yes, if the non-subclass is in the same package.
- No, if the non-subclass is in a different package.

---

## Question 5: Why does `new Base().display()` fail in a different-package subclass?

Given:

```java
package packageone;

public class Base {

    protected void display() {
        System.out.println("Inside Base");
    }
}
```

And:

```java
package packagetwo;

import packageone.Base;

public class Derived extends Base {

    void show() {
        new Base().display(); // Compile-time error
    }
}
```

**Answer:**

`Derived` is outside the package of `Base`.

It receives protected access through inheritance, but it cannot use that access through a plain `Base` object or reference.

---

## Question 6: Why does `new Derived().display()` work?

```java
package packagetwo;

import packageone.Base;

public class Derived extends Base {

    void show() {
        new Derived().display();
    }
}
```

**Answer:**

`Derived` inherits the protected `display()` method.

The method is being accessed through a `Derived` reference, which belongs to the current subclass hierarchy.

---

## Question 7: Can an overridden method have a more restrictive access modifier?

**Answer:** No.

The subclass cannot reduce method visibility.

For example:

```text
public → protected
```

is not allowed.

However:

```text
protected → public
```

is allowed.

---

## Question 8: Can a top-level class be private or protected?

**Answer:** No.

A top-level class can be only:

- `public`
- Package-private

---

## Question 9: What is the most restrictive access modifier?

**Answer:** `private`

Accessibility order:

```text
private < default < protected < public
```

---

## Question 10: Should fields always be private?

**Answer:**

Fields should generally be private to protect object invariants and internal implementation.

However, constants are commonly exposed as:

```java
public static final
```

Example:

```java
public static final int MAX_RETRY_COUNT = 3;
```

---

## Question 11: Does a protected member require inheritance?

**Answer:** Not always.

Within the same package, any class can access a protected member even without inheritance.

Inheritance-specific protected rules become important when access happens from a different package.

---

## Question 12: Does the runtime object type decide protected access?

**Answer:** No.

Protected access is checked by the compiler. Therefore, the compile-time reference type and the location of the accessing code are important.

```java
Child child = new Child();
child.value = 10; // May be allowed
```

```java
Parent parent = new Child();
parent.value = 10; // May not be allowed across packages
```