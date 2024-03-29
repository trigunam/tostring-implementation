# Usage Guide

This project is an open source, easy to understand and easy to use library. The source is free to download through git checkout:
git checkout https://github.com/trigunam/tostring-implementation.git

The license to source code is from GNU GPLv3. Please find a quick [guide](http://www.gnu.org/licenses/quick-guide-gplv3.html) for the explanation on what this license means to this project.

Using this library is simple and straight forward as mentioned in the details below.

## Details

To use the project library, follow these simple steps:
- Download the library [here](https://s01.oss.sonatype.org/content/repositories/releases/io/github/trigunam/java/util/tostring-implementation)
- Add to your classpath of your project.
- Override toString in your POJO and replace return super.toString with return Utilities.toString(this).
- Thats it!

Please comment here if you are stuck anywhere while using this library.

## Using Maven Central

Now you can use [maven dependency from Maven Central](https://search.maven.org/artifact/io.github.trigunam.java.util/tostring-implementation) to manage artifactory in your repository.

[![Now in Maven Central](../videos/now-in-mvn-central.gif)](https://search.maven.org/artifact/io.github.trigunam.java.util/tostring-implementation)

Use the following dependency to use in your repository:
```xml
<dependency>
    <groupId>io.github.trigunam.java.util</groupId>
    <artifactId>tostring-implementation</artifactId>
    <version>2.2</version>
</dependency>
```

```java
import io.github.trigunam.java.util.Utilities;

@Override
public String toString() {
    return Utilities.toString(this);
}
```
