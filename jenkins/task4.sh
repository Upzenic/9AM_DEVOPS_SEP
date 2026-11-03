pipeline {
    agent any
    stages {
        stage('Ask Input') {
            steps {
                // This pauses the pipeline and opens a prompt box
                    userValue = input message: 'Enter your deployment name:', parameters: [
                    string(name: 'MY_INPUT', defaultValue: 'test-release', description: 'Type anything here')
                ]
                
                echo "You entered: ${userValue}"
            }
        }
    }
}
