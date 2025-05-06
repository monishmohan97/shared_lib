def call(gitUrl, branch='main') {
    stage('checkout') {
        git url: gitUrl, branch: branch
    }
    stage('setup'){
        sh """
        python3 -m venv .venv
        . .venv/bin/activate
        pip install -r requirements.txt
        """
    }
    stage('test'){
        sh """
        . .venv/bin/activate
        python -m unittest discover -s tests
        """
    }
    stage('build'){
        sh """
        . .venv/bin/activate
        python setup.py sdist bdist_wheel
        """
    }
    stage('deploy'){
        sh """
        . .venv/bin/activate
        python -m twine upload dist/*
        """
    }
}