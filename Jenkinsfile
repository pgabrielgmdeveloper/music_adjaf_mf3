pipeline {
    agent any
    stages {


        stage('Build project') {
            environment {
                DATABASE_HOST = credentials('db_host')
                DATABASE_USER_NAME = credentials('db_user')
                DATABASE_PASSWORD = credentials('db_password')
                ACCESS_KEY = credentials('access_key')
                SECRET_KEY = credentials('secret_key')
                BUCKET_NAME = credentials('bucket_name')
                PUBLIC_KEY = credentials('pub_key')
                PRIVATE_KEY = credentials('priv_key')
            }
            steps {
                echo "Iniciando pipeline"
                script {
                    sh 'export DATABASE_HOST=$DATABASE_HOST >> ~/.bashrc'
                    sh 'export DATABASE_USER_NAME=$DATABASE_USER_NAME >> ~/.bashrc'
                    sh 'export DATABASE_PASSWORD=$DATABASE_PASSWORD >> ~/.bashrc'
                    sh 'export ACCESS_KEY=$ACCESS_KEY >> ~/.bashrc'
                    sh 'export SECRET_KEY=$SECRET_KEY >> ~/.bashrc'
                    sh 'export BUCKET_NAME=$BUCKET_NAME >> ~/.bashrc'
                    sh 'export PUBLIC_KEY=$PUBLIC_KEY >> ~/.bashrc'
                    sh 'export PRIVATE_KEY=$PRIVATE_KEY >> ~/.bashrc'
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
