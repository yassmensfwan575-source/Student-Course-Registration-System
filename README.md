# Student Course Registration System

A Java-based Student Course Registration System that simulates university course enrollment, waiting lists, and student registration management.

## Features

- View all students in the system.
- View all available courses.
- Register students in courses.
- Automatic validation of:
  - Student IDs
  - Course IDs
  - Maximum course load
  - Maximum credit hours
  - Course capacity
- Waiting list support for full courses.
- Remove student registrations.
- Automatic enrollment from waiting list when a seat becomes available.
- Display student registration statistics.
- Display course registration statistics.
- Track waiting list information.

## Classes

### Course.java
Represents a university course and stores:

- Course name
- Course ID
- Credit hours
- Maximum class size
- Current enrollment
- Waiting list count

### Student.java
Represents a student and stores:

- Student name
- Student ID
- Academic standing
- Registered courses
- Total registered credit hours

### Registration.java
Represents the relationship between a student and a course.

### StudentCourseRegistration.java
Core system class responsible for:

- Student management
- Course management
- Registration processing
- Waiting list processing
- Validation rules

### SimulateSystem.java
Console-based user interface used to interact with the system.

## Academic Rules Implemented

### Course Limits

Regular students:

- Maximum 7 courses
- Maximum 42 credit hours

Senior students:

- Maximum 8 courses
- Maximum 50.4 credit hours
  (20% overload allowed)

### Waiting List

If a course is full:

1. Student is added to the waiting list.
2. When a registered student drops the course:
   - First eligible student from the waiting list is automatically registered.

## UML Diagram

The project includes a UML class diagram:

`UML_Digram.jpg`

which illustrates the relationships between all system classes.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList Collections
- Console-based Interface

## Author

Developed as a university Object-Oriented Programming project.
