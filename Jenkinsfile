def d = [
  'terraform.version':'1.0.0',
  'tfsec.version':'v0.57.1',
  'tflint.version':'v0.32.0'
]

def props = [:]

podTemplate {
  node(any) {
    checkout scm
    props = readProperties(defaults: d, file: 'extravars.properties')
  }
}

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
//	def props = readProperties file: 'extravars.properties'
            env.PushDrContainers = props.PushDrContainers
            env.Username = props.Username
        // Use a script block to do custom scripting
        echo "The username  is $Username"
        echo "The PushDrContainers value  is $PushDrContainers"
	environment {

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
