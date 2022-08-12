pipeline {

    agent {
        kubernetes {
          defaultContainer 'jenkins-agent'
        }
    }

    environment {
        registry = "docker.io/s19004162/todomanager-backend"
        registryCredential = 's19004162'
        dockerImage = ""
    }

    stages {

        stage('コンテナレジストリへプッシュ') {

            environment {
                registryCredential = 's19004162'
            }

            steps{
               script {
                   appimage = docker.build registry + ":$BUILD_NUMBER"
                   docker.withRegistry( registry, registryCredential ) {
                       appimage.push()
                       appimage.push('latest')
                   }
               }
           }
        }
    }
}
