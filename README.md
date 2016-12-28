# functionalswitch

A functional approach to the switch statement.

[![Build Status](https://travis-ci.org/MpStyle/functionalswitch.svg?branch=master)](https://travis-ci.org/MpStyle/functionalswitch)

- [Install](#install)
- [Quickstart Guide](quickstart) - How to include Functional Java in your project and get started

<a name="install"></a>
## Install

[JitPack](https://jitpack.io/#MpStyle/functionalswitch)

<a name="quickstart"></a>
## Quickstart Guide

There are 3 ways to create a functional switch, using:

- [**Callable**](https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/Callable.html): only returns value  
- [**Callback**](): only receives parameters (from 1 to 5)
- [**Function**](https://github.com/bodar/totallylazy/): receives parameters (from 1 to 5) and return values

### Callable example

```java
callableSwitch.add("key1", new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "key1";
    }
}).add("key2", new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "key2";
    }
}).add("key3", new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "key3";
    }
}).addDefault(new Callable<String>() {
    @Override
    public String call() throws Exception {
        return "default";
    }
});

assertEquals(callableSwitch.call("key1"), "key1");
assertEquals(callableSwitch.call("key2"), "key2");
assertEquals(callableSwitch.call("key3"), "key3");
assertEquals(callableSwitch.call("key4"), "default");

```

### Callback example

```java
```

### Function example

```java
```

## Documentation

[JavaDoc](https://mpstyle.github.io/functionalswitch/doc)

## License

[LGPL v. 3](https://www.gnu.org/licenses/lgpl-3.0.en.html)
