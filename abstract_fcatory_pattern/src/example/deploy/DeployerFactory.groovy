package org.example.deploy
 
/**
* Factory class to create appropriate Deployer based on platform.
* Demonstrates Abstract Factory pattern usage.
*/
class DeployerFactory {
 
    /**
     * Create deployer instance based on platform string.
     * @param platform String deployment platform: "k8s", "ecs"
     * @param serviceName String service to deploy
     * @return AbstractDeployer subclass instance
     */
    static AbstractDeployer getDeployer(String platform, String serviceName) {
        switch(platform.toLowerCase()) {
            case "k8s":
            case "kubernetes":
                return new KubernetesDeployer(serviceName)
            case "ecs":
                return new ECSDeployer(serviceName)
            default:
                throw new IllegalArgumentException("Unsupported platform: ${platform}")
        }
    }
}
