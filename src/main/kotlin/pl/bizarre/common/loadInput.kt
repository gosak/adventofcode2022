package pl.bizarre.common

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.apache.Apache
import io.ktor.client.request.get
import io.ktor.client.request.header
import kotlinx.coroutines.runBlocking

private val httpClient = HttpClient(Apache)

fun loadInput(day: Int): List<String> =
    runBlocking {
        httpClient.get("https://adventofcode.com/2022/day/$day/input") {
            header("Cookie", "Cookie")
        }.body<String>()
    }.split('\n').dropLast(1)
