# Encapsulation in Java

## 1. Encapsulation

Encapsulation is the process of combining data and the methods that operate on that data into a single unit called a class.

It also controls direct access to an object's internal state.

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

Here:

- `balance` represents the internal state.
- `balance` cannot be modified directly from outside.
- `deposit()` provides controlled modification.
- `getBalance()` provides read-only access.

---

## 2. Purpose of Encapsulation

Encapsulation helps to:

- Protect object state
- Prevent invalid data modification
- Hide implementation details
- Provide controlled access
- Reduce coupling
- Improve maintainability
- Preserve business rules and object invariants

---

## 3. How Encapsulation Is Implemented

Encapsulation is commonly implemented using:

1. Classes
2. Access modifiers
3. Private fields
4. Public or protected behavior methods
5. Validation inside methods

```java
class Employee {

    private int id;
    private String name;

    public Employee(int id, String name) {
        setId(id);
        setName(name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID must be positive"
            );
        }

        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(
                    "Name cannot be empty"
            );
        }

        this.name = name;
    }
}
```

The object controls how its fields are accessed and modified.

---

## 4. Private Fields

Fields are generally declared `private` to prevent uncontrolled access.

```java
class Product {

    private double price;
}
```

The following direct access is not allowed:

```java
Product product = new Product();

product.price = -100; // Compile-time error
```

Controlled access can be provided through methods.

```java
class Product {

    private double price;

    public double getPrice() {
        return price;
    }

    public void updatePrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Price must be positive"
            );
        }

        this.price = price;
    }
}
```

---

## 5. Getters and Setters

A getter reads a field value.

```java
public double getBalance() {
    return balance;
}
```

A setter updates a field value.

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

However, creating getters and setters for every field does not automatically provide good encapsulation.

The following setter allows invalid state:

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

A better design validates the value:

```java
public void setBalance(double balance) {
    if (balance < 0) {
        throw new IllegalArgumentException(
                "Balance cannot be negative"
        );
    }

    this.balance = balance;
}
```

> Encapsulation means controlled access, not unrestricted access through getters and setters.

---

## 6. Prefer Behavior Methods

Instead of exposing generic setters, prefer methods that represent valid business operations.

Less meaningful design:

```java
account.setBalance(
        account.getBalance() - 500
);
```

Better design:

```java
account.withdraw(500);
```

Implementation:

```java
class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException(
                    "Initial balance cannot be negative"
            );
        }

        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                    "Deposit must be positive"
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

Benefits:

- Business rules remain inside the class.
- Invalid state changes are prevented.
- Internal implementation can change safely.

---

## 7. Read-Only Encapsulation

A field can provide only a getter when external modification is not required.

```java
class Employee {

    private final int id;

    Employee(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "ID must be positive"
            );
        }

        this.id = id;
    }

    public int getId() {
        return id;
    }
}
```

The `id` can be read but cannot be modified after object creation.

---

## 8. Write-Only Encapsulation

A class may provide modification without exposing the stored value.

```java
class PasswordManager {

    private String password;

    public void changePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException(
                    "Password must contain at least 8 characters"
            );
        }

        this.password = password;
    }

    public boolean matches(String input) {
        return password.equals(input);
    }
}
```

There is no getter that exposes the password.

---

## 9. Fully Encapsulated Class

A class is commonly considered fully encapsulated when all its fields are private and access is provided only through controlled methods.

```java
class Student {

    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
```

A fully encapsulated class does not need to provide setters for every field.

---

## 10. Encapsulation and Mutable Objects

Making a collection field private is not sufficient if its reference is exposed directly.

```java
class Team {

    private final List<String> members =
            new ArrayList<>();

    public List<String> getMembers() {
        return members;
    }
}
```

The caller can modify the internal list:

```java
team.getMembers().clear();
```

This breaks encapsulation.

Return an unmodifiable copy instead:

```java
class Team {

    private final List<String> members =
            new ArrayList<>();

    public void addMember(String member) {
        if (member == null || member.isBlank()) {
            throw new IllegalArgumentException(
                    "Member name cannot be empty"
            );
        }

        members.add(member);
    }

    public List<String> getMembers() {
        return List.copyOf(members);
    }
}
```

Now the internal collection cannot be modified through the returned list.

---

## 11. Defensive Copying

Mutable objects passed into a constructor should be copied when independent internal state is required.

```java
class Schedule {

    private final List<String> tasks;

    Schedule(List<String> tasks) {
        this.tasks = new ArrayList<>(tasks);
    }

    public List<String> getTasks() {
        return List.copyOf(tasks);
    }
}
```

This prevents callers from changing the object's state through the original list or the returned list.

---

## 12. Encapsulation and Immutability

Encapsulation does not automatically make a class immutable.

An immutable class generally:

- Is not designed for state changes after construction
- Uses private final fields
- Does not provide mutating setters
- Protects mutable internal objects
- Initializes all required state through constructors or factories

```java
final class Employee {

    private final int id;
    private final String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
```

Every immutable class uses encapsulation, but every encapsulated class is not necessarily immutable.

---

## 13. Encapsulation vs Data Hiding

Encapsulation and data hiding are related but not identical.

### Encapsulation

Combines data and related behavior inside a class.

```java
class Account {

    private double balance;

    void deposit(double amount) {
        balance += amount;
    }
}
```

### Data Hiding

Restricts direct access to internal implementation details.

```java
private double balance;
```

Access modifiers help achieve data hiding, while encapsulation represents the overall class design.

---

# Encapsulation vs Abstraction

## 14. Comparison

| Encapsulation | Abstraction |
|---|---|
| Protects and controls an object's internal state | Exposes essential behavior while hiding unnecessary implementation details |
| Focuses on implementation and state management | Focuses on design and required behavior |
| Answers: **How is data protected and controlled?** | Answers: **What behavior should be available?** |
| Commonly implemented using classes, private fields, and controlled methods | Commonly implemented using interfaces and abstract classes |
| Prevents uncontrolled access to data | Reduces exposure to implementation complexity |
| Supports validation and object invariants | Defines a simplified contract for users |
| Does not require abstract classes or interfaces | Does not require getters and setters |
| Can exist without abstraction | Often relies on encapsulated implementations |

---

## 15. Encapsulation and Abstraction Together

```java
interface PaymentService {

    void pay(double amount);
}
```

```java
class WalletPayment implements PaymentService {

    private double balance;

    WalletPayment(double balance) {
        this.balance = balance;
    }

    @Override
    public void pay(double amount) {
        if (amount <= 0 || amount > balance) {
            throw new IllegalArgumentException(
                    "Invalid payment amount"
            );
        }

        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
```

Here:

- `PaymentService` provides abstraction by defining what operation is available.
- `WalletPayment` provides encapsulation by protecting and controlling `balance`.

---

# Benefits of Encapsulation

## 16. Main Benefits

### Controlled Access

The class decides how its state can be read or modified.

### Validation

Invalid values can be rejected before changing the object.

### Maintainability

Internal implementation can change without affecting callers.

### Loose Coupling

External code depends on methods instead of internal fields.

### Security

Sensitive information can remain hidden.

### Testability

Business rules remain inside focused methods and can be tested separately.

---

# Summary

- Encapsulation combines data and related behavior inside a class.
- It protects an object's internal state.
- Fields are generally declared private.
- Access is provided through controlled methods.
- Encapsulation does not mean creating getters and setters for every field.
- Methods should enforce validation and business rules.
- Behavior methods are often better than generic setters.
- Mutable internal objects should not be exposed directly.
- Defensive copying protects mutable state.
- Encapsulation and data hiding are related but not identical.
- Encapsulation does not automatically make a class immutable.
- Abstraction focuses on what is exposed.
- Encapsulation focuses on how internal state is protected.
- Good encapsulation preserves object invariants.

---

# Important Interview Questions

## 1. What is encapsulation?

Encapsulation is the process of combining data and related methods inside a class and controlling access to the object's internal state.

---

## 2. How is encapsulation implemented in Java?

It is commonly implemented using:

- Classes
- Private fields
- Access modifiers
- Controlled public or protected methods
- Validation logic

---

## 3. Why should fields generally be private?

Private fields prevent uncontrolled modification and allow the class to enforce validation and business rules.

---

## 4. Are getters and setters required for encapsulation?

No.

Encapsulation requires controlled access. A class may provide:

- Only a getter
- Only behavior methods
- Validated setters
- No public access for sensitive data

---

## 5. Does adding getters and setters automatically provide encapsulation?

No.

Unrestricted setters may still allow invalid state.

```java
public void setBalance(double balance) {
    this.balance = balance;
}
```

A well-encapsulated method should enforce required rules.

---

## 6. What is the difference between encapsulation and abstraction?

Abstraction hides unnecessary implementation details and exposes essential behavior.

Encapsulation protects internal state and controls how that state is accessed or modified.

---

## 7. What is the difference between encapsulation and data hiding?

Encapsulation combines data and behavior into a class.

Data hiding restricts direct access to internal members using access modifiers.

Data hiding is one part of encapsulation.

---

## 8. Can an encapsulated class be mutable?

Yes.

An encapsulated class may allow controlled state changes through methods.

```java
account.deposit(500);
```

Encapsulation does not require immutability.

---

## 9. Is every immutable class encapsulated?

A properly designed immutable class uses encapsulation to protect its state.

However, an encapsulated class is not necessarily immutable.

---

## 10. Why are behavior methods preferred over setters?

Behavior methods:

- Clearly represent business operations
- Validate changes
- Protect object invariants
- Hide state-management details

```java
account.withdraw(500);
```

is better than:

```java
account.setBalance(
        account.getBalance() - 500
);
```

---

## 11. What is an object invariant?

An object invariant is a condition that must always remain valid for an object.

Example:

```text
Account balance must not be negative.
```

Encapsulation helps enforce such conditions.

---

## 12. How can returning a mutable collection break encapsulation?

The caller may modify the class's internal state directly.

```java
team.getMembers().clear();
```

Return a defensive or unmodifiable copy:

```java
return List.copyOf(members);
```

---

## 13. What is defensive copying?

Defensive copying means creating a copy of a mutable object before storing or returning it.

It prevents external code from modifying internal state through shared references.

---

## 14. Can encapsulation exist without getters?

Yes.

A class may expose only meaningful behavior methods.

```java
account.deposit(500);
account.withdraw(200);
```

It does not need to expose every internal field.

---

## 15. Does `private` alone guarantee encapsulation?

No.

The class must also avoid exposing mutable internal objects and must provide well-designed methods that protect its state.

---

## 16. How does encapsulation improve maintainability?

The internal implementation can change without affecting calling code, as long as the public contract remains stable.

---

## 17. Can constructors support encapsulation?

Yes.

Constructors can validate initial values and prevent the creation of invalid objects.

```java
Employee(int id) {
    if (id <= 0) {
        throw new IllegalArgumentException();
    }

    this.id = id;
}
```

---

## 18. Give a real-world example of encapsulation.

A bank account hides its balance and exposes operations such as:

```java
deposit()
withdraw()
getBalance()
```

The account controls every balance modification and prevents invalid transactions.