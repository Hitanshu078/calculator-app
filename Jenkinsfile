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
                    docker.build("hitanshu078/calculator-app")
                }
            }
        }


        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    bat "docker login -u %USER% -p %PASS%"
                    bat "docker push hitanshu078/calculator-app:latest"
                }
            }
        }

    }
}
