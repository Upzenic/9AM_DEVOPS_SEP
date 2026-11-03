pipeline {
    agent any
    stages {
        stage('Debug Stage') {
            steps {
                // 'set -x' prints every command to the console as it runs
                sh 'set -x; echo "Debugging is active!"'
            }
        }
    }
}
