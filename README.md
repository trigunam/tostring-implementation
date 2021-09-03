# TOSTRING IMPLEMENTATION

[![Maven build status](https://github.com/trigunam/tostring-implementation/actions/workflows/test.yml/badge.svg)](https://github.com/trigunam/tostring-implementation/actions/workflows/test.yml)
[![Contributions welcome](https://img.shields.io/badge/contributions-welcome-brightgreen)](CONTRIBUTING.md)

This project is a library for any POJO class to implement a toString method. Given a class name and instance, the project will use the reflection from Java API to get the getter methods for the given instance and execute it to print the methodName = methodValue in an appended string with comma-separated values. This is a very generic implementation so anybody can use this code to write their toString implementation. The idea is to avoid implementing toString by writing your own implementation every time.

Please put your thoughts on the implementation so we can evolve as a project which will help every Java Developer.

## Review comments on this project

This section helps analyze the review comments posted by many developers, who have directly or indirectly contributed to this project. These review comments will be part of the project as future releases. In a way this is the project roadmap.

### Review comments on 07th of Sep 2012

  * Support regex for method name filtering.
  * Support attribute filtering as in filter member variables
  * Any other filtering?

### Review comments on 10th of Sep 2012

  * Mention the limitations of the project. Some of them include: The library works only if getters and setters are generated for a POJO class. No need to pass instance and class, we can get class from the instance itself.
  * The output contains getId = 1, getName = "Triguna", can it be like Id = 1, Name = "Triguna"?
  * Anything else?

### Review comments on 22nd of Feb 2013

  * Calendar object prints unnecessary information. Can we change it to print only what is required?

## User Guide

As described in [User Guide](UserGuide.md)