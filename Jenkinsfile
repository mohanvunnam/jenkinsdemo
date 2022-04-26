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
               		 echo "api_imagetag value is ${api_imagetag}"
                    	 echo "sso_imagetag value is ${sso_imagetag}"
	                 echo "iav_imagetag value is ${iav_imagetag}"
			 echo "ontrac_imagetag value is ${ontrac_imagetag}"
	                 echo "ebill_imagetag value is ${ebill_imagetag}"
         	         echo "recipient_imagetag value is ${recipient_imagetag}"
                }
            }
        }
        stage ('tag image'){
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
                        echo "api_imagetag value is ${api_imagetag}"
                        echo "sso_imagetag value is ${sso_imagetag}"
                        echo "iav_imagetag value is ${iav_imagetag}"
                        echo "ontrac_imagetag value is ${ontrac_imagetag}"
                        echo "$ebill_imagetag value is {ebill_imagetag}"
                        echo "recipient_imagetag value is ${recipient_imagetag}"
						}
            }
        }
        stage ('push images'){
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
                        echo "api_imagetag value is ${api_imagetag}"
                        echo "sso_imagetag value is ${sso_imagetag}"
                        echo "iav_imagetag value is ${iav_imagetag}"
                        echo "ontrac_imagetag value is ${ontrac_imagetag}"
                        echo "$ebill_imagetag value is {ebill_imagetag}"
                        echo "recipient_imagetag value is ${recipient_imagetag}"
						}
            }
        }


        stage ('push to dr'){
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
                        echo "api_imagetag value is ${api_imagetag}"
                        echo "sso_imagetag value is ${sso_imagetag}"
                        echo "iav_imagetag value is ${iav_imagetag}"
                        echo "ontrac_imagetag value is ${ontrac_imagetag}"
                        echo "$ebill_imagetag value is {ebill_imagetag}"
                        echo "recipient_imagetag value is ${recipient_imagetag}"
                }
            }
        }

        stage ('update ec2 counts'){
            steps {
                script {
				tfparam.nbr_api_ec2()
				tfparam.nbr_ui_ec2()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "environment {environment} value is ${params.environment} and nbr_api_ec2 value is ${nbr_api_ec2}" 
                            echo "environment {environment} value is ${params.environment} and nbr_ui_ec2 value is ${nbr_ui_ec2}" 
                        done
                    '''
                }
            }
        }
        stage ('create ssm parameter store api'){
            when {
//                environment name: 'update_api', value: 'yes'
                expression { params.update_api == yes }

            }
            steps {
                script {
                                 //tfparam.environment()
                                 tfparam.api_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} and ${api_imagetag}"
                            echo "${environment} and ${api_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store sso'){
            when {
//                environment name: 'update_sso', value: 'yes'
                expression { params.update_sso == yes }
            }
            steps {
                script {
                                 //tfparam.environment()
                                 tfparam.sso_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} and ${sso_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store iav'){
            when {
//                environment name: 'update_iav', value: 'yes'
                expression { params.update_iav == yes }
            }
            steps {
                script {
  //                               tfparam.environment()
                                 tfparam.iav_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} and ${iav_imagetag}"
                            echo "${environment} and ${iav_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store ontrac'){
            when {
               // environment name: 'update_ontrac', value: 'yes'
                expression { params.update_ontrac == yes }
            }
            steps {
                script {
                                // tfparam.environment()
                                 tfparam.ontrac_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} ${ontrac_imagetag}"
                            echo "${environment} ${ontrac_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store ebill'){
            when {
             //   environment name: 'update_ebill', value: 'yes'
                expression { params.update_ebill == yes }

            }
            steps {
                script {
                                 //tfparam.environment()
                                 tfparam.ebill_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} and ${ebill_imagetag}"
                            echo "${environment} and ${ebill_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store recipient'){
            when {
               // environment name: 'update_recipient', value: 'yes'
                expression { params.update_recipient == yes }

            }
            steps {
                script {
                                 //tfparam.environment()
                                 tfparam.recipient_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${environment} and ${recipient_imagetag}"
                            echo "${environment} and ${recipient_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('DR create ssm parameter store api'){
            when {
                //environment name: 'update_api', value: 'yes'
                expression { params.update_api == yes }
            }
            steps {
                script {
                                // tfparam.environment()
                                 tfparam.api_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do

                             echo "${api_imagetag}"
							 
                        done
                    '''
                }
            }
        }

        stage ('DR create ssm parameter store sso'){
            when {
                //environment name: 'update_sso', value: 'yes'
                expression { params.update_sso == yes }
            }
            steps {
                script {
                                // tfparam.environment()
                                 tfparam.sso_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${sso_imagetag}"
                            echo "${sso_imagetag}"
                        done
                    '''
                }
            }
        }
        stage ('DR create ssm parameter store iav'){
            when {
               // environment name: 'update_iav', value: 'yes'
                expression { params.update_iav == yes }
            }
            steps {
                                 //tfparam.environment()
                                 tfparam.iav_imagetag()
                script {
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${iav_imagetag}"
                            echo "${iav_imagetag}"
                        done
                    '''
                }
            }
        }
        stage ('DR create ssm parameter store ontrac'){
            when {
               // environment name: 'update_ontrac', value: 'yes'
                expression { params.update_ontrac == yes }

            }
            steps {
                script {
                                // tfparam.environment()
                                 tfparam.ontrac_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${ontrac_imagetag}"
                            echo "${ontrac_imagetag}"
                        done
                    '''
                }
            }
        }
        stage ('DR create ssm parameter store ebill'){
            when {
                //environment name: 'update_ebill', value: 'yes'
                expression { params.update_ontrac == yes }

            }
            steps {
                script {
                                // tfparam.environment()
                                 tfparam.ebill_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${ebill_imagetag}"
                            echo "${ebill_imagetag}"
                        done
                    '''
                }
            }
        }
        stage ('DR create ssm parameter store recipient'){
            when {
                //environment name: 'update_recipient', value: 'yes'
                expression { params.update_recipient == yes }

            }
            steps {
                script {
                                 //tfparam.environment()
                                 tfparam.recipient_imagetag()
                    sh '''
                        for environment in ${params.environment};
                        do
                            echo "${recipient_imagetag}"
                            echo "${recipient_imagetag}"
                        done
                    '''
                }
            }
        }
        
        
    }
}
