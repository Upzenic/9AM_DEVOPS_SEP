pipeline {
    agent any
    stages {
        stage('Error Handling') {
            steps {
                script {
                    try {
                        echo "Running task..."
                        error("Intentional failure!")
                    } catch (err) {
                        echo "Caught error: ${err.message}"
                    } finally {
                        echo "Cleanup tasks running..."
                    }
                }
            }
        }
    }
}
