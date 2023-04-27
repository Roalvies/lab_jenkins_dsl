pipelineJob('uat-poc') {
    definition {
        cps {
            script(readFileFromWorkspace('uat.jenkinsfile'))
            sandbox()
        }
    }

    parameters{
        activeChoiseParam('DESTINO'){
            choiceType('SINGLE_SELECT')
            groovyScripts{
                script(['Asp','Clou_B','Cloud_C'])

                fallbackScript('return ["ERROR"]')

                description('Selecciona la maquina para desplegar el proyecto')
            }
        }
    }

    definition {
        cps {
            script(readFileFromWorkspace('uat.jenkinsfile'))
            sandbox()
        }
    }
}
