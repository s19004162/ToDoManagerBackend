pipeline {

    agent {
        kubernetes {
          defaultContainer 'jenkins-agent'
        }
    }

    environment {
        registry = "docker.io/s19004162/todomanager-backend"
        dockerImage = ""
    }

    stages {
        stage('GiHubからソースコードのクローン') {
            steps {
                git branch: env.BRANCH_NAME,
                    url: 'https://github.com/s19004162/ToDoManagerBackend.git'
            }
        }
        stage('コンテナイメージのビルド') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }
        stage('コンテナレジストリへプッシュ') {
            steps {
                script {
                    docker.withRegistry("https://hub.docker.com/repository/docker/s19004162/todomanager-backend) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
