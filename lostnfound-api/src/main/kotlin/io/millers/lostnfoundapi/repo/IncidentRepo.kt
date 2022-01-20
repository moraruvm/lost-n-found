package io.millers.lostnfoundapi.repo

import io.millers.lostnfoundapi.entity.Incident
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface IncidentRepo : ReactiveMongoRepository<Incident, String>
