# CreateAv7Database
A Java-based utility for processing and formatting biblical text data with support for HTML styling and database operations.

## Overview
CreateAv7Database is a specialized Java application designed to process and transform biblical text data into a structured database format. The project provides utilities for parsing, formatting, and storing biblical content with support for HTML styling elements and proper verse organization.

## Features
- **Text Processing**
  - Parses structured biblical text files
  - Handles book, chapter, and verse segmentation
  - Supports special character escaping
  - Processes formatting markers for enhanced display

- **Data Formatting**
  - HTML styling support for chapter titles and special text segments
  - Proper verse numbering and formatting
  - Support for superscript text elements
  - Custom span class implementations for styled text

- **Database Operations**
  - SQLJet database integration
  - Structured data storage with fields for:
    - Book
    - Chapter
    - Verse
    - Text content
  - Transaction management support

## Technical Stack
- **Language:** Java
- **Database:** SQLJet
- **Build System:** Gradle
- **File Processing:** Java I/O Streams
- **Text Processing:** Custom string manipulation utilities

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- Gradle build tool
- IDE with Java support (recommended)

### Installation
1. Clone the repository:
```bash
git clone https://github.com/rocket452/CreateAv7Database.git
```

2. Navigate to the project directory:
```bash
cd CreateAv7Database
```

3. Build the project using Gradle:
```bash
./gradlew build
```

## Usage
The application processes text files containing biblical content in the following format:
```
[Book]-[Chapter]:[Verse] [Text]
```

Example:
```
GN-1:1 In the beginning God created the heaven and the earth.
```

The program will:
1. Parse the input text
2. Apply necessary formatting
3. Generate a properly structured output file
4. (Optional) Store the data in a SQLJet database

## Project Structure
```
CreateAv7Database/
├── createdatabaselib/
│   └── src/
│       └── main/
│           └── java/
│               └── com/
│                   └── example/
│                       └── MyClass.java
├── app/
│   └── build/
├── gradle/
└── README.md
```

## Development

### Text Processing Features
- Apostrophe handling
- HTML tag insertion for chapter titles
- Special character processing
- Verse number formatting
- Custom span class implementation for styled text segments

### Database Operations
- Table creation and management
- Transaction handling
- Cursor-based record access
- Proper data escaping and formatting

## Future Improvements
- Add support for multiple Bible versions
- Implement batch processing for large files
- Add export functionality to different formats
- Improve error handling and logging
- Add unit tests for core functionality

## Contributing
Contributions are welcome! Please feel free to submit a Pull Request.

## License
This project is licensed under standard open-source terms. See the LICENSE file for details.

## Author
[rocket452](https://github.com/rocket452)

---
*Note: This project is part of a larger Bible application development effort. For related projects, see [AV7BibleAppv4](https://github.com/rocket452/AV7BibleAppv4).*
