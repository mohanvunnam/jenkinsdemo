pipeline {
    agent any
    environment {
            approval = "true"
            ENV = "testing"

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

            steps {
                script {
			 tfparam.PushDrContainers()
			 tfparam.iav_imagetag()	     
			 tfparam.ontrac_imagetag()	     
			 tfparam.ebill_imagetag()	     
			 tfparam.recipient_imagetag()	     
	                 echo "iav_imagetag value is ${iav_imagetag}"
			 echo "ontrac_imagetag value is ${ontrac_imagetag}"
	                 echo "ebill_imagetag value is ${ebill_imagetag}"
         	         echo "recipient_imagetag value is ${recipient_imagetag}"
         	         echo "PushDrContainers value is $PushDrContainers"
         	       }
            	 }
 		environment {
			PushDrContainers = "true"
			   }
            when {
                expression { env.PushDrContainers == true }
                //environment(name: "PushDrContainers", value: "true")
                //expression { ['$PushDrContainers'] == true }
  	           }
     				 }
       

        stage("Test") {
            when {
                environment(name: "ENV", value: "testing")
            	}
            steps {
                echo "Test stage got executed hehehe."
           	 }
	 environment {
                     ENV = "testing"
                     }
		        }
 


    }
}
