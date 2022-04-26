pipeline {
    agent any
//    options {
//        ansiColor('xterm')
//    }
    environment {
            approval = "true"
    }
 parameters {
        booleanParam(name: 'PushDrContainers', defaultValue: true, description: 'PushDrContainers execute only if true')
        choice(name: 'environment', choices: ['prod', 'dr'], description: 'on which environment to execute')
        choice(name: 'update_api', choices: ['yes', 'no'], description: 'on which update_api to execute')
        choice(name: 'update_ebill', choices: ['yes', 'no'], description: 'on which update_ebill to execute')
        choice(name: 'update_iav', choices: ['yes', 'no'], description: 'on which update_iav to execute')
        choice(name: 'update_ontrac', choices: ['yes', 'no'], description: 'on which update_ontrac to execute')
        choice(name: 'update_recipient', choices: ['yes', 'no'], description: 'on which update_recipient to execute')
        choice(name: 'update_sso', choices: ['yes', 'no'], description: 'on which update_sso to execute')
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
                expression { params.PushDrContainers == true }
            }
            steps {
                script {
			 tfparam.api_imagetag()	     
			 tfparam.sso_imagetag()	     
			 tfparam.iav_imagetag()	     
			 tfparam.ontrac_imagetag()	     
			 tfparam.ebill_imagetag()	     
			 tfparam.recipient_imagetag()	     
               		 echo "api_imagetag value is ${api_imagetag}"
                    	 echo "sso_imagetag value is ${sso_imagetag}"
	                 echo "iav_imagetag value is ${iav_imagetag}"
			 echo "ontrac_imagetag value is ${ontrac_imagetag}"
	                 echo "ebill_imagetag value is ${ebill_imagetag}"
         	         echo "recipient_imagetag value is ${recipient_imagetag}"
                }
            }
        }


        stage ('update ec2 counts'){
            steps {
                script {
                                tfparam.nbr_api_ec2()
                                tfparam.nbr_ui_ec2()
	                         echo "nbr_api_ec2 value is ${nbr_api_ec2}"
	                         echo "nbr_ui_ec2 value is ${nbr_ui_ec2}"
	                         echo "environment value is params.environment"

                    sh '''
                        for environment in 'params.environment';
                        do
                          echo "environment {environment} value is 'params.environment' and nbr_api_ec2 value is ${nbr_api_ec2}"
                          echo "environment {environment} value is 'params.environment' and nbr_ui_ec2 value is ${nbr_ui_ec2}"
                        done
                    '''
                }
            }
        }





        
    }
}
