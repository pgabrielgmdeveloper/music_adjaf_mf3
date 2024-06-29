pipeline {
    agent any
    environment{
        DATABASE_HOST = credentials('db_host')
        DATABASE_USER_NAME = credentials('db_user')
        DATABASE_PASSWORD = credentials('db_password')
        ACCESS_KEY = credentials('access_key')
        SECRET_KEY = credentials('secret_key')
        BUCKET_NAME = credentials('bucket_name')
        PUBLIC_KEY = credentials('pub_key')
        PRIVATE_KEY = credentials('priv_key')
    }
    stages {
        stage('Build project') {

            steps {
                echo "Iniciando pipeline"
                script {
                sh 'export DATABASE_HOST=$DATABASE_HOST'
                                     sh 'export DATABASE_USER_NAME=$DATABASE_USER_NAME'
                                     sh 'export DATABASE_PASSWORD=$DATABASE_PASSWORD'
                                     sh 'export ACCESS_KEY=$ACCESS_KEY'
                                     sh 'export SECRET_KEY=$SECRET_KEY'
                                     sh 'export BUCKET_NAME=$BUCKET_NAME'
                                     sh 'export PUBLIC_KEY=$PUBLIC_KEY'
                                     sh 'export PRIVATE_KEY=...dsad'
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'

                }
            }
        }

        stage('Running Project') {
            steps {
                script {
                sh 'export DATABASE_HOST=$DATABASE_HOST'
                                     sh 'export DATABASE_USER_NAME=$DATABASE_USER_NAME'
                                     sh 'export DATABASE_PASSWORD=$DATABASE_PASSWORD'
                                     sh 'export ACCESS_KEY=$ACCESS_KEY'
                                     sh 'export SECRET_KEY=$SECRET_KEY'
                                     sh 'export BUCKET_NAME=$BUCKET_NAME'
                                     sh 'export PUBLIC_KEY=$PUBLIC_KEY'
                                     sh 'export PRIVATE_KEY=...dsad'
                    sh 'java -jar "build/libs/music_adjaf_mf3-0.0.1.jar"'
                }
            }
        }
    }
}
