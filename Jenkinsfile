pipeline {
    agent any
    tools {
        maven "maven"
    }

     parameters {
        string(name: 'CUCUMBER_TAGS', defaultValue: '', description: 'Cucumber tags for test execution')
    }
    stages {

        stage('Build and Run') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: 'master']], userRemoteConfigs: [[url: 'https://github.com/udaysinghc/michorTest.git']]])
             bat "mvn clean install -Dcucumber.filter.tags=${params.CUCUMBER_TAGS}"
            }
        }

        stage('Generate Cucumber Report') {
            steps {
                script {
                    cucumberReports(
                        buildStatus: 'UNCHANGED',
                        customCssFiles: '',
                        customJsFiles: '',
                        failedFeaturesNumber: -1,
                        failedScenariosNumber: -1,
                        failedStepsNumber: -1,
                        fileIncludePattern: '**/target/cucumber/cucumber.json',
                        pendingStepsNumber: -1,
                        skippedStepsNumber: -1,
                        sortingMethod: 'ALPHABETICAL',
                        undefinedStepsNumber: -1
                    )
                }
            }
        }
    }
      post {
            success {
                archiveArtifacts '**/target/cucumber/cucumber.json'
                script {
                    def buildUrl = env.BUILD_URL
                    def cucumberReportUrl = "${buildUrl}cucumber-html-reports/overview-features.html"
                    slackSend channel: '#automation', message: "Build successful! Cucumber Report: ${cucumberReportUrl}"
                }
            }
            failure {
                script {
                    def buildUrl = env.BUILD_URL
                    slackSend channel: '#automation', message: "Build failed! Jenkins Build: ${buildUrl}"
                }
            }
        }


}

// Define a function to generate Cucumber reports
def cucumberReports(Map options) {
    step([$class: 'CucumberReportPublisher',
        buildStatus: options.buildStatus,
        customCssFiles: options.customCssFiles,
        customJsFiles: options.customJsFiles,
        failedFeaturesNumber: options.failedFeaturesNumber,
        failedScenariosNumber: options.failedScenariosNumber,
        failedStepsNumber: options.failedStepsNumber,
        fileIncludePattern: options.fileIncludePattern,
        pendingStepsNumber: options.pendingStepsNumber,
        skippedStepsNumber: options.skippedStepsNumber,
        sortingMethod: options.sortingMethod,
        undefinedStepsNumber: options.undefinedStepsNumber
    ])
}





