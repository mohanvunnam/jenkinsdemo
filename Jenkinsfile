pipeline {
    agent any
//    options {
//        ansiColor('xterm')
//    }
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
                         env.api_imagetag = props.api_imagetag
                         env.sso_imagetag = props.sso_imagetag
                         env.iav_imagetag = props.iav_imagetag
                         env.ontrac_imagetag = props.ontrac_imagetag
                         env.ebill_imagetag = props.ebill_imagetag
                         env.recipient_imagetag = props.recipient_imagetag
                         env.environment = props.environment
                         env.nbr_api_ec2 = props.nbr_api_ec2
                         env.nbr_ui_ec2 = props.nbr_ui_ec2
                         env.update_sso = props.update_sso
                         env.update_api = props.update_api
                         env.update_iav = props.update_iav
                         env.update_ontrac = props.update_ontrac
                         env.update_ebill = props.update_ebill
                         env.update_recipient = props.update_recipient
                         env.tfbranch = props.tfbranch
                         env.cybersource_loopback = props.cybersource_loopback
                         env.dc_dcu_loopback = props.dc_dcu_loopback
                         env.dc_dna_3rivers_loopback = props.dc_dna_3rivers_loopback
                         env.dc_dna_meritrust_loopback = props.dc_dna_meritrust_loopback
                         env.dc_cocc_reading_loopback = props.dc_cocc_reading_loopback
                         env.dc_mahalo_profed_loopback = props.dc_mahalo_profed_loopback
                         env.dc_episys_coastal_loopback = props.dc_episys_coastal_loopback
                         env.dc_episys_dover_loopback = props.dc_episys_dover_loopback
                         env.dc_episys_publix_loopback = props.dc_episys_publix_loopback
                         env.dc_episys_unitus_loopback = props.dc_episys_unitus_loopback
                         env.dc_finxact_primis_loopback = props.dc_finxact_primis_loopback
                         env.dc_q2_mercantile_loopback = props.dc_q2_mercantile_loopback
                         env.rce_worker_loopback = props.rce_worker_loopback
                         env.venmo_loopback = props.venmo_loopback
                         env.bpx_loopback = props.bpx_loopback
                         env.dc_cocc_libertybank_loopback = props.dc_cocc_libertybank_loopback
                         env.dc_xp2_nusenda_loopback = props.dc_xp2_nusenda_loopback
                         env.dc_episys_wrightpatt_loopback = props.dc_episys_wrightpatt_loopback
                         env.dc_episys_eecu_loopback = props.dc_episys_eecu_loopback
                         env.dc_q2_firstnorthernbank_loopback = props.dc_q2_firstnorthernbank_loopback
                         env.dc_q2_5star_loopback = props.dc_q2_5star_loopback
                         env.dc_finxact_glorifi_loopback = props.dc_finxact_glorifi_loopback
                         env.dc_keystone_cenwill_loopback = props.dc_keystone_cenwill_loopback
                         env.dc_episys_hudsonvalley_loopback = props.dc_episys_hudsonvalley_loopback
                         env.dc_episys_kinecta_loopback = props.dc_episys_kinecta_loopback
                         env.dc_episys_georgiaunited_loopback = props.dc_episys_georgiaunited_loopback
                         env.dc_q2_chesapeakebank_loopback = props.dc_q2_chesapeakebank_loopback
                         env.should_roll = props.should_roll
                // Use a script block to do custom scripting
                echo "The username  is $Username"
                echo "The PushDrContainers value  is $PushDrContainers"
               		}
         	}
								}

        stage ('pull images'){
            when {
                expression { PushDrContainers == 'true' }
            }
            steps {
                script {
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
                expression { PushDrContainers == 'true' }
            }
            steps {
                script {
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
                expression { PushDrContainers == 'true' }
            }
            steps {
                script {
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
                expression { PushDrContainers == 'true' }
            }
            steps {
                script {
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
                    sh '''
                        for environment in $environment;
                        do
                            echo "environment ${environment} value is ${environment} and nbr_api_ec2 value is ${nbr_api_ec2}" 
                            echo "environment ${environment} value is ${environment} and nbr_ui_ec2 value is ${nbr_ui_ec2}" 
                        done
                    '''
                }
            }
        }
        stage ('create ssm parameter store api'){
            when {
                expression { update_api == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_sso == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
                        do
                            echo "${environment} and ${sso_imagetag}"
                        done
                    '''
                }
            }
        }

        stage ('create ssm parameter store iav'){
            when {
                expression { update_iav == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_ontrac == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_ebill == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_recipient == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_api == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
                        do

                             echo "${api_imagetag}"
							 
                        done
                    '''
                }
            }
        }

        stage ('DR create ssm parameter store sso'){
            when {
                expression { update_sso == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_iav == 'yes' }
            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_ontrac == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_ontrac == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
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
                expression { update_recipient == 'yes' }

            }
            steps {
                script {
                    sh '''
                        for environment in $environment;
                        do
                            echo "${recipient_imagetag}"
                            echo "${recipient_imagetag}"
                        done
                    '''
                }
            }
        }



// ----------------------------------------------------------------------------------------------------------------

        stage ('terraform'){
            steps {
                dir("/tmp/mvunnam/environments/main/infrastructure") {
                    sh '''
                       echo "infrastructure-${environment} \
                        workspaceName ${environment} \
                        requiresApproval ${approval}\
                        revision ${tfbranch} \
                        environmentVariables ENV0_TERRAFORM_BACKEND_CONFIG=prodbackend \
TF_VAR_cybersource_loopback=${cybersource_loopback} TF_VAR_dc_dcu_loopback=${dc_dcu_loopback} TF_VAR_dc_dna_3rivers_loopback=${dc_dna_3rivers_loopback} TF_VAR_dc_dna_meritrust_loopback=${dc_dna_meritrust_loopback} TF_VAR_dc_cocc_reading_loopback=${dc_cocc_reading_loopback} TF_VAR_dc_mahalo_profed_loopback=${dc_mahalo_profed_loopback} TF_VAR_dc_episys_coastal_loopback=${dc_episys_coastal_loopback} TF_VAR_dc_episys_dover_loopback=${dc_episys_dover_loopback} TF_VAR_dc_episys_publix_loopback=${dc_episys_publix_loopback} TF_VAR_dc_episys_unitus_loopback=${dc_episys_unitus_loopback} TF_VAR_dc_finxact_primis_loopback=${dc_finxact_primis_loopback} TF_VAR_dc_q2_mercantile_loopback=${dc_q2_mercantile_loopback} TF_VAR_rce_worker_loopback=${rce_worker_loopback} TF_VAR_venmo_loopback=${venmo_loopback} TF_VAR_bpx_loopback=${bpx_loopback} TF_VAR_dc_cocc_libertybank_loopback=${dc_cocc_libertybank_loopback} TF_VAR_dc_xp2_nusenda_loopback=${dc_xp2_nusenda_loopback} TF_VAR_dc_episys_wrightpatt_loopback=${dc_episys_wrightpatt_loopback} TF_VAR_dc_episys_eecu_loopback=${dc_episys_eecu_loopback} TF_VAR_dc_q2_firstnorthernbank_loopback=${dc_q2_firstnorthernbank_loopback} TF_VAR_dc_q2_5star_loopback=${dc_q2_5star_loopback} TF_VAR_dc_finxact_glorifi_loopback=${dc_finxact_glorifi_loopback} TF_VAR_dc_keystone_cenwill_loopback=${dc_keystone_cenwill_loopback} TF_VAR_dc_episys_hudsonvalley_loopback=${dc_episys_hudsonvalley_loopback} TF_VAR_dc_episys_kinecta_loopback=${dc_episys_kinecta_loopback} TF_VAR_dc_episys_georgiaunited_loopback=${dc_episys_georgiaunited_loopback} TF_VAR_dc_q2_chesapeakebank_loopback=${dc_q2_chesapeakebank_loopback} \
                        TF_VAR_spotinst_api_desired_capacity=${nbr_api_ec2} \
                        TF_VAR_spotinst_ui_desired_capacity=${nbr_ui_ec2} \
                        TF_VAR_spotinst_should_roll=${should_roll}"
                    '''
         							       }
            }
        }

        stage ('Terraform Apply') {
            steps {
                    script {
                        input message: "Proceed with Terraform apply?", ok: "Yes", submitter: "admin"
                    }
                    sh '''
                        echo "approve environmentName infrastructure-${environment}"
                    '''
            	  }
            post {
                aborted {
                    echo "Aborting terraform apply"
                    sh '''
                        echo "env0 cancel environmentName infrastructure-${environment}"
                    '''
                       }
                  }
				  }		   



        stage ('Run in DR') {
			when {
	                expression { ${HOSTNAME} == 'mohan2.vm.org' }
        	             }
            steps {
                    script {
                        echo "Triggered in DR location"
			   }
		  }
		post {	
                success {

                    echo "Run when only success"
                    sh '''
                        crumb=$(curl -u "jenkins:test@3214" -s 'http://192.168.56.102:8080/crumbIssuer/api/xml?xpath=concat(//crumbRequestField,":",//crumb)')

echo "crumb value is $crumb"

                        #curl -u "jenkins:test@3214" -H "$crumb" -X POST http://192.168.56.102:8080/job/remotetrigger/build?delay=0sec
                        #curl -u "jenkins:test@3214" -H "$crumb" -X POST http://192.168.56.102:8080/job/remotetrigger/buildWithParameters
			curl -u "jenkins:test@3214" -H "$crumb" -X POST http://192.168.56.102:8080/job/firstpipeline/build?delay=0sec

                    '''
                }
            }
        }





        
        
    }
}
