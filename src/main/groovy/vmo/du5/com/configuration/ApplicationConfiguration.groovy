package vmo.du5.com.configuration

import com.fasterxml.jackson.databind.ObjectMapper
import io.micronaut.context.annotation.Factory
import jakarta.inject.Singleton

@Factory
class ApplicationConfiguration {

    @Singleton
    ObjectMapper objectMapper() {
        return new ObjectMapper()
    }
}
