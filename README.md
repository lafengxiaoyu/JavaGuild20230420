# JavaGuild
this is the presentation code in JavaGuild20230420

## 1. What is Java Reflection

Java Reflection makes it possible to inspect classes, interfaces, fields and methods at runtime, without knowing the names of the classes, methods etc. at compile time.

It is also possible to instantiate new objects, invoke methods and get/set field values using reflection.


API:
- java.lang.Class
- java.lang.reflect.*

## 2. Why we need it?

Think about plugins. When we add a third-party plugin to our browser it just starts working. We don‘t need to rewrite any browser code. How does the browser know what the plugin is supposed to do?


The answer is: it asks. It uses the plugin name to load the plugin class. It uses dynamic instantiation to create an instance of the class. It uses introspection to find out what methods the class offers. It uses invocation to call these methods.

This inspection allows us to modify the behavior of these entities at runtime.

## 3. Class class
The class of all objects that represent classes is defined in the java.lang package. Naturally, the name of this class is Class

## 4. Advantages and Disadvantages of Using Java Reflection API
### 4.1 Advantages
- Extensibility Features: An application may make use of external, user-defined classes by creating instances of extensibility objects using their fully-qualified names.

- Debugging and testing tool

## 4.2 Disadvantages
- Performance Overhead:Reflective operations have slower performance than their non-reflective counterparts, and should be avoided in sections of code which are called frequently in performance-sensitive applications.
- Security Restrictions: Reflection requires a runtime permission which may not be present when running under a security manager. This is in an important consideration for code which has to run in a restricted security context, such as in an Applet.
- Exposure of Internals: Reflective code breaks abstractions and therefore may change behaviour with upgrades of the platform.
- Bad readability

## 5. Summary
### 5.1 Is reflection bad?
In a way, yes. First, we lose compile-time safety. Without compile-time safety, we might get run time errors that may affect end users. It will also be difficult to debug the error.

We mainly work on certain business logic in our daily work, so we know the object and methods.

But if we are working on developing frameworks, reflection is easily to be considered. 

## 5.2 tips
Reflection is a relatively advanced feature in Java but should be used by programmers having a stronghold on the language.

it might cause unexpected errors and results if not used with caution.

Although reflection is powerful, it should be used carefully. 

## References:
[0]http://www.cs.sjsu.edu/~pearce/modules/lectures/oop/types/reflection/reflection.htm

[1]https://www.oracle.com/technical-resources/articles/java/javareflection.html

[2]https://www.baeldung.com/java-reflection

[3]https://jenkov.com/tutorials/java-reflection/dynamic-proxies.html

[4]https://beknazarsuranchiyev.medium.com/reflection-annotations-the-powerful-combination-fc404142595b

[5]http://www.cs.sjsu.edu/~pearce/modules/lectures/oop/types/reflection/reflection.htm

[6]https://beknazarsuranchiyev.medium.com/reflection-annotations-the-powerful-combination-fc404142595b

[7]https://www.softwaretestinghelp.com/java/java-reflection/#Drawbacks_Of_Reflection
