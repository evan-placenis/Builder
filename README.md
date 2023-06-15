# Builder

The Builder design pattern is useful when:
- The algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
- The construction process must allow different representations for the object that's constructed

The client creates the Director object and configures it with the desired Builder object. Director notifies the builder for a specific product to construct and the builder handles the request. The client retrives the product from the builder.

**Benefits:**
- Lets you vary a product's internal representation
- It isolates code for construction and representation (improves modularity)
- It gives you finer control over the construction process
