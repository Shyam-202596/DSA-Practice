# Packages in Java

## 1. Package

A package is a container used to group related classes, interfaces, enums, annotations, and subpackages.

```java
package com.example.payment;
```

Packages are used for:

- Organizing related types
- Preventing naming conflicts
- Controlling access
- Improving code maintainability
- Creating a hierarchical project structure

---

## 2. Package as a Namespace

A package provides a separate namespace for its types.

For example, two packages can contain classes with the same name:

```text
java.util.List
com.example.List
```

The fully qualified class names are different, so they do not conflict.

```java
java.util.List<String> names;
com.example.List customList;
```

---

## 3. Package as an Access-Control Mechanism

A package also controls the visibility of classes and members.

A package-private member is accessible only inside the same package.

```java
package com.example.employee;

class EmployeeValidator {

    void validate() {
        System.out.println("Validating employee");
    }
}
```

Here:

- `EmployeeValidator` is package-private.
- `validate()` is package-private.
- Both are accessible only within `com.example.employee`.

> A package is both a naming mechanism and an access-control mechanism.

---

## 4. Declaring a Package

The `package` keyword is used to declare a package.

```java
package com.example.employee;
```

The package declaration must be the first non-comment statement in the source file.

```java
package com.example.employee;

public class Employee {
}
```

Imports must appear after the package declaration.

```java
package com.example.employee;

import java.util.List;

public class Employee {
}
```

---

## 5. Naming Convention

Package names should be written in lowercase.

Recommended:

```text
com.example.payment
com.company.employee
org.example.utility
```

Avoid:

```text
MyPackage
EmployeeManagement
```

Organizations commonly use the reverse-domain naming convention:

```text
com.company.project.module
```

Example:

```java
package com.microsoft.tax.service;
```

This reduces the chance of package-name conflicts.

---

## 6. Package and Directory Structure

The source directory structure should match the package hierarchy.

For this declaration:

```java
package com.example.employee;
```

The source file should normally be stored as:

```text
src/
└── com/
    └── example/
        └── employee/
            └── Employee.java
```

For:

```java
package java.awt.image;
```

The hierarchy is:

```text
java/
└── awt/
    └── image/
```

On Windows, it may appear as:

```text
java\awt\image
```

On Linux and macOS:

```text
java/awt/image
```

Package names are case-sensitive.

```text
com.example
```

and:

```text
com.Example
```

are treated as different package names.

---

## 7. Compiling a Packaged Class

Consider the following source file:

```java
package com.example.employee;

public class Employee {

    public void display() {
        System.out.println("Employee");
    }
}
```

Compile it using:

```bash
javac -d out Employee.java
```

The `-d` option specifies the destination directory for compiled classes.

Generated structure:

```text
out/
└── com/
    └── example/
        └── employee/
            └── Employee.class
```

---

## 8. Running a Packaged Class

Consider:

```java
package com.example.employee;

public class Employee {

    public static void main(String[] args) {
        System.out.println("Employee application");
    }
}
```

After compiling into the `out` directory:

```bash
javac -d out Employee.java
```

Run it using its fully qualified class name:

```bash
java -cp out com.example.employee.Employee
```

Do not run it using only:

```bash
java Employee
```

The JVM needs the fully qualified class name.

---

# Classpath

## 9. What Is Classpath?

The classpath tells the compiler and JVM where to find compiled classes and libraries.

It can contain:

- Directories
- JAR files
- Multiple classpath entries

The classpath can be specified using:

- The current directory
- The `CLASSPATH` environment variable
- The `-classpath` option
- The shorter `-cp` option

---

## 10. Current Directory

The current directory can be represented by:

```text
.
```

Example:

```bash
java -cp . com.example.Main
```

Here, the JVM starts searching from the current directory.

---

## 11. Using `-classpath` or `-cp`

The classpath can be supplied directly to `javac` and `java`.

Compile:

```bash
javac -cp out -d out Main.java
```

Run:

```bash
java -cp out com.example.Main
```

`-cp` is the short form of `-classpath`.

```bash
java -classpath out com.example.Main
```

Both commands are equivalent.

---

## 12. Multiple Classpath Entries

Multiple entries can be provided in the classpath.

On Linux and macOS, use a colon:

```bash
java -cp "out:lib/example.jar" com.example.Main
```

On Windows, use a semicolon:

```bash
java -cp "out;lib\example.jar" com.example.Main
```

The classpath should point to the root directory containing the package hierarchy, not directly to the package directory.

Correct:

```text
out/
└── com/
    └── example/
        └── Main.class
```

Use:

```bash
java -cp out com.example.Main
```

Do not use:

```bash
java -cp out/com/example Main
```

---

## 13. `CLASSPATH` Environment Variable

The `CLASSPATH` environment variable can define default class-search locations.

However, explicitly using `-cp` or `-classpath` is often clearer because the required path is visible in the command.

Example:

```bash
java -cp out com.example.Main
```

Modern build tools such as Maven and Gradle usually manage the classpath automatically.

---

# Import Statement

## 14. Importing a Class

The `import` statement allows a class to be used through its simple name.

Without import:

```java
java.util.ArrayList<String> names =
        new java.util.ArrayList<>();
```

With import:

```java
import java.util.ArrayList;

ArrayList<String> names =
        new ArrayList<>();
```

An import does not copy or load a class into the source file.

It only allows the compiler to resolve the simple class name.

---

## 15. Importing All Public Types

The wildcard can import accessible types from a package.

```java
import java.util.*;
```

This allows public types from `java.util` to be used through their simple names.

```java
List<String> names = new ArrayList<>();
```

The wildcard does not import subpackages.

```java
import java.util.*;
```

does not import types from:

```text
java.util.concurrent
```

A separate import is required:

```java
import java.util.concurrent.ExecutorService;
```

---

## 16. Public Access Across Packages

Consider:

```java
package packageone;

public class Employee {

    public void display() {
        System.out.println("Employee");
    }
}
```

It can be imported and accessed from another package:

```java
package packagetwo;

import packageone.Employee;

public class Main {

    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.display();
    }
}
```

Both the class and the required member must be accessible.

---

## 17. Package-Private Access

A top-level class without an access modifier is package-private.

```java
package packageone;

class Employee {
}
```

It cannot be imported and used from another package:

```java
package packagetwo;

import packageone.Employee; // Compile-time error
```

Similarly, a package-private member is unavailable outside its package.

```java
package packageone;

public class Employee {

    void display() {
        System.out.println("Employee");
    }
}
```

The class can be imported, but `display()` cannot be called from another package.

---

## 18. Protected Access Across Packages

A protected member can be accessed:

- By any class in the same package
- By a subclass in another package through inheritance

```java
package packageone;

public class Parent {

    protected void display() {
        System.out.println("Parent");
    }
}
```

```java
package packagetwo;

import packageone.Parent;

public class Child extends Parent {

    void show() {
        display();
    }
}
```

Importing a package does not change access-control rules.

---

## 19. Importing Does Not Bypass Access Control

An import only resolves a type name.

It does not make inaccessible classes or members accessible.

```java
import packageone.Employee;
```

The compiler still checks whether:

- `Employee` is accessible
- Its constructor is accessible
- The requested fields and methods are accessible

> Import and access control are separate concepts.

---

## 20. Fully Qualified Class Name

A fully qualified class name contains the package name and class name.

```text
java.util.ArrayList
```

It can be used without an import:

```java
java.util.ArrayList<String> names =
        new java.util.ArrayList<>();
```

Fully qualified names are useful when two imported packages contain classes with the same name.

```java
java.util.Date utilityDate =
        new java.util.Date();

java.sql.Date sqlDate =
        java.sql.Date.valueOf("2026-10-17");
```

Java does not support import aliases.

---

## 21. Automatic Imports

The `java.lang` package is imported automatically.

Therefore, classes such as these do not require explicit imports:

```text
String
System
Object
Integer
Math
Exception
```

This import is unnecessary:

```java
import java.lang.String;
```

Classes in the current package are also available without an import.

---

## 22. Static Import

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

Static imports should be used carefully because excessive use can reduce readability.

---

# Package Structure in a Project

## 23. Layer-Based Package Structure

A typical project may use packages based on application layers:

```text
com.example.tax
├── controller
├── service
├── repository
├── entity
├── dto
├── exception
└── config
```

Example declarations:

```java
package com.example.tax.controller;
```

```java
package com.example.tax.service;
```

```java
package com.example.tax.repository;
```

This structure keeps responsibilities organized.

---

## 24. Package Naming Guidelines

Follow these conventions:

- Use lowercase letters.
- Use meaningful names.
- Avoid spaces and special characters.
- Use reverse-domain naming for uniqueness.
- Keep package responsibilities focused.
- Avoid putting unrelated classes in one package.
- Avoid creating unnecessary deeply nested packages.

Recommended:

```text
com.example.order.service
```

Avoid:

```text
Com.Example.OrderServicePackage
```

---

# Summary

- A package groups related classes and other Java types.
- Packages prevent class-name conflicts.
- A package provides naming and access control.
- Packages are declared using the `package` keyword.
- The package declaration must appear before imports and type declarations.
- Package names conventionally use lowercase letters.
- Source directories normally follow the package hierarchy.
- Package and directory names are case-sensitive.
- The classpath tells Java where to find classes and libraries.
- `-cp` is the short form of `-classpath`.
- The classpath should point to the root of the package hierarchy.
- An import allows the use of a simple class name.
- Importing does not bypass access restrictions.
- Wildcard imports do not import subpackages.
- Package-private types and members are accessible only in the same package.
- `java.lang` is imported automatically.
- Fully qualified names resolve classes with identical simple names.
- Modern build tools usually manage the classpath automatically.

---

# Important Interview Questions

## 1. What is a package in Java?

A package is a namespace used to group related classes, interfaces, enums, annotations, and subpackages.

It also helps control visibility.

---

## 2. Why are packages used?

Packages are used for:

- Code organization
- Namespace management
- Access control
- Avoiding class-name conflicts
- Improving maintainability

---

## 3. What is a fully qualified class name?

It is the combination of a package name and a class name.

```text
java.util.ArrayList
```

---

## 4. Where must the package statement appear?

The package statement must be the first non-comment statement in the source file.

```java
package com.example;

import java.util.List;
```

---

## 5. What is package-private access?

When no access modifier is used, a class or member is accessible only within the same package.

```java
class Employee {
}
```

---

## 6. Does importing a class make its private or package-private members accessible?

No.

Import only helps the compiler resolve the class name. Normal access-control rules still apply.

---

## 7. What is the difference between a package and an import?

A package defines the namespace to which a class belongs.

```java
package com.example;
```

An import allows a type from another package to be used through its simple name.

```java
import java.util.List;
```

---

## 8. Does wildcard import include subpackages?

No.

```java
import java.util.*;
```

does not import:

```text
java.util.concurrent
```

---

## 9. What is classpath?

Classpath specifies where the compiler and JVM should search for compiled classes and libraries.

```bash
java -cp out com.example.Main
```

---

## 10. What is the difference between `-cp` and `-classpath`?

There is no functional difference.

`-cp` is the shorter form of `-classpath`.

---

## 11. Should classpath point directly to the package directory?

No.

It should point to the root directory containing the package hierarchy.

For:

```text
out/com/example/Main.class
```

use:

```bash
java -cp out com.example.Main
```

---

## 12. Which package is automatically imported?

The `java.lang` package is automatically imported.

Examples:

```text
String
Object
System
Integer
Math
```

---

## 13. Can two packages contain classes with the same name?

Yes.

Their fully qualified names remain different.

```text
java.util.Date
java.sql.Date
```

---

## 14. Can two classes with the same simple name be imported together?

They cannot both be used through the same simple name without ambiguity.

Use at least one fully qualified class name.

```java
java.util.Date first;
java.sql.Date second;
```

---

## 15. Can a top-level class be protected or private?

No.

A top-level class can be:

- `public`
- Package-private

---

## 16. What does `javac -d` do?

The `-d` option specifies the destination directory for generated class files.

```bash
javac -d out Employee.java
```

The compiler generates the required package-directory structure under `out`.

---

## 17. Does an import load a class into memory?

No.

An import is a compile-time feature used for resolving type names. Class loading is handled separately by the JVM.

---

## 18. What is static import?

Static import allows static members to be used without writing the class name.

```java
import static java.lang.Math.sqrt;
```

```java
double value = sqrt(25);
```

---

## 19. Are package names case-sensitive?

Yes.

```text
com.example
```

and:

```text
com.Example
```

are different package names.

---

## 20. Can a package be renamed without changing the source code?

Normally, no.

The package declaration, directory structure, imports, build configuration, and references may all need to be updated.