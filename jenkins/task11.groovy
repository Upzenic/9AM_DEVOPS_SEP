pipeline {
    // Try running on node1 first
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
        // If node1 fails or goes offline, retry/fallback to node2
        failure {
            node('node2') {
                stage('Fallback Stage') {
                    echo "node1 failed or offline. Running fallback task on node2..."
                    sh 'hostname'
                }
            }
        }
    }
}
