Sample for Aspose
==

Pros & Cons review
---

Pros
------

Onion architecture was applied. (Controller, Service, Repository layers)
This gives:
- Fast problem localization, error search
- Convenience of extension and maintenance of code
- Ease of reading code and perception makes it possible to transfer code to another developer.
- There was a use of the Lombok library, which simplifies writing and reading code.

Cons
------
- It was not possible to configure multi-modularity with the help of a gread, which does not allow reusing the common code on the client server and other projects

- Do not apply the CQRS pattern, which allows you to extend the code with less coupling between elements
