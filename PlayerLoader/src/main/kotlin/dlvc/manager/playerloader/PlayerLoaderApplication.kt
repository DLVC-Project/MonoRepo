package dlvc.manager.playerloader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PlayerLoaderApplication

fun main(args: Array<String>) {
    runApplication<PlayerLoaderApplication>(*args)
}