pipeline {
    agent none // Prevents allocating an executor on the master/controller

    stages {
        stage('Stage 1: Build') {
            agent { label 'node1' }
            steps {
                echo "Running on node1..."
                sh 'echo "Building on node1: $(hostname)"'
            }
        }

        stage('Stage 2: Test') {
            agent { label 'node1' }
            steps {
                echo "Running on node1..."
                sh 'echo "Testing on node1: $(hostname)"'
            }
        }

        stage('Stage 3: Package') {
            agent { label 'node2' }
            steps {
                echo "Running on node2..."
                sh 'echo "Packaging on node2: $(hostname)"'
            }
        }

        stage('Stage 4: Deploy') {
            agent { label 'node2' }
            steps {
                echo "Running on node2..."
                sh 'echo "Deploying on node2: $(hostname)"'
            }
        }
    }
    post {
        success {
            echo 'Pipeline executed successfully across node1 and node2!'
        }
    }
}
