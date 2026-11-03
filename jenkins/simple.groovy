pipeline{
    agent {
        lable 'Node1'
    }
    stages{
        stage('build_stage'){
            steps{
                sh '''
                    echo "Build stage is completed"
                ''''
            }
        }
        stage('test_env'){
            steps{
                sh '''
                    echo "Testing environment is completed with sanity"
                '''
            }
        }
        stage('app_deploy'){
            steps{
                sh '''
                    echo "App Deployed successfully."
                '''
            }
        }
    }
}
