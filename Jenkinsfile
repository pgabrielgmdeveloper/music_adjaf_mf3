pipeline {
    agent any

    stages {
        stage('Add Env') {
            steps {
                script {
                    // Definir variáveis de ambiente
                    def dbHost = credentials('db_host')
                    def dbUsername = credentials('db_user')
                    def dbPassword = credentials('db_password')
                    def accessKey = credentials('access_key')
                    def secretKey = credentials('secret_key')
                    def bucketName = credentials('bucket_name')
                    def publicKey = credentials('pub_key')
                    def privateKey = credentials('priv_key')

                    // Adicionar variáveis de ambiente ao .bashrc
                    sh "echo \"export DATABASE_HOST='${dbHost}'\" >> ~/.bashrc"
                    sh "echo \"export DATABASE_USER_NAME='${dbUsername}'\" >> ~/.bashrc"
                    sh "echo \"export DATABASE_PASSWORD='${dbPassword}'\" >> ~/.bashrc"
                    sh "echo \"export ACCESS_KEY='${accessKey}'\" >> ~/.bashrc"
                    sh "echo \"export SECRET_KEY='${secretKey}'\" >> ~/.bashrc"
                    sh "echo \"export BUCKET_NAME='${bucketName}'\" >> ~/.bashrc"
                    sh "echo \"export PUB_KEY='${publicKey}'\" >> ~/.bashrc"
                    sh "echo \"export PRIVATE_KEY='${privateKey}'\" >> ~/.bashrc"
                    sh 'source ~/.bashrc'
                }
            }
        }

        stage('Build project') {
            steps {
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
