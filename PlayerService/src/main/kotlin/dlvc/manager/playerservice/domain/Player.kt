package dlvc.manager.playerservice.domain

import org.springframework.data.relational.core.mapping.Table

@Table("PLAYER")
data class Player(val id: String?, val text: String) {

}