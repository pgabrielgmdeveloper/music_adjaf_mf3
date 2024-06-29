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
                    sh 'chmod +x ./gradlew'
                    sh './gradlew build'
                }
            }
        }

        script {
                    sh '''
                    java -jar -Ddatabase.host="${env.DATABASE_HOST}" -Ddatabase.user="${env.DATABASE_USER_NAME}" \
                    -Ddatabase.password="${env.DATABASE_PASSWORD}" -Daccess.key="${env.ACCESS_KEY}" \
                    -Dsecret.key="${env.SECRET_KEY}" -Dbucket.name="${env.BUCKET_NAME}" \
                    -Dpublic.key="${env.PUBLIC_KEY}" -Dprivate.key="${env.PRIVATE_KEY}" \
                    "build/libs/music_adjaf_mf3-0.0.1.jar"
                    '''
                }
    }
}
