pipeline {
    agent any
    environment{
        export DATABASE_HOST=credentials('db_host')
        export DATABASE_USER_NAME = credentials('db_user')
        export DATABASE_PASSWORD = credentials('db_password')
        export ACCESS_KEY = credentials('access_key')
        export SECRET_KEY = credentials('secret_key')
        export BUCKET_NAME = credentials('bucket_name')
        export PUBLIC_KEY = credentials('pub_key')
        export PRIVATE_KEY = credentials('priv_key')
    }
    stages {
        stage('Add Env') {
            sh '''
                                    echo 'export DATABASE_HOST="$DATABASE_HOST"' >> ~/.bashrc
                                    echo 'export DATABASE_USER_NAME="$DATABASE_USER_NAME"' >> ~/.bashrc
                                    echo 'export DATABASE_PASSWORD="$DATABASE_PASSWORD"' >> ~/.bashrc
                                    echo 'export ACCESS_KEY="$ACCESS_KEY"' >> ~/.bashrc
                                    echo 'export SECRET_KEY="$SECRET_KEY"' >> ~/.bashrc
                                    echo 'export BUCKET_NAME="$BUCKET_NAME"' >> ~/.bashrc
                                    echo 'export PUBLIC_KEY="$PUBLIC_KEY"' >> ~/.bashrc
                                    echo 'export PRIVATE_KEY="$PRIVATE_KEY"' >> ~/.bashrc
                                '''
        }
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
                    sh 'java -jar "build/libs/music_adjaf_mf3-0.0.1.jar"'
                }
            }
        }
    }
}