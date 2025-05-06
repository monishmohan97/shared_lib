#!/usr/bin/env groovy

/**
 * Example shared library function that can be called from Jenkins pipelines
 * @param config Map of configuration parameters
 * @return void
 */
def call(Map config = [:]) {
    // Set default values
    def defaults = [
        name: 'default',
        timeout: 30,
        verbose: false
    ]
    
    // Merge defaults with provided config
    config = defaults + config
    
    // Create helper instance
    // 'this' refers to the current script object which contains pipeline steps
    // It's passed to Helper to allow access to pipeline steps like 'echo', 'stage', etc
    def helper = new co.vinod.Helper(this)
    
    // Execute the main logic
    helper.executeWithTimeout(config.timeout) {
        echo "Executing myLibraryFunction with name: ${config.name}"
        
        if (config.verbose) {
            echo "Verbose mode enabled"
            // Add additional logging or steps here
        }
        
        // Example of using pipeline steps
        stage('Build') {
            echo "Building ${config.name}"
            // Add your build steps here
        }
        
        stage('Test') {
            echo "Testing ${config.name}"
            // Add your test steps here
        }
    }
} 