package com.br.project

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EstacionamentoApplication

fun main(args: Array<String>) {
	var app = runApplication<EstacionamentoApplication>(*args)

	val contextPath = app.environment.getProperty("server.servlet.context-path")
	val port = app.environment.getProperty("server.port")

	print(
			"""|
                   |------------------------------------------------------------
                   |   Local:      http://127.0.0.1:$port$contextPath
                   |------------------------------------------------------------""".trimMargin()
	)
}
