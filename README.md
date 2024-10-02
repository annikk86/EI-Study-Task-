### Exercise 1: Exploring Design Patterns in Java
This section focuses on six use cases of software design patterns, categorized into Behavioral, Creational, and Structural patterns. Each use case is illustrated with a practical Java example to demonstrate their application.

1. Behavioral Design Patterns
1.1 Command Pattern: Home Automation Remote
File Name: CommandPatternExample.java

The Command Pattern encapsulates actions as command objects, which decouple the execution of an operation from the object invoking it. For instance, consider a home automation system with a remote control used to turn on/off devices like lights or fans, where each action is represented as a command.

1.2 Observer Pattern: Real-Time Stock Notifications
File Name: ObserverPatternExample.java

The Observer Pattern defines a one-to-many dependency, where multiple observers are notified whenever a change occurs in the subject. For example, users subscribing to stock price notifications get real-time updates whenever there is a fluctuation in stock prices.

2. Creational Design Patterns
2.1 Singleton Pattern: Configuration Manager
File Name: SingletonPatternExample.java

The Singleton Pattern ensures that a class has only one instance and provides a global point of access to that instance. For example, a configuration manager that maintains the application’s settings, ensuring that only one instance is created to prevent inconsistencies.

2.2 Factory Pattern: Electronics Factory
File Name: FactoryPatternExample.java

The Factory Pattern provides an interface for creating objects, but allows subclasses to determine which class to instantiate. For example, an electronics factory that can manufacture different types of gadgets like phones or laptops based on the provided input.

3. Structural Design Patterns
3.1 Adapter Pattern: Advanced Media Player
File Name: AdapterPatternExample.java

The Adapter Pattern enables classes with incompatible interfaces to work together by acting as an intermediary. For instance, a media player that supports playing MP3 files can be adapted to also support additional formats like MP4, using an adapter class.

3.2 Decorator Pattern: Custom Coffee Orders
File Name: DecoratorPatternExample.java

The Decorator Pattern allows behavior to be added to individual objects dynamically without affecting other objects of the same class. For instance, a coffee shop system where customers can customize their coffee by adding ingredients like milk or chocolate syrup without modifying the base coffee object.

### Exercise 2: Astronaut Task Management System
This section covers a console-based application designed to help astronauts manage and organize their daily schedules using design patterns, validation, and error handling techniques.

Key Features:
Add a Task: Create a new task by specifying the description, start time, end time, and priority.
Remove a Task: Delete a task from the schedule by task ID.
View All Tasks: Display all scheduled tasks sorted by their start time.
Avoid Task Overlap: Prevent scheduling conflicts by ensuring that new tasks do not overlap with existing tasks.
Mark Task as Completed: Update task status to indicate it has been completed.
View by Priority: Filter and view tasks based on their priority level.
Design Patterns Implemented:
Singleton Pattern:

Class: ScheduleManager
Manages all scheduling operations and ensures only one instance of the class is created, acting as the central point for managing tasks.
Factory Pattern:

Class: TaskFactory
Centralizes the creation of tasks, making it easy to extend and modify task creation logic in the future.
Observer Pattern:

Class: TaskConflictObserver
Observes and notifies the user if a newly added task overlaps with existing tasks in the schedule, ensuring proper scheduling without conflicts.
Sample Input and Output Scenarios
Adding a Task:
Task Added: Morning Exercise from 06:00 to 07:00, Priority: High.

Adding Another Task:
Task Added: Breakfast from 07:30 to 08:00, Priority: Medium.

Viewing All Tasks:
1. Morning Exercise - 06:00 to 07:00 - High
2. Breakfast - 07:30 to 08:00 - Medium

Adding Overlapping Task:
Error: Task overlaps with an existing task.

Removing a Task:
Task "Morning Exercise" removed successfully.

Marking a Task as Completed:
Task "Breakfast" marked as completed.

Conclusion
This project provides a comprehensive demonstration of how to utilize design patterns such as Singleton, Factory, and Observer in real-world applications. The Astronaut Task Management System showcases how these patterns can be employed to create a robust and well-organized console-based application for scheduling tasks while ensuring best practices are followed.
