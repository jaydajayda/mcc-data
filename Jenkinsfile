node {
    stage ("Git Checkout"){
        git branch: 'main', url: ' https://github.com/foxwas/sept26-bah-mcc-data.git'
    }
    
    stage ("Gradle Build") {
        sh 'gradle clean build'
    }
    
    stage ("Gradle bootJar-Package") {
        sh 'gradle bootjar'
    }

    stage ("Clean-up Pre-existing Resources") {
	sh 'docker container stop $(docker container list -q)'
	sh 'docker container prune -f'
    	sh 'docker rmi -f $(docker images -f "dangling=true" -q)'
    }
    
    stage ("Containerize the app-docker build") {
        sh 'docker build --rm -t mccdata:v1.0 .'
    }
    
    stage ("Inspect the docker image"){
        sh "docker images mccdata:v1.0"
        sh "docker inspect mccdata:v1.0"
    }
    
    stage ("Run Docker container instance"){
        sh "docker run -d --rm --name mccdata -p 8080:8080 mccdata:v1.0"
     }
    
    stage("User Acceptance Test") {
	
	  def response = input message: 'Is this build good to go?',
	   parameters: [choice(choices: 'Yes\nNo', 
	   description: '', name: 'Pass')]
	
	  if(response=="Yes") {
	    stage('Deploy to Kubernetes cluster') {
	      sh "kubectl create deployment mccdata --image=mccdata:v1.0"
	      sh "kubectl expose deployment mccdata --type=LoadBalancer --port=8080"
	    }
	  }
    }

    stage("Production Deployment View"){
        sh "kubectl get all"
    }
  
}
