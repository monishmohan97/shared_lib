package co.vinod

/**
 * Helper class providing utility methods for Jenkins shared library
 */
class Helper implements Serializable {
    def steps
    
    Helper(steps) {
        this.steps = steps
    }
    
    /**
     * Executes a closure with a timeout
     * @param timeout Timeout in minutes
     * @param closure The closure to execute
     */
    def executeWithTimeout(int timeout, Closure closure) {
        steps.timeout(time: timeout, unit: 'MINUTES') {
            closure()
        }
    }
    
    /**
     * Validates required parameters
     * @param params Map of parameters to validate
     * @param required List of required parameter names
     * @throws IllegalArgumentException if any required parameter is missing
     */
    def validateParams(Map params, List required) {
        def missing = required.findAll { !params.containsKey(it) }
        if (missing) {
            throw new IllegalArgumentException("Missing required parameters: ${missing.join(', ')}")
        }
    }
    
    /**
     * Logs a message with timestamp
     * @param message Message to log
     */
    def logWithTimestamp(String message) {
        def timestamp = new Date().format("yyyy-MM-dd HH:mm:ss")
        steps.echo "[${timestamp}] ${message}"
    }
} 