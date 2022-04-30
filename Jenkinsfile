pipeline {
    agent any
    stages {

              stage('adding values to parameters to properties file1') {
          steps {

                script {
                sh ' >/tmp/PrePline.properties'
 
                sh 'echo myHN = ${HOSTNAME}  > /tmp/evHostname.properties'
                sh 'cat /tmp/evHostname.properties >> /tmp/PrePline.properties'
                DRhostname = readFile('/tmp/PrePline.properties').trim()
                echo "DRhostname is $DRhostname"
				
		sh 'echo myIP = `hostname -i | awk {\'print $NF\'}` > /tmp/evHostIP.properties'
		sh 'cat /tmp/evHostIP.properties >> /tmp/PrePline.properties'
                DRhostIP = readFile('/tmp/evHostIP.properties').trim()
                echo "DRhostIP is $DRhostIP"

		sh 'echo filecount = `ls | wc -l` > /tmp/evFilecount.properties'
		sh 'cat /tmp/evFilecount.properties >> /tmp/PrePline.properties'
                FCount = readFile('/tmp/evFilecount.properties').trim()
                echo "File Count is $FCount"
 
                       }
                }
                                                                }

        stage ('add content to pipeline job'){
            steps {
                script {
						 def props = readProperties file: '/tmp/PrePline.properties'
                         env.myHN = props.myHN
                         env.myIP = props.myIP
                         env.filecount = props.filecount
						 
                         echo "Hostname  value is $myHN"
			 echo "IP Adddress  value is $myIP"
			 echo "File Count  value is $filecount"


					 
						 sh '> /tmp/PreParam.properties'
						 sh 'echo "choice(name: \'ENVIRONMENT\', choices: [\'DVLP\', \'TEST\', \'UAT\', \'PROD\'], description: \'on which environment to execute\')" >> /tmp/PreParam.properties' 
						 sh 'echo "string(name: \'sso\', defaultValue: \'$myHN\', description: \'which SSO we want to execute\')" >> /tmp/PreParam.properties'
						 sh 'echo "string(name: \'FileCount\', defaultValue: \'$filecount\', description: \'which File COunt we want to execute\')" >> /tmp/PreParam.properties'
						 sh 'echo "booleanParam(name: \'executefunctionstep\', defaultValue: \'$myIP\', description: \'execute only if true\')" >> /tmp/PreParam.properties'

						sh 'cat beforeparam.txt > PLJenkinsfile'
						sh 'cat /tmp/PreParam.properties >> PLJenkinsfile'
						sh 'cat afterparam.txt >> PLJenkinsfile'
						 //sh 'git add PLJenkinsfile ; git push'
						//sh 'git remote set-url origin https://github.com/mohanvunnam/jenkinsdemo.git'
						//sh 'git remote set-url origin git@github.com:${USER:-${mohanvunnam}}/${REPONAME:-jenkinsdemo}.git'
						//sh 'git push --set-upstream origin master'
						sh 'echo "done"'
                }
            }
        }



}
}

