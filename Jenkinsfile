pipeline {
    agent any
    environment {
            approval = "true"
    }
//    parameters {
//        booleanParam(name: 'PushDrContainers', defaultValue: true, description: 'PushDrContainers execute only if true')
//               }
    stages {
	stage('init') 
		{
		steps{
		echo "Loading paramerts groovy file.........."
			script{
			   tfparam = load "paramvar.groovy"
			   tfparam.PushDrContainers()
			   echo "PushDrContainers value is ${PushDrContainers} and $PushDrContainers"
			     }
		     }
		}
        stage ('pull images') {
            when {
                expression { '$PushDrContainers' == true }
  	           }
            steps {
                script {
			 tfparam.iav_imagetag()	     
			 tfparam.ontrac_imagetag()	     
			 tfparam.ebill_imagetag()	     
			 tfparam.recipient_imagetag()	     
	                 echo "iav_imagetag value is ${iav_imagetag}"
			 echo "ontrac_imagetag value is ${ontrac_imagetag}"
	                 echo "ebill_imagetag value is ${ebill_imagetag}"
         	         echo "recipient_imagetag value is ${recipient_imagetag}"
         	       }
		environment{
			PushDrContainers = true
			   }
            	 }
     				 }
        
    }
}
