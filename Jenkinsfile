pipeline {
    agent any

    stages {
        stage('Build project') {
            steps {
                echo "Iniciando pipeline"
                script {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'
                }
            }
        }

        stage('Running Project') {
            steps {
                script {
                    sh 'java -jar "build/libs/music_adjaf_mf3-0.0.1.jar"'
                }
            }
        }
    }
}
