pipeline {
    agent any
    environment {
            approval = "true"
	    def propss = readProperties file: 'extravars.properties'
//              env.PushDrContainers = propss.PushDrContainers
//            env.Username = propss.Username

    }
stages {

stage('reading properties from properties file1') {

   when {
                environment(name: "propss.PushDrContainers", value: "true")
         }
    steps {
        script {
		def props = readProperties file: 'extravars.properties'
	            env.PushDrContainers = props.PushDrContainers
        	    env.Username = props.Username
	        // Use a script block to do custom scripting
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
