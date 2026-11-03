pipeline {
    agent { label 'node1' }
    
    stages {
        stage('Task Stage') {
            steps {
                echo "Running on node1..."
                sh 'hostname'
            }
        }
    }
    
    post {
        failure {
            node('node2') {
                echo "node1 failed or offline. Running fallback task on node2..."
                sh 'hostname'
            }
        }
    }
}
