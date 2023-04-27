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

    parameters {
        stringParam('Tipo_Perfil', '' , 'Favor Ingrese su Perfil')
        booleanParam('cargarproperties', false, 'Indicar si desea cargar archivo de propiedades.')
    }

    parameters {
        gitParam('branch') {
            description 'Favor seleccione branch'
            type 'BRANCH'
            defaultValue 'dev'
        }
    }

    definition {
        cps {
            script(readFileFromWorkspace('uat.jenkinsfile'))
            sandbox()
        }
    }
}
