pipeline {
    agent any

    stages {
        stage('Backup Jenkins') {
            steps {
                echo "Starting Jenkins server backup..."
                sh '''
                    # Define backup directory and timestamp
                    BACKUP_DIR="/var/lib/jenkins/backups"
                    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
                    BACKUP_NAME="jenkins_backup_$TIMESTAMP.tar.gz"

                    # Create backup directory if it doesn't exist
                    sudo mkdir -p $BACKUP_DIR

                    # Create compressed archive excluding builds and workspaces to save space
                    sudo tar --exclude='jobs/*/builds' \
                        --exclude='workspace' \
                        --exclude='caches' \
                        -czf "$BACKUP_DIR/$BACKUP_NAME" \
                        -C /var/lib/jenkins .

                    echo "Backup created successfully at: $BACKUP_DIR/$BACKUP_NAME"

                    # Optional: Clean up backups older than 7 days
                    sudo find $BACKUP_DIR -name "jenkins_backup_*.tar.gz" -mtime +7 -delete
                '''
            }
        }
    }
    post {
        success {
            echo 'Jenkins backup job completed successfully!'
        }
        failure {
            echo 'Jenkins backup job failed. Please check permissions or disk space.'
        }
    }
}
