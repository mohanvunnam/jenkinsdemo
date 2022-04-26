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
	booleanParam(name: 'update_api', defaultValue: true, description: 'update_api execute only if true')
	booleanParam(name: 'update_ebill', defaultValue: true, description: 'update_ebill execute only if true')
	booleanParam(name: 'update_iav', defaultValue: true, description: 'update_iav execute only if true')
	booleanParam(name: 'update_ontrac', defaultValue: true, description: 'update_ontrac execute only if true')
	booleanParam(name: 'update_recipient', defaultValue: true, description: 'update_recipient execute only if true')
	booleanParam(name: 'update_sso', defaultValue: true, description: 'update_sso execute only if true')
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
				tfparam.environment()
				tfparam.nbr_api_ec2()
				tfparam.nbr_ui_ec2()
                    sh '''
                        for environment in ${environment};
                        do
                            echo "environment value is ${environment} and nbr_api_ec2 value is ${nbr_api_ec2}" 
                            echo "environment value is ${environment} and nbr_ui_ec2 value is ${nbr_ui_ec2}" 
                        done
                    '''
                }
            }
        }
        stage ('create ssm parameter store api'){
            when {
                environment name: 'update_api', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.api_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_sso', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.sso_imagetag()
                    sh '''
                        for environment in ${environment};
                        do
                            echo "${environment} and ${sso_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store iav'){
            when {
                environment name: 'update_iav', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.iav_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_ontrac', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.ontrac_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_ebill', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.ebill_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_recipient', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.recipient_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_api', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.api_imagetag()
                    sh '''
                        for environment in ${environment};
                        do

                             echo "${api_imagetag}"
							 
                        done
                    '''
                }
            }
        }

        stage ('DR create ssm parameter store sso'){
            when {
                environment name: 'update_sso', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.sso_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_iav', value: 'yes'
            }
            steps {
                                 tfparam.environment()
                                 tfparam.iav_imagetag()
                script {
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_ontrac', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.ontrac_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_ebill', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.ebill_imagetag()
                    sh '''
                        for environment in ${environment};
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
                environment name: 'update_recipient', value: 'yes'
            }
            steps {
                script {
                                 tfparam.environment()
                                 tfparam.recipient_imagetag()
                    sh '''
                        for environment in ${environment};
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
