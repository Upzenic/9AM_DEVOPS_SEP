pipeline {
    agent none
    stages {
        stage('Ask Input') {
            steps {
                script {
                    def userValue
                    timeout(time: 2, unit: 'MINUTES') {
                        userValue = input message: 'Enter your deployment name:', parameters: [
                            string(name: 'MY_INPUT', defaultValue: 'test-release', description: 'Lowercase letters, numbers, hyphens')
                        ]
                    }
                    if (!(userValue ==~ /^[a-z0-9-]{3,30}$/)) {
                        error('Invalid name: use 3 to 30 lowercase letters, numbers or hyphens')
                    }
                    echo "You entered: ${userValue}"
                }
            }
        }
    }
}
