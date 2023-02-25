package dlvc.manager.playerservice.application

import dlvc.manager.playerservice.domain.Player
import org.springframework.data.repository.ListCrudRepository
import org.springframework.stereotype.Component

@Component
interface PlayerRepository : ListCrudRepository<Player, String> {
    // TODO: Testing? https://rieckpil.de/test-your-spring-boot-jpa-persistence-layer-with-datajpatest/
    override fun findAll(): List<Player>

//    @Query("select * from player")
//    fun findMessage(): List<Player>
}