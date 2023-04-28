package vmo.du5.com

import groovy.transform.CompileStatic
import io.micronaut.core.annotation.Introspected
import io.micronaut.runtime.Micronaut
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Info
import org.h2.tools.Server

import javax.persistence.Entity

@OpenAPIDefinition(
        info = @Info(
                title = "ajt-recruit-post",
                version = "0.1"
        )
)
@CompileStatic
@Introspected(packages = [
        'vmo.du5.com.*'
], includedAnnotations = Entity)
class Application {

    static void main(String[] args) {
        // config h2 server
        Server.createWebServer(
                new String[]{"-webPort", "8090",
                        "-tcp",
                        "-tcpAllowOthers",
                        "-webAllowOthers"
                }
        )
                .start()

        Micronaut.build(args)
                .mainClass(Application.class)
                .start()
    }
}
