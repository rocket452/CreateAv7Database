# CreateAv7Database

One-line: A Java-based tool to create and manage the AV7 database project.

---

## Table of Contents

1. [Overview](#overview)  
2. [Features](#features)  
3. [Tech Stack](#tech-stack)  
4. [Getting Started](#getting-started)  
   - Prerequisites  
   - Installation  
   - Usage  
5. [Project Structure](#project-structure)  
6. [Future Improvements](#future-improvements)  
7. [Contributing](#contributing)  
8. [License](#license)

---

## Overview

This project provides utilities to generate, configure, and manage a database (named “AV7”) via Java. It includes a library for database operations, build scripts, and project settings designed to simplify database creation, initialization, and versioning.

---

## Features

- Create the AV7 database schema  
- Set up initial database files (e.g. `mydb`, `mydb2`)  
- Manage build with Gradle (wrapper included)  
- Basic configuration support  

---

## Tech Stack

- **Language:** Java  
- **Build:** Gradle  
- **Library:** `createdatabaselib` (custom module)  
- **Structure:** Multi-module project (library + app)  

---

## Getting Started

### Prerequisites

- Java JDK (version ? — e.g. 11 or 17)  
- Gradle (wrapper included, but local Gradle installation helps)  
- Operating System: Any with Java + filesystem access  

### Installation

1. Clone the repo  
   ```bash
   git clone https://github.com/rocket452/CreateAv7Database.git
   cd CreateAv7Database
