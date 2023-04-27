pipelineJob('uat-poc') {
    definition {
        cps {
            script(readFileFromWorkspace('uat.jenkinsfile'))
            sandbox()
        }
    }

   parameters {
        activeChoiceParam('DESTINO') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script("[q1,q2,q3,q4,q5]")
            
            fallbackScript('return ["ERROR"]')
            
            description('Seleccion el Destino del proyecto. (Campo obligatorio)')
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
            defaultValue 'master'
        }
    }

    definition {
        cps {
            script(readFileFromWorkspace('uat.jenkinsfile'))
            sandbox()
        }
    }
}
