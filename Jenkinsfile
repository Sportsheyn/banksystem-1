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
        stage('Upload') {
            steps {
                echo "Hello World" > helloworld.txt
                def defaultPathBase = new File( "." ).getCanonicalPath()

                def content = new File(defaultPathBase, "test.txt").text
                println content
                currentBuild.description = "my new description"
            }
        }
    }
}