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

        stage('Jar1') {
                    steps {
                        sh 'echo "Javadocs.."'
                        sh './gradlew jar'
                    }
                }

                stage('Jar2') {
                            steps {
                                sh 'echo "Javadocs.."'
                                sh './gradlew myJar'
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
                sh '''
                cd build/zip/
                curl -F "file=@content.zip" https://file.io > /tmp/helloworld.txt
                tail -n20 /tmp/helloworld.txt
                '''
                script {
                    def content = new File("/tmp/helloworld.txt").text
                    def jsonslurper = new JsonSlurper()
                    def result = jsonslurper.parseText(content)
                    currentBuild.description = "Download:" + result.link
                }

             }
        }


    }
}