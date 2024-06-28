pipeline {
    agent any

    stages {

        stage('Build project') {
            steps {
                script {
                    def dbHost = credentials('db_host')
                                                def dbUser = credentials('db_user')
                                                def dbPassword = credentials('db_password')
                                                def accessKey = credentials('access_key')
                                                def secretKey = credentials('secret_key')
                                                def bucketName = credentials('bucket_name')
                                                def pubKey = credentials('pub_key')
                                                def privKey = credentials('priv_key')

                                                sh "export DATABASE_HOST='${dbHost}'"
                                                sh "export DATABASE_USER_NAME='${dbUser}'"
                                                sh "export DATABASE_PASSWORD='${dbPassword}'"
                                                sh "export ACCESS_KEY='${accessKey}'"
                                                sh "export SECRET_KEY='${secretKey}'"
                                                sh "export BUCKET_NAME='${bucketName}'"
                                                sh "export PUBLIC_KEY='${pubKey}'"
                                                sh "export PRIVATE_KEY='${privKey}'"
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'
                }
            }
        }

        stage('Running Project'){
            steps{
                script {
                def dbHost = credentials('db_host')
                                            def dbUser = credentials('db_user')
                                            def dbPassword = credentials('db_password')
                                            def accessKey = credentials('access_key')
                                            def secretKey = credentials('secret_key')
                                            def bucketName = credentials('bucket_name')
                                            def pubKey = credentials('pub_key')
                                            def privKey = credentials('priv_key')

                                            sh "export DATABASE_HOST='${dbHost}'"
                                            sh "export DATABASE_USER_NAME='${dbUser}'"
                                            sh "export DATABASE_PASSWORD='${dbPassword}'"
                                            sh "export ACCESS_KEY='${accessKey}'"
                                            sh "export SECRET_KEY='${secretKey}'"
                                            sh "export BUCKET_NAME='${bucketName}'"
                                            sh "export PUBLIC_KEY='${pubKey}'"
                                            sh "export PRIVATE_KEY='${privKey}'"
                    sh 'java -jar "build/libs/music_adjaf_mf3-0.0.1.jar"'
                }
            }
        }
    }
}