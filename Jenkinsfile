pipeline {
    agent any
    environment {
            approval = "true"
    }
stages {
stage('reading properties from properties file1') {
    steps {
        script {
	    def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
		}
	  }
   when {
                expression { props.PushDrContainers == true }
         }
    steps {
        // Use a script block to do custom scripting
        script {
            def props = readProperties file: 'extravars.properties'
            env.Username = props.Username
            env.PushDrContainers = props.PushDrContainers
               }
        echo "The username  is $Username"
        echo "The PushDrContainers value  is $PushDrContainers"
         }
                                                   }



      stage ('Printing environment variables'){
            steps {
 		     sh 'printenv'
		  }
			                      }
                         
    }
}
