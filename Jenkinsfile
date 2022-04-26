pipeline {
    agent any
    environment {
            approval = "true"
    }
stages {

stage('reading properties from properties file1') {
    steps {
	    def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
   when {
                expression { PushDrContainers == true }
         }
        script {
        // Use a script block to do custom scripting
	    def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
            env.Username = props.Username
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
