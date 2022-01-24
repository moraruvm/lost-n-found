package io.millers.lostnfoundapi.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration

@Configuration
class MongoConfig : AbstractReactiveMongoConfiguration() {

    override fun autoIndexCreation(): Boolean {
        return true
    }

    override fun getDatabaseName(): String {
        return "lost-and-found"
    }

}