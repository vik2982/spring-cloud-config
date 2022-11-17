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
        stage("build, unit test and bdd") {
            steps {
               sh "mvn clean install"
            }
        }
        stage("sonar") {
            steps {
               echo 'test'
            }
        }
         stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t footie-app:1.0 .'
                }
            }
        }
    }   
}