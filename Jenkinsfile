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
                // 1. Ambil kembali file .jar yang sudah disimpan sebelumnya
                unstash 'app-jar'

                // 2. Jalankan orkestrasi menggunakan Docker Compose
                // --build memaksa Docker membangun ulang image jika ada perubahan file (seperti .jar baru)
                sh 'docker-compose up -d --build'
            }
        }
    }
}