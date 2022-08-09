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

        stage('Set Container Name') {
              steps {
                    script {
                        CURRENT_CONTAINER=sh(script: 'kubectl get pods jenkins-0 -n jenkins -o jsonpath="{.items[*].spec.containers[0].name}"',
                                            returnStdout: true
                                            ).trim()
                        echo "Exec container ${CURRENT_CONTAINER}"
                    }
              }
        }

        stage('Echo Container Name') {
            steps {
                 echo "CURRENT_CONTAINER is ${CURRENT_CONTAINER}"
            }
        }


        stage('GiHubからソースコードのクローン') {
            steps {
                git branch: env.BRANCH_NAME,
                    url: 'https://github.com/s19004162/ToDoManagerBackend.git'
            }
        }
        stage('コンテナイメージのビルド') {
            steps {
                script {
                    dockerImage = docker.build(registry + ":$BUILD_NUMBER")
                }
            }
        }
        stage('コンテナレジストリへプッシュ') {
            steps {
                script {
                    docker.withRegistry("", registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
