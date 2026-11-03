pipeline {
    // By default, do not tie the whole pipeline to a single node
    agent none 
    
    stages {
        stage('Task on Node 1') {
            agent { label 'node1' }
            steps {
                echo "Running build tasks on node1..."
                sh 'hostname'
            }
        }
        
        stage('Task on Node 2') {
            agent { label 'node2' }
            steps {
                echo "Running deployment tasks on node2..."
                sh 'hostname'
            }
        }
    }
}
