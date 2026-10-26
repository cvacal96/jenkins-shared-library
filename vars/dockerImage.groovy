#!/user/bin/env groovy

def call() {
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh 'docker build -t cvacal96/demo-app:jma-2.0 .'
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push cvacal96/demo-app:jma-2.0'
    }
}