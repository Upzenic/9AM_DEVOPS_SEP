pipeline {
    agent any

    stages {
        stage('Backup Jenkins') {
            steps {
                echo "Starting Jenkins server backup..."
                sh '''
                    # Define backup directory and timestamp
                    BACKUP_DIR="/tmp"
                    TIMESTAMP=$(date +%Y%m%d_%H%M%S)
                    BACKUP_NAME="jenkins_backup_$TIMESTAMP.tar.gz"

                    # Create backup directory without sudo
                    mkdir -p $BACKUP_DIR

                    # Create compressed archive without sudo
                    tar --exclude='jobs/*/builds' \
                        --exclude='workspace' \
                        --exclude='caches' \
                        -czf "$BACKUP_DIR/$BACKUP_NAME" \
                        -C /var/lib/jenkins .

                    echo "Backup created successfully at: $BACKUP_DIR/$BACKUP_NAME"

                    # Clean up backups older than 7 days
                    find $BACKUP_DIR -name "jenkins_backup_*.tar.gz" -mtime +7 -delete
                '''
            }
        }
    }
}
