pipeline {
    agent any
    
    // ADD THIS SECTION
    tools {
        // The name must match exactly what you entered in Step 1 (e.g., 'Maven3')
        maven 'Maven3' 
    }

    stages {
        stage('Clone Code') {
            steps {
                // Your git steps are already working fine
                git branch: 'main', url: 'https://github.com/Hitanshu078/calculator-app.git'
            }
        }
        stage('Build with Maven') {
            steps {
                // Now 'mvn' will work because the tool is loaded
                bat 'mvn clean package'
            }
        }

        stage('Run Tests') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("IMT2023100/calculatoś-app:latest")
                }
            }
        }

        stage('Pubat to DockerHub') {
            steps {
                script {
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-creds') {
                        dockerImage.pubat()
                    }
                }
            }
        }
    }
}
