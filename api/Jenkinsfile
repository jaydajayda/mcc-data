node {
    stage('Git Checkout'){
        git branch: 'main', url: 'https://github.com/jaydajayda/mcc-data.git'
    }
    
    stage('Gradle build'){
        sh 'gradle build'
    }
    
}