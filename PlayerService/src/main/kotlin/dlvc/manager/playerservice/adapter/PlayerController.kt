package dlvc.manager.playerservice.adapter

import dlvc.manager.playerservice.application.service.PlayerService
import dlvc.manager.playerservice.domain.Player
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController (val playerService: PlayerService) {

    // TODO: Testing
    @PostMapping("/hello")
    fun post(@RequestBody player: Player) = playerService.savePlayer(player)
}