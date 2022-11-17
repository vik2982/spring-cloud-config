pipeline {
    agent any

    tools {
        maven "3.8.6" // You need to add a maven with name "3.8.6" in the Global Tools Configuration page
    }
    
    stages {
        stage("init") {
            steps {
               echo 'init'
            }
        }
        stage("build") {
            steps {
               sh "mvn clean install"
            }
        }
        stage("test") {
            steps {
               echo 'test'
            }
        }
        stage("deploy") {
            steps {
               echo 'deploy'
            }
        }
    }   
}