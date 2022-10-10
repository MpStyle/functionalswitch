# Functional Switch

Inspired by [C# switch expression](https://learn.microsoft.com/en-us/dotnet/csharp/language-reference/operators/switch-expression), **Functional Switch** is a lazy and naive way to execute a single behavior ([Consumers](https://docs.oracle.com/javase/8/docs/api/java/util/function/Consumer.html), [Functions](https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html), [Predicates](https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html) or [Suppliers](https://docs.oracle.com/javase/8/docs/api/java/util/function/Supplier.html)) from a list of candidate expressions.  

**Last version:** 2.0.0

**License:** MIT

**Continuous Integration:** [![Build Status](https://travis-ci.org/MpStyle/functionalswitch.svg?branch=master)](https://travis-ci.org/MpStyle/functionalswitch) [![](https://jitpack.io/v/MpStyle/functionalswitch.svg)](https://jitpack.io/#MpStyle/functionalswitch)

## Installation

### Maven
```xml
<repositories>
    ...
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
    ...
</repositories>
...
<dependency>
    <groupId>com.github.MpStyle</groupId>
    <artifactId>functionalswitch</artifactId>
    <version>v2.0.0</version>
</dependency>
```

### Gradle
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

...

dependencies {
    compile 'com.github.MpStyle:functionalswitch:v2.0.0'
}

```

## Usages

### Function switch 
Definition:
```java
var behaviors = FunctionSwitch.<Integer, Integer>build()
    .add("key01", input -> input + 1)
    .add("key02", input -> input + 2)
    .addDefault(input -> 0);
```
Usage:
```java
var result = behaviors.apply("key01", 5); // result == 6
```

### Consumer switch
### Predicate switch
### Supplier switch
Definition:
```java
var behaviors = SupplierSwitch.<Integer>build()
    .add("key01", () -> 5)
    .add("key02", () -> 6)
    .addDefault(() -> 0);
```
Usage:
```java
var result = behaviors.get("key01"); // result == 5
```

## How to release a new version

Steps:
* Change version in pom.xml file
* Change version in README.md file
* Check the build result on [Travis CI](https://travis-ci.org/github/MpStyle/functionalswitch)
* Draft a new release in GitHub
* Check the build on [JitPack](https://jitpack.io/#MpStyle/functionalswitch)
