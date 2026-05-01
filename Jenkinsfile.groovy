pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                echo 'Mengambil kode dari repository...'
            }
        }

        stage('Code Build') {
            steps {
                echo 'Menjalankan Maven Build...'
            }
        }

        stage('Build Docker') {
            steps {
                echo 'Membangun Docker Image...'
            }
        }
    }
}