pipeline {

    // 前提条件 Jenkinsサーバーにdocker, kubectl コマンドが導入されていること
    //
    environment {
        registry = "docker.io/s19004162/todomanager-backend"
        dockerImage = ""
        KUBECONFIG = credentials('kubeconfig')
    }

    agent { docker { image 'maven:3.8.4-openjdk-11-slim' } }
    stages {
        stage('GiHubからソースコードのクローン') {
            steps {
                git 'https://github.com/s19004162/ToDoManagerBackend.git'
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
