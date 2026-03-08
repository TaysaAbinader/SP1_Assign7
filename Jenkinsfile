pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/TaysaAbinader/SP1_Assign7.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Docker Up') {
            steps {
                sh 'docker-compose up -d --build'
            }
        }
        stage('Smoke Test') {
            steps {
                sh 'sleep 10 && docker ps'
            }
        }
    }
}
