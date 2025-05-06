# Jenkins Shared Library

This repository contains a Jenkins shared library that provides reusable pipeline components and utilities.

## Structure

```
├── vars/                    # Global variables/functions
│   └── myLibraryFunction.groovy
├── src/                     # Source code
│   └── co/
│       └── vinod/
│           └── Helper.groovy
└── README.md
```

## Usage

### In Jenkinsfile

```groovy
@Library('jenkins-shared-libraries') _

pipeline {
    agent any

    stages {
        stage('Example') {
            steps {
                // Call the shared library function
                myLibraryFunction(
                    name: 'my-project',
                    timeout: 60,
                    verbose: true
                )
            }
        }
    }
}
```

### Available Functions

#### myLibraryFunction

A reusable pipeline function that provides common build and test stages.

Parameters:

- `name` (String, optional): Project name (default: 'default')
- `timeout` (Integer, optional): Timeout in minutes (default: 30)
- `verbose` (Boolean, optional): Enable verbose logging (default: false)

## Development

### Prerequisites

- Jenkins instance
- Groovy knowledge
- Git

### Local Development

1. Clone this repository
2. Make your changes
3. Test locally using Jenkins Pipeline Unit Testing Framework
4. Commit and push your changes

### Testing

To test the shared library locally:

```groovy
@Library('jenkins-shared-libraries@local') _
```

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Submit a pull request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
