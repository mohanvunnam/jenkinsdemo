pipeline{
agent any
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
		  }
echo "$environment"
	}

}
stage('Test') 
{
steps{
echo "Testing the Code.........."
	script{
	   gv.sso()
		  }
	 }
}
stage('Compile') 
{
steps{
echo "Compiling the Project.........."
	script{
	   gv.iav()
		  }
	}
}
stage('Deploy') 
{
steps{
echo "Deploying the Project.........."
	script{
	   gv.ontrac()
		  }
	}
}

stage('QA') 
{
steps{
echo "QA for the Project.........."
	script{
	   gv.ebill()
		  }
	}
}

stage('Report') 
{
steps{
echo "Report generating the Project.........."
	script{
	   gv.recipient()
		  }
	}
}

}
}
