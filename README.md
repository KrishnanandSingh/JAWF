# EmployeeWebApp

Built up as an implementation of yet another web framework based on front controller pattern and reflection. 

---

## Working

`com.kn.processor` is the package where most of the magic happens. It defines two annotations `@RequestHandler` and `@URLMapping`.

```java
// a class should be annotated with this to declare that it wants to process web requests.
@RequestHandler

// methods annotated with this are forwarded the web requests defined by the urlPattern
@URLMapping(urlPattern="/getAllEmployees.do")
```

[FrontController](src/main/java/com/kn/controller/FrontController.java) serves as the entry point of the app. On its initialisation, it tells the annotation processor where web controllers are defined.

```java
String[] packages = new String[] { "com.kn.controller" };
HandlerFactory.initializeHandlers(getClass().getClassLoader(), packages);
```

[HandlerFactory](src/main/java/com/kn/processor/HandlerFactory.java) asks [AnnotationProcessor](src/main/java/com/kn/processor/AnnotationProcessor.java) to look for the classes annotated with `@RequestHandler` and gets the methods annotated with `@URLMapping`.
With the relevant method a [Handler](src/main/java/com/kn/processor/Handler.java) object is created with the object and the method reference. This Handler object is stored in a map with the urlParameter value as key. When [FrontController](src/main/java/com/kn/controller/FrontController.java) recieves a request it looks into this map for a handler to be present and passes the control.

Rest everything is related to the crud operations on an employee. The frontend is built using `AngularJS v1.5`.

---

## To run

- create database employee_sdet;
- mysql -uroot -pyourpassword employee_sdet < employee_sdet.sql;
- edit src/main/java/config.properties to change db password
