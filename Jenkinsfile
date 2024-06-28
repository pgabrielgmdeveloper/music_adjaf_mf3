pipeline {
    agent any
    environment{
        DATABASE_HOST = credentials('db_host')
        DATABASE_USER_NAME = credentials('db_user')
        DATABASE_PASSWORD = credentials('db_password')
        ACCESS_KEY = credentials('access_key')
        SECRET_KEY = credentials('secret_key')
        BUCKET_NAME = credentials('bucket_name')
    }
    stages {
        stage('Build project') {
            steps {
                script {
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'
                }
            }
        }
        stage('Running Project'){
            steps{
                script {
                    sh 'java - jar "build/libs/music_adjaf_mf3-0.0.1.jar"'
                }
            }
        }
    }
}