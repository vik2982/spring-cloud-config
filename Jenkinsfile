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
        stage('Upload docker image'){
            steps{
                script{
                    //Need to create credentials with docker login
                    withCredentials([string(credentialsId: 'docker-login', variable: 'dockerhubpwd')]) {
                       sh 'docker login -u vikrantardhawa -p ${dockerhubpwd}'
                       sh 'docker push vikrantardhawa/footie-app:1.0'
                    }
                }
            }
        }
    }   
}