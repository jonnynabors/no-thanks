pipeline {
    agent any

    stages {

        stage('Check') {
          steps {
                sh './gradlew check'
          }
        }

        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
}