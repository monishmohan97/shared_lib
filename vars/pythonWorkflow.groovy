def call(gitUrl, branch='main') {
    stage('checkout') {
        git url: gitUrl, branch: branch
    }
    stage('setup'){
        bat '''
                    python -m venv venv
                    call venv\\Scripts\\activate
                    pip install --upgrade pip
                    pip install -r requirements.txt
                '''
    }
    stage('test'){
        bat '''
                            call venv\\Scripts\\activate
                            python -m pytest tests/unit --junitxml=unit_test_results.xml
                        '''
    }
 
}
