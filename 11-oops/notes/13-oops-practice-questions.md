# Java OOP Practice Questions

These questions are divided into three difficulty levels:

- Easy: Core syntax and concepts
- Medium: Object modelling and design decisions
- Hard: SDE-2 level design and extensibility

> Solve each coding question using proper encapsulation, meaningful names, validation, and clean object-oriented design.

---

# Easy Questions

## 1. Student Class

Create a `Student` class containing:

- `id`
- `name`
- `marks`

Requirements:

- Keep all fields private.
- Initialize fields using a constructor.
- Provide required getters.
- Reject negative marks.
- Add a method that returns whether the student has passed.
- Passing marks should be `40`.

Example:

```java
Student student =
        new Student(101, "Ram", 75);

System.out.println(student.hasPassed());
```

Expected output:

```text
true
```

### Concepts Tested

- Class and object
- Constructor
- Encapsulation
- Validation

---

## 2. Rectangle Class

Create a `Rectangle` class containing:

- `length`
- `width`

Add methods to calculate:

- Area
- Perimeter

Requirements:

- Dimensions must be positive.
- Fields must not be directly accessible.
- The object must be initialized through a constructor.

Example:

```java
Rectangle rectangle =
        new Rectangle(10, 5);

System.out.println(rectangle.area());
System.out.println(rectangle.perimeter());
```

Expected output:

```text
50
30
```

### Concepts Tested

- Constructor
- Encapsulation
- Instance methods

---

## 3. Employee Counter

Create an `Employee` class that automatically assigns a unique ID to every new employee.

Example:

```java
Employee first = new Employee("Ram");
Employee second = new Employee("Shyam");

System.out.println(first.getId());
System.out.println(second.getId());
System.out.println(Employee.getEmployeeCount());
```

Expected output:

```text
1
2
2
```

### Requirements

- Use a static field for ID generation.
- Keep employee data private.
- Do not allow the employee ID to change.

### Concepts Tested

- Static variables
- Instance variables
- Final fields

---

## 4. Constructor Overloading

Create a `Product` class with these constructors:

```java
Product()
Product(String name)
Product(String name, double price)
```

Default values:

```text
name  = "Unknown"
price = 0.0
```

Avoid duplicate initialization logic by using constructor chaining.

### Concepts Tested

- Constructor overloading
- `this()`
- Encapsulation

---

## 5. Method Overloading

Create a `Calculator` class with overloaded `add()` methods for:

```java
int add(int first, int second)
int add(int first, int second, int third)
double add(double first, double second)
```

Test all methods from a `main()` method.

### Concepts Tested

- Method overloading
- Compile-time polymorphism
- Method signatures

---

## 6. Basic Inheritance

Create:

```text
Vehicle
   ↑
  Car
```

`Vehicle` should contain:

- `brand`
- `start()`

`Car` should contain:

- `numberOfDoors`
- `displayDetails()`

Requirements:

- Initialize parent fields using `super()`.
- Keep fields private.
- Use getters only where required.

### Concepts Tested

- Inheritance
- `super()`
- Constructor chaining

---

## 7. Method Overriding

Create a base class `Animal` with:

```java
void makeSound()
```

Create subclasses:

- `Dog`
- `Cat`
- `Cow`

Each subclass should override `makeSound()`.

Use an `Animal` reference to call each implementation.

### Concepts Tested

- Method overriding
- Runtime polymorphism
- Dynamic method dispatch

---

## 8. Interface Implementation

Create an interface:

```java
interface PaymentMethod {
    void pay(double amount);
}
```

Implement it using:

- `CardPayment`
- `UpiPayment`

Requirements:

- Reject zero or negative amounts.
- Call both implementations through `PaymentMethod` references.

### Concepts Tested

- Interface
- Runtime polymorphism
- Abstraction

---

## 9. Enum-Based Order Status

Create an enum:

```java
OrderStatus
```

Constants:

```text
PLACED
PROCESSING
SHIPPED
DELIVERED
CANCELLED
```

Each status should have a user-friendly description.

Example:

```java
OrderStatus status =
        OrderStatus.SHIPPED;

System.out.println(status.getDescription());
```

Expected output:

```text
Order has been shipped
```

### Concepts Tested

- Enum
- Enum fields
- Enum constructor
- Enum methods

---

## 10. Immutable Book Class

Create an immutable `Book` class containing:

- `isbn`
- `title`
- `author`

Requirements:

- The class must not be extendable.
- Fields must not change after construction.
- Do not provide setters.
- Validate that none of the values are null or blank.

### Concepts Tested

- Immutability
- `final`
- Encapsulation
- Constructor validation

---

# Medium Questions

## 11. Bank Account

Design a `BankAccount` class containing:

- Account number
- Account holder name
- Balance
- Transaction history

Supported operations:

```java
deposit(double amount)
withdraw(double amount)
getBalance()
getTransactions()
```

Rules:

- Deposit amount must be positive.
- Withdrawal amount must be positive.
- Withdrawal cannot exceed available balance.
- Account number cannot change.
- Transaction history must not be externally modifiable.

### Concepts Tested

- Encapsulation
- Object invariants
- Defensive copying
- Immutability

---

## 12. Employee Salary System

Create an abstract `Employee` class with:

```java
abstract double calculateSalary();
```

Implement:

- `FullTimeEmployee`
- `PartTimeEmployee`
- `ContractEmployee`

Rules:

- Full-time salary is fixed monthly salary.
- Part-time salary depends on hours and hourly rate.
- Contract salary depends on the agreed contract amount.

Write a method:

```java
double calculateTotalPayroll(
        List<Employee> employees
)
```

Do not use `instanceof` inside payroll calculation.

### Concepts Tested

- Abstract class
- Runtime polymorphism
- Open/Closed Principle

---

## 13. Shape Area Calculator

Create an interface:

```java
interface Shape {
    double area();
}
```

Implement:

- `Circle`
- `Rectangle`
- `Triangle`

Write a method that calculates the total area of a list of shapes.

```java
double totalArea(List<Shape> shapes)
```

Adding a new shape should not require modifying the total-area method.

### Concepts Tested

- Interfaces
- Polymorphism
- Open/Closed Principle

---

## 14. Composition: Car and Engine

Design:

```text
Car HAS-A Engine
```

`Engine` should contain:

- Engine number
- Fuel type
- Running status

`Car` should provide:

```java
start()
stop()
```

The `Car` must use the `Engine` internally.

Do not make `Car` extend `Engine`.

### Concepts Tested

- Composition
- HAS-A relationship
- Composition over inheritance

---

## 15. Notification Service

Create an interface:

```java
interface NotificationSender {
    void send(String recipient, String message);
}
```

Implement:

- `EmailNotificationSender`
- `SmsNotificationSender`
- `PushNotificationSender`

Create a `NotificationService` that receives the interface through its constructor.

```java
NotificationService(
        NotificationSender sender
)
```

The service must not create concrete sender objects internally.

### Concepts Tested

- Dependency inversion
- Constructor injection
- Loose coupling
- Strategy pattern

---

## 16. Correct `equals()` and `hashCode()`

Create an `Employee` class containing:

- `employeeId`
- `name`
- `department`

Two employees should be considered equal when their `employeeId` values are equal.

Requirements:

- Override `equals()`.
- Override `hashCode()`.
- Add duplicate employees to a `HashSet`.
- Verify that logical duplicates are not stored twice.

### Concepts Tested

- `Object` class
- Logical equality
- `equals()` and `hashCode()` contract
- Hash-based collections

---

## 17. Library Management

Design these classes:

- `Book`
- `Member`
- `Library`

The library should support:

```java
addBook(Book book)
registerMember(Member member)
issueBook(String isbn, int memberId)
returnBook(String isbn, int memberId)
```

Rules:

- A book cannot be issued to two members at the same time.
- An unregistered member cannot borrow a book.
- The same ISBN must not be added twice.
- Internal collections must not be exposed directly.

### Concepts Tested

- Object relationships
- Encapsulation
- Collections
- Business rules

---

## 18. Shopping Cart

Design:

- `Product`
- `CartItem`
- `ShoppingCart`

Supported operations:

```java
addProduct(Product product, int quantity)
removeProduct(String productId)
updateQuantity(String productId, int quantity)
calculateTotal()
```

Rules:

- Product price cannot be negative.
- Quantity must be positive.
- Adding the same product again should update its quantity.
- Total calculation must remain inside the cart.

### Concepts Tested

- Composition
- Encapsulation
- Object collaboration
- Single Responsibility Principle

---

## 19. Default Method Conflict

Create two interfaces:

```java
interface Camera {
    default void start() {
        System.out.println("Camera started");
    }
}
```

```java
interface MusicPlayer {
    default void start() {
        System.out.println("Music player started");
    }
}
```

Create a `SmartPhone` class that implements both.

Resolve the default-method conflict and demonstrate:

- A custom implementation
- Calling both interface implementations explicitly

### Concepts Tested

- Multiple interfaces
- Default methods
- Conflict resolution

---

## 20. Deep Immutability

Create an immutable `Employee` class containing:

- `id`
- `name`
- `Address`
- `List<String> skills`

Assume `Address` is mutable.

Requirements:

- Changes to the original `Address` must not affect `Employee`.
- Changes to the original skills list must not affect `Employee`.
- Returned values must not allow internal state modification.

### Concepts Tested

- Deep immutability
- Defensive copying
- Mutable references
- Encapsulation

---

# Hard Questions

## 21. Parking Lot Design

Design a parking lot supporting:

### Vehicle Types

- Bike
- Car
- Truck

### Parking Spot Types

- Bike spot
- Compact spot
- Large spot

### Operations

```java
parkVehicle(Vehicle vehicle)
removeVehicle(String ticketId)
calculateFee(String ticketId)
```

Rules:

- Each vehicle must receive a suitable parking spot.
- A spot can hold only one vehicle.
- Parking fee should depend on vehicle type and duration.
- Fee calculation should be replaceable without changing parking logic.

### Design Expectations

- Avoid large `if-else` chains based on vehicle type.
- Use interfaces or polymorphism.
- Separate parking allocation from fee calculation.
- Keep internal collections encapsulated.

### Concepts Tested

- Low-Level Design
- Strategy pattern
- Polymorphism
- SOLID principles

---

## 22. Logger Framework

Design a logger supporting:

### Log Levels

```text
INFO
DEBUG
WARNING
ERROR
```

### Output Destinations

- Console
- File
- Database

Usage should look similar to:

```java
logger.info("Application started");
logger.error("Database connection failed");
```

Requirements:

- New output destinations should be easy to add.
- Logging logic should not depend directly on concrete appenders.
- Each log should contain level, message, and timestamp.
- Log level filtering should be supported.

### Concepts Tested

- Interface-based design
- Strategy pattern
- Open/Closed Principle
- Dependency inversion

---

## 23. Split a God Class

Suppose an `OrderService` currently performs:

- Order validation
- Price calculation
- Payment processing
- Database saving
- Email sending
- Invoice generation

Refactor the design into focused classes and interfaces.

Your solution should identify:

- Responsibilities
- Required interfaces
- Dependencies
- Constructor injection
- Which SOLID principles were violated

Do not write all logic initially. First prepare the class design and explain each responsibility.

### Concepts Tested

- Single Responsibility Principle
- Interface Segregation
- Dependency inversion
- Refactoring

---

## 24. Payment Processing System

Design a payment system supporting:

- Card payment
- UPI payment
- Wallet payment
- Net banking

Every payment should go through:

```text
Validation
    ↓
Payment execution
    ↓
Receipt generation
    ↓
Notification
```

Requirements:

- Adding a new payment type should not modify existing payment classes.
- Notification should be independently replaceable.
- Failed payments should not generate successful receipts.
- All payment attempts should return a structured result.

### Concepts Tested

- SOLID principles
- Template Method or Strategy
- Composition
- Extensible design

---

## 25. Elevator System

Design an elevator system with:

- Multiple elevators
- Multiple floors
- Internal floor requests
- External up/down requests
- Elevator states
- Direction
- Request scheduling

Possible states:

```text
IDLE
MOVING
STOPPED
MAINTENANCE
```

Requirements:

- Scheduling logic should be replaceable.
- An elevator under maintenance should reject requests.
- The system should select a suitable elevator.
- State transitions should remain valid.

### Concepts Tested

- State modelling
- Strategy pattern
- Encapsulation
- Low-Level Design

---

## 26. Cache with Eviction Strategy

Design a generic cache:

```java
Cache<K, V>
```

Supported operations:

```java
put(K key, V value)
get(K key)
remove(K key)
size()
```

Support multiple eviction policies:

- LRU
- FIFO
- No eviction

Requirements:

- Eviction logic should be replaceable.
- Cache storage should not know policy details.
- Capacity must be validated.
- Adding a new policy should not require changing the cache class.

### Concepts Tested

- Generics
- Strategy pattern
- Composition
- Open/Closed Principle

---

## 27. Chess Piece Movement

Design:

- `Board`
- `Position`
- `Piece`
- `King`
- `Queen`
- `Rook`
- `Bishop`
- `Knight`
- `Pawn`

Each piece should determine whether a movement is valid.

```java
boolean canMove(
        Position source,
        Position destination,
        Board board
)
```

Requirements:

- Avoid a single method containing checks for every piece type.
- Board boundaries must be validated.
- A piece cannot capture another piece of the same side.
- Sliding pieces cannot jump over another piece.

Checkmate logic is not required.

### Concepts Tested

- Polymorphism
- Inheritance
- Responsibility assignment
- Low-Level Design

---

## 28. File-System Design

Design an in-memory file system supporting:

- Files
- Directories
- Nested directories

Common operations:

```java
getName()
getSize()
display(String indentation)
```

Directory operations:

```java
add(FileSystemItem item)
remove(String name)
```

Requirements:

- A directory can contain files and directories.
- File size is its own size.
- Directory size is the total size of its children.
- Client code should treat files and directories through a common type.

### Concepts Tested

- Composite pattern
- Runtime polymorphism
- Recursive object structure

---

## 29. Undoable Text Editor

Design a text editor supporting:

```java
write(String text)
delete(int characters)
undo()
redo()
getContent()
```

Requirements:

- Every edit should be represented as an object.
- New edit operations should be easy to add.
- Undo and redo history must be maintained.
- Calling a new operation after undo should clear redo history.

### Concepts Tested

- Command pattern
- Encapsulation
- Object state
- Stack-based history

---

## 30. Extensible Tax Calculation System

Design a tax calculation system supporting:

- Individual taxpayer
- Business taxpayer
- Different tax regimes
- Exemptions
- Multiple calculation strategies

Requirements:

```java
TaxResult calculate(
        Taxpayer taxpayer,
        TaxRegime regime
)
```

The design should ensure:

- Taxpayer data remains encapsulated.
- New tax regimes can be added.
- Existing calculations do not require modification.
- Validation is separated from calculation.
- Calculation returns a detailed result, not only a number.
- Tax-rate configuration is not hard-coded into taxpayer classes.

### Concepts Tested

- Strategy pattern
- SOLID principles
- Domain modelling
- Composition
- Open/Closed Principle

---

# Evaluation Checklist

Use this checklist after solving each question.

## Encapsulation

- Are fields private?
- Can invalid state be created?
- Are mutable collections exposed?
- Does the class control its own state?

## Inheritance and Polymorphism

- Is inheritance representing a true IS-A relationship?
- Can composition be used instead?
- Are `instanceof` and type-based condition chains avoidable?
- Are overridden methods marked with `@Override`?

## Abstraction

- Do interfaces represent meaningful contracts?
- Are implementation details hidden?
- Are clients dependent on interfaces instead of concrete classes?

## SOLID Principles

- Does each class have one primary responsibility?
- Can behavior be extended without repeatedly modifying existing classes?
- Can subclasses safely replace parent-class objects?
- Are interfaces small and focused?
- Do high-level classes depend on abstractions?

## Code Quality

- Are names meaningful?
- Are methods short and focused?
- Is duplicate logic removed?
- Are constructors validating required state?
- Are exceptions meaningful?
- Are class responsibilities clear?

---

# Recommended Practice Order

Solve in this order:

```text
Easy 1–10
    ↓
Medium 11–15
    ↓
Object class, equals(), hashCode(), and composition notes
    ↓
Medium 16–20
    ↓
SOLID principles and basic design patterns
    ↓
Hard 21–30
```

For every problem:

1. Identify classes and interfaces.
2. Identify relationships between objects.
3. Define responsibilities.
4. Write the public API.
5. Protect object invariants.
6. Implement the solution.
7. Test normal and invalid cases.
8. Review whether composition is better than inheritance.