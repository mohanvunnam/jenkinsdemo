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
when {
    expression {
	params.executefunctionstep == true
               }
//steps{
//echo "Loading paramerts groovy file.......... SSO is $sso  and envi is  $ENVIRONMENT"
//}	
}
}


}
}
