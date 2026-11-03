pipeline {
    agent any
    stages {
        stage('Ask Input') {
            steps {
                script {
                    // Wrap input assignment inside a script block
                    def userValue = input message: 'Enter your deployment name:', parameters: [
                        string(name: 'MY_INPUT', defaultValue: 'test-release', description: 'Type anything here')
                    ]
                    
                    echo "You entered: ${userValue}"
                }
            }
        }
    }
}
