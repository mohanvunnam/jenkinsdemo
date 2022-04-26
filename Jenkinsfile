pipeline {
    agent any
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
        stage ('pull images') {
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
        
    }
}
