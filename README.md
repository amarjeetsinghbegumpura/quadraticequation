# quadraticequation
Solve a Quadratic Equation using SpringBoot
Requirements
----------------
It is necessary to implement a component for solving quadratic equations.

In addition to a standard API the solution should provide an "integration" text-based interface, e.g. used in a HTTP-based service or by a component implementing file-based exchange.

That interface should accept a string as input and produce a string. The format of the input and output is defined by the component's developer. The input and output format should be machine-parsable.
The solution should come with corresponding test coverage.

The solution should be built in Java 8+ using Spring Boot. The reviewers will look for:

Best coding practices (unit tests…)
Exception handling / input validation
Patterns, optimal use of Spring Boot construct and use of relevant third-party libraries (i.e. use of Jackson for JSON output)
