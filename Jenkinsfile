pipeline {

    agent {
        kubernetes {
          defaultContainer 'jenkins-agent'
        }
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'main', name: 'BRANCH', type: 'PT_BRANCH'
    }

    environment {
        registry = "docker.io/s19004162/todomanager-backend"
        dockerImage = ""
    }

    stages {
        stage('GiHubからソースコードのクローン') {
            steps {
                git branch: "${params.BRANCH}", url: 'https://github.com/s19004162/ToDoManagerBackend.git'
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
                    docker.withRegistry("https://index.docker.io/v1/","dockerhub") {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
