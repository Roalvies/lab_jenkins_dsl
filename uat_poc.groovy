pipelineJob('uat-poc') {
    definition {
        cps {
            script(readFileFromWorkspace(aut.jenkinsfile))
            sandbox()
        }
    }

    parameters{
        activeChoiseParam('Destino del Proyecto'){
            choiceType('SINGLE_SELECT')
            groovyScript {
                script("['Asp','Clou_B','Cloud_C']")

                fallbackScript('return [ERROR]')

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
