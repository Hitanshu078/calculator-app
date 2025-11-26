pipeline {
    agent any

    environment {
        IMAGE = "hitanshu078/calculator-app:latest"
        VENV = ".venv"
        PYTHON = "python" 
    }

    stages {

                stage('Checkout') {
                        steps {
                                checkout([$class: 'GitSCM',
                                    branches: [[name: '*/main']],
                                    userRemoteConfigs: [[
                                        url: 'https://github.com/Hitanshu078/calculator-app',
                                        credentialsId: 'gitcreds'
                                    ]]
                                ])
                        }
                }

        stage('Create Virtual Environment') {
            steps {
                bat 'python -m venv %VENV%'
                bat '%VENV%/Scripts/pip install --upgrade pip'
            }
        }

        stage('Install Dependencies') {
            steps {
                bat '%VENV%/Scripts/pip install -r requirements.txt'
            }
        }

        stage('Run Tests') {
            steps {
                bat '%VENV%/Scripts/pytest -v'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t %IMAGE% .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                                                  usernameVariable: 'USER',
                                                  passwordVariable: 'PASS')]) {
                    bat 'echo %PASS% | docker login -u %USER% --password-stdin'
                    bat 'docker push %IMAGE%'
                }
            }
        }

        stage('Deploy Container') {
            steps {
                bat 'docker pull %IMAGE%'
                bat 'docker stop ci-cd-demo || exit 0'
                bat 'docker rm ci-cd-demo || exit 0'
                bat 'docker run -d -p 5000:5000 --name ci-cd-demo %IMAGE%'
            }
        }
    }
}