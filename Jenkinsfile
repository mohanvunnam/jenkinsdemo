pipeline {
    agent any
//    options {
//        ansiColor('xterm')
//    }
    environment {
        
            approval = "true"
        
    }
    stages {
	stage('init') 
		{
		steps{
		echo "Loading paramerts groovy file.........."
			script{
			   tfparam = load "paramvar.groovy"
			      }
		     }
		}
        stage ('pull images'){
            when {
		tfparam.PushDrContainers()
                expression { PushDrContainers == true }
            }
            steps {
                script {
			 tfparam.api_imagetag()	     
			 tfparam.sso_imagetag()	     
			 tfparam.iav_imagetag()	     
			 tfparam.ontrac_imagetag()	     
			 tfparam.ebill_imagetag()	     
               		 echo "api_imagetag value is ${api_imagetag}"
                    	 echo "sso_imagetag value is ${sso_imagetag}"
	                 echo "iav_imagetag value is ${iav_imagetag}"
			 echo "ontrac_imagetag value is ${ontrac_imagetag}"
	                 echo "ebill_imagetag value is ${ebill_imagetag}"
         	         echo "recipient_imagetag value is ${recipient_imagetag}"
                }
            }
        }
            post {
                aborted {
                    echo "Aborting terraform apply"
                    sh '''
                        echo "env0 cancel environmentName infrastructure-${environment}"
                    '''
                }
                success {
                    echo "Run when only success"
                    sh '''
                        crumb=$(curl -u "jenkins:test@3214" -s 'http://192.168.56.102:8080/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)')

echo "crumb value is $crumb"

			#curl -u "jenkins:test@3214" -H "$crumb" -X POST http://192.168.56.102:8080/job/remotetrigger/build?delay=0sec
			curl -u "jenkins:test@3214" -H "$crumb" -X POST http://192.168.56.102:8080/job/remotetrigger/buildWithParameters
			#curl -u "jenkins:test@3214" -H "$crumb" -X POST "http://192.168.56.102:8080/job/remotetrigger/buildWithParameters?myname=$myname1&envi=$envi1"
                    '''
                }
            }
        }
        
        
    }
}
