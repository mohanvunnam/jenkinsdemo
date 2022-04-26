pipeline {
    agent any
    environment {
            approval = "true"
    }
stages {

stage('reading properties from properties file1') {
    steps {
        script {
        // Use a script block to do custom scripting
	    def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
            env.Username = props.Username

   when {
                expression { props.PushDrContainers == true }
		
         }
        echo "The username  is $Username"
        echo "The PushDrContainers value  is $PushDrContainers"

               }
         }
                                                   }



      stage ('Printing environment variables'){
            steps {
 		     sh 'printenv'
		  }
			                      }
                         
    }
}
