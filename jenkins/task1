@NonCPS
def getNodes() {
    jenkins.model.Jenkins.get().computers.findAll { it.online }.collect { it.name ?: 'built-in' }
}

pipeline {
    agent none
    stages {
        stage('Server details') {
            steps {
                script {
                    for (n in getNodes()) {
                        node(n) {
                            echo "===== ${n == 'built-in' ? 'MASTER' : 'SLAVE'}: ${n} ====="
                            sh 'hostname; hostname -I; uname -sr; nproc; free -h; df -h /'
                        }
                    }
                }
            }
        }
    }
}
