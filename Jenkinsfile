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
                sh '''
                cd build/zip/
                curl -F "file=@content.zip" https://file.io > helloworld.txt
                tail -n20 helloworld.txt
                '''

//                 def defaultPathBase = new File( "." ).getCanonicalPath()
//                 def content = new File(defaultPathBase, "helloworld.txt").text
//                 println defaultPathBase
             }
        }


    }
}