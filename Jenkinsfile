pipeline {
    agent any
    environment {
            approval = "true"
    }
stages {

stage('reading properties from properties file1') {
    steps {
   when {
                expression { PushDrContainers == true }
         }
        script {
        // Use a script block to do custom scripting
        echo "The username  is $Username"
        echo "The PushDrContainers value  is $PushDrContainers"
	environment {
	def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
            env.Username = props.Username
        	    }
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
