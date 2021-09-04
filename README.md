# TOSTRING IMPLEMENTATION

[![Maven build status](https://github.com/trigunam/tostring-implementation/actions/workflows/test.yml/badge.svg)](https://github.com/trigunam/tostring-implementation/actions/workflows/test.yml)
[![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen)](CONTRIBUTING.md)

This project is a library for any POJO class to implement a toString method without actually writing any implementation.

[![Now in Maven Central](videos/now-in-mvn-central.gif)](https://search.maven.org/artifact/io.github.trigunam.java.util/tostring-implementation/2.1/jar)

## Usage

```java
@Override
public String toString() {
  return Utilities.toString(this);
}
```

The above will print the following output on a [HelloToString class](https://github.com/trigunam/tostring-implementation/blob/master/src/main/java/io/github/trigunam/java/HelloToString.java):

```shell
Addresses = [Bangalore, Karnataka, India], Id = 1, Name = Triguna, Now = 2021-9-4 13:56:37.967, 
Time taken to use toString method = 0.019 ms
```

## Pattern

Given a class name and instance, the project will use the reflection from Java to fetch the getter methods for the given instance and execute it to print the `methodName = methodValue` in an appended string with comma-separated values.

This is a very generic implementation so anybody can use this code to write their toString implementation. The idea is to avoid implementing toString by writing your own implementation every time.

Please put your thoughts on the implementation so we can evolve as a project which will help every Java Developer.

## Reviews from various stakeholders

Refer to [Reviews from various stakeholders](docs/reviews.md)

## Usage Guide in detail

Refer to [Usage Guide](docs/usage-guide.md) for more details on the usage.