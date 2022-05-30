import groovy.json.JsonSlurper

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
                script {
                    def defaultPathBase = new File( "./build/zip/" ).getCanonicalPath()
                    def content = new File(defaultPathBase, "helloworld.txt").text
                    def jsonslurper = new JsonSlurper()
                    def result = jsonslurper.parseText(content)
                    println result.link
                }




             }
        }


    }
}