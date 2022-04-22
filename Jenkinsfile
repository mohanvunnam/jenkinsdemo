pipeline{
agent any
parameters {
    //string(name: 'sso', defaultValue: '', description: 'which SSO we want to execute')
    chioce(name: 'ENVIRONMENT', choices: ['DVLP', 'TEST', 'UAT', 'PROD'], description: 'on which environment to execute')
    //booleanParam(name: 'executefunctionstep', defaultVaule: true, description: 'execute only if true')
}
stages 
{
stage('init') 
{
steps{
echo "Loading paramerts groovy file.........."
	script{
	   gv = load "paramvar.groovy"
		  }
	}
}

stage('Build') 
{
steps{
echo "Building the Code.........."
	script{
	   gv.environment()
	   gv.sso()
		  }
echo "Hello my environment value is  $environment and $sso"
	}

}
stage('Test') 
{
steps{
echo "Testing the Code.........."
	script{
	   gv.sso()
		  }
echo "Hello my sso value is $sso"
	 }
}
stage('Compile') 
{
steps{
echo "Compiling the Project.........."
	script{
	   gv.iav()
		  }
echo "Hello my iva value is  $iav"
	}
}
stage('Deploy') 
{
steps{
echo "Deploying the Project.........."
	script{
	   gv.ontrac()
		  }
echo "Hello my ontrac value is  $ontrac"
	}
}

stage('QA') 
{
steps{
echo "QA for the Project.........."
	script{
	   gv.ebill()
		  }
echo "Hello my ebill value is  $ebill"
	}
}

stage('Report') 
{
steps{
echo "Report generating the Project.........."
	script{
	   gv.recipient()
		  }
echo "Hello my recipient value is  $recipient"
	}
}

}
}
