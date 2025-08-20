/**
* deploy.groovy
* Jenkins shared library vars step for deployment logic.
* Uses abstract factory pattern and closures for modularity.
* Includes looping, exception handling, parallel deployment.
*/
 
import org.example.deploy.DeployerFactory
 
def call(Map params = [:]) {
    String platform = params.platform ?: error("Platform must be provided")
    List<String> services = params.services ?: error("Services list must be provided")
 
    // Closure for deploying a single service
    Closure deployService = { String serviceName ->
        def deployer = DeployerFactory.getDeployer(platform, serviceName)
        deployer.deploy()
    }
 
    // Looping over services to deploy sequentially
    for (String svc : services) {
        try {
            deployService(svc)
        } catch (Exception e) {
            echo "Deployment failed for service ${svc}: ${e.message}"
            error("Stopping pipeline due to deployment failure.")
        }
    }
}
 
/**
* Parallel deploy method - deploy all services in parallel.
* Demonstrates best practice of creating map of closures for parallel.
*/
def deployParallel(Map params = [:]) {
    String platform = params.platform ?: error("Platform must be provided")
    List<String> services = params.services ?: error("Services list must be provided")
 
    Map<String, Closure> parallelBranches = [:]
 
    // Prepare parallel closures with good comments
    services.each { svc ->
        parallelBranches[svc] = {
            try {
                def deployer = DeployerFactory.getDeployer(platform, svc)
                deployer.deploy()
            } catch (Exception e) {
                echo "Error deploying ${svc} in parallel: ${e.message}"
                throw e
            }
        }
    }
 
    // Run parallel deployment
    parallel parallelBranches
}
