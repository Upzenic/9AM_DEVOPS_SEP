pipeline {
    agent none

    parameters {
        string(name: 'MY_INPUT', defaultValue: 'test-release', description: 'Lowercase letters, numbers, hyphens (3 to 30 characters)')
    }

    stages {
        stage('Validate Input') {
            steps {
                script {
                    if (!(params.MY_INPUT ==~ /^[a-z0-9-]{3,30}$/)) {
                        error('Invalid name: use 3 to 30 lowercase letters, numbers or hyphens')
                    }
                    echo "You entered: ${params.MY_INPUT}"
                }
            }
        }
    }
}
