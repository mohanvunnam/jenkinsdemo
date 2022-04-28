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
	            env.Username = props.Username
	        // Use a script block to do custom scripting
	        echo "The username  is $Username"
	        echo "The PushDrContainers value  is $PushDrContainers"
		sh 'echo $PushDrContainers > myfile.txt'
	        PushDrContainers = readFile('myfile.txt').trim()

               }
         }
                                                   }
	stage('get var value from previous stage') {
           when {
                expression { PushDrContainers == true }
                }

	   steps {
		echo "executing my get var value from previous stage with var PushDrContainers value $PushDrContainers"
		 }
                                                   }
						

      stage ('Printing environment variables'){
            steps {
 		     sh 'printenv'
		  }
			                      }
 
                        
    }
}
