pipeline{
agent any
parameters {
    string(name: 'sso', defaultValue: '', description: 'which SSO we want to execute')
    choice(name: 'ENVIRONMENT', choices: ['DVLP', 'TEST', 'UAT', 'PROD'], description: 'on which environment to execute')
    booleanParam(name: 'executefunctionstep', defaultValue: true, description: 'execute only if true')
}
stages 
{
stage('init') 
{
steps{
echo "Loading paramerts groovy file.......... $sso"
	
}
}


}
}
