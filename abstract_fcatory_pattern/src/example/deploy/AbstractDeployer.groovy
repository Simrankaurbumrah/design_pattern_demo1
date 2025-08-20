package org.example.deploy
 
/**
* Abstract class for deployment platforms.
* Use explicit typing and good structure to comply with CodeNarc.
* Avoid empty catch blocks.
*/
abstract class AbstractDeployer implements Serializable {
    String serviceName
 
    AbstractDeployer(String serviceName) {
        this.serviceName = serviceName
    }
 
    /**
     * Abstract deploy method to be implemented by subclasses.
     */
    abstract void deploy()
 
    /**
     * Shared helper - logs the deployment start.
     */
    void logStart() {
        println "Starting deployment for service: ${serviceName}"
    }
}
