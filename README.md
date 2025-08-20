#abstract_factory_pattern

#Folder Structure
Folder Structure (Best Practice)
jenkins-shared-library/
├── vars/                      # Scripted steps callable in Jenkinsfiles
│   ├── deploy.groovy          # Deployment main functions & loops
│   ├── utils.groovy           # Utility helper functions
│   └── notifications.groovy   # Notification helpers
├── src/                       # Groovy classes for logic & patterns
│   └── org/
│       └── example/
│           └── deploy/
│               ├── AbstractDeployer.groovy
│               ├── KubernetesDeployer.groovy
│               ├── ECSDeployer.groovy
│               └── DeployerFactory.groovy
├── config/
│   └── codenarc/
│       └── codenarc-rules.groovy   # CodeNarc config file
└── Jenkinsfile                     # Optional pipeline for testing library
