# CS110---CSC186-final-project-sem2-
from my perspective this is the subject where we learn how to build more structured code using Object Oriented Programming (OOP) in java

# E-Book Order Management System 

## Overview
This repository showcases an Object-Oriented Programming (OOP) project developed during my Semester 2 Computer Science coursework. Moving away from standard procedural coding, this console-based Java application is designed to handle e-book inventory and customer orders by focusing heavily on system architecture, modularity, and data mapping.

## The Big Picture (System Architecture)
Instead of stuffing everything into a single file, the logic is mapped out using strict OOP principles. Based on the system's UML class design, the architecture flows as follows:

* **Abstraction:** The core entity is an `<<abstract>>` class called `orderebook`. It serves as the blueprint for all orders but is never instantiated directly.
* **Inheritance:** Two specific sub-classes, `academicebook` and `fictionebook`, inherit from the abstract parent class, adding their own unique attributes (e.g., *Subject/Level* vs. *Genre/Author*).
* **Composition:** The `customer` class is kept as a separate, modular entity that interacts with the order system, ensuring customer data (ID, Name, Phone) isn't hardcoded directly into the book attributes.

## Core Features & Mechanics
* **Dynamic File I/O:** The system doesn't rely on volatile memory. It reads existing order data from an `input.txt` file using `BufferedReader` / `StringTokenizer` and saves updated states back via `PrintWriter`.
* **CRUD Operations:** Full capability to **C**reate new orders, **R**ead (display) existing ones, **U**pdate specific information based on object instances, and **D**elete/Overwrite.
* **Polymorphism in Action:** The `main` execution utilizes `instanceof` checks to dynamically identify whether an object in the `orderList` array is an Academic or Fiction e-book, generating accurate sales reports and rendering the correct update menus.

## Developer's Retrospective
This project was a major stepping stone in understanding how backend systems are structured in the real world. Visualizing the logic top-down (via UML) before writing the syntax made handling complex data flow—like calculating total prices across an array of polymorphic objects—significantly easier.
