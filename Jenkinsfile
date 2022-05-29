pipeline {
    agent any
    stages {

        stage('Build') {
            steps {
                sh 'echo "Building.."'
                sh './gradlew build -x test'
            }
        }

        stage('Test') {
            steps {
                sh 'echo "Testing.."'
                sh './gradlew test'
            }
        }

        stage('Javadocs') {
            steps {
                sh 'echo "Javadocs.."'
                sh './gradlew javadoc'
            }
        }

        stage('Zip') {
            steps {
                sh 'echo "myZip.."'
                sh './gradlew myZip'
            }
        }

        //scheitert
        stage('Upload') {
             steps {
                sh 'curl -F "file=@test.txt" https://file.io > helloworld.txt'
                sh 'tail -n20 helloworld.txt'
                def file = new File("helloworld.txt")
                println file
             }
        }


    }
}