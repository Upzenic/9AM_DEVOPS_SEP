pipeline {
    agent any

    stages {
        stage('Server Details') {
            steps {
                echo "=== SERVER & SYSTEM INFORMATION ==="
                sh '''
                    echo "Hostname: $(hostname)"
                    echo "Internal IP: $(hostname -I)"
                    echo "Operating System Version:"
                    cat /etc/os-release | grep PRETTY_NAME
                    echo "Java Version:"
                    java -version
                    echo "Disk Usage:"
                    df -h /
                '''
            }
        }
    }
}
