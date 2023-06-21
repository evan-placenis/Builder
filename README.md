# Builder

The Builder design pattern is useful when:
- The algorithm for creating a complex object should be independent of the parts that make up the object and how they're assembled.
- The construction process must allow different representations for the object that's constructed

The client creates the Director object and configures it with the desired Builder object. Director notifies the builder for a specific product to construct and the builder handles the request. The client retrives the product from the builder.

**Benefits:**
- Lets you vary a product's internal representation
- It isolates code for construction and representation (improves modularity)
- It gives you finer control over the construction process

# Maze - Builder Example

This program utilizes the builder pattern to construct a maze consisting of rooms, walls and doors of a hypothetical game. These actions are shows by printing messages to the console. The program contains both a concrete mazebuilder and a concrete mazecounter to demonstrate the flexibility and control the individual builders have. While one builder is responsible for building the maze itself, the other builder counts the number of rooms and doors in the maze.

![image](https://github.com/evan-placenis/Builder/assets/112578037/c3b29ceb-f58c-4431-81c1-c2cfc5a5e695)
