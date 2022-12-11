package dlvc.manager.playerservice.application.service

import dlvc.manager.playerservice.application.PlayerRepository
import dlvc.manager.playerservice.domain.Player
import org.springframework.stereotype.Service

@Service
class PlayerService(val playerRepository: PlayerRepository) {

    fun getAllPlayers() : List<Player> = playerRepository.findAll()

    fun savePlayer(player: Player) = playerRepository.save(player)
}