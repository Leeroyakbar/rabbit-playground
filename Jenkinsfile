pipeline {
    agent {
        // Kita suruh Jenkins pinjam container Maven untuk melakukan build
        docker {
            image 'maven:3.8.5-openjdk-17'
            // Agar file hasil build tersimpan di folder Jenkins
            args '-v $HOME/.m2:/var/maven/.m2'
        }
    }

    stages {
        stage('Checkout SCM') {
            steps {
                checkout scm
                echo 'Kode berhasil diambil!'
            }
        }

        stage('Code Build') {
            steps {
                echo 'Sedang mengompilasi kode Java...'
                // Perintah asli Maven untuk membuat file .jar
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Build Docker') {
            steps {
                echo 'Langkah ini akan kita isi setelah Build berhasil...'
            }
        }
    }
}