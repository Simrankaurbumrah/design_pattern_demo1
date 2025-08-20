/**
* utils.groovy
* Helper utilities used across library.
*/
 
def printHello() {
    echo "Hello from utils"
}
 
def getTimestamp() {
    return new Date().format("yyyy-MM-dd HH:mm:ss")
}
