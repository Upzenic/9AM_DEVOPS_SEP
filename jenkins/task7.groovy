pipeline {
    agent any
    stages {
        stage('Stage 1') {
            steps {
                script {
                    try {
                        error("Stage 1 failed!")
                    } catch (e) {
                        echo "Error caught, moving on..."
                    }
                }
            }
        }
        stage('Stage 2') {
            steps {
                echo "Stage 2 is running!"
            }
        }
    }
}
