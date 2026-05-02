pipeline {
    agent none

    stages {
        stage('Checkout SCM') {
            agent any
            steps {
                checkout scm
            }
        }

        stage('Code Build') {
            agent {
                docker {
                    image 'maven:3.8.5-openjdk-17'
                    args '-v $HOME/.m2:/var/maven/.m2'
                }
            }
            steps {
                sh 'mvn clean package -DskipTests'
                stash name: 'app-jar', includes: 'target/*.jar'
            }
        }

        stage('Build Docker') {
            agent any
            steps {
                unstash 'app-jar'
                sh 'docker build -t rabbit-app:latest .'
            }
        }

        stage('Deploy') {
            agent any
            steps {
                sh 'docker stop rabbit-app-container || true'
                sh 'docker rm rabbit-app-container || true'
                sh 'docker run -d --name rabbit-app-container -p 8081:8080 rabbit-app:latest'
            }
        }
    }
}