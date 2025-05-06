#!/usr/bin/env groovy

/**
 * A simple function that prints a message to the console
 * @param message The message to print
 * @return void
 */
def call(String env) {
    stage("compile") {
        echo "compiling on ${env} environment"
    }
    
    stage("test") {
        echo "running tests on ${env} environment"
    }
    
    stage("jar") {
        echo "creating a jar file on ${env} environment"
    }
    
    stage("deploy") {
        echo "deploying on ${env} environment"
    }

} 