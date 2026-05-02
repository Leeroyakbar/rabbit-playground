pipeline {
    agent none

    stages {
        stage('Checkout SCM') {
            agent any
            steps {
                checkout scm
                echo 'Kode berhasil diambil!'
            }
        }

        stage('Code Build') {
            agent {
                docker {
                    image 'maven:3.8.5-openjdk-17-slim'
                    args '-v $HOME/.m2:/var/maven/.m2'
                }
            }
            steps {
                echo 'Sedang mengompilasi kode Java...'
                // Perintah asli Maven untuk membuat file .jar
                sh 'mvn clean package -DskipTests'
                // simpan hasil agar bisa dipakai di stage selanjutnya
                stash name: 'app-jar', includes: 'target/*.jar'
            }
        }

        stage('Build Docker') {
            agent any
            steps {
                unstash 'app-jar'
                echo 'Sedang membuat Docker image...'
                sh 'docker build -t rabbit-app:latest .'
                echo 'Docker image berhasil dibuat!'
            }
        }
    }
}