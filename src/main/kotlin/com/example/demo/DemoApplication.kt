package com.example.demo

import com.jayway.jsonpath.JsonPath
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@SpringBootApplication
class DemoApplication

typealias Json = String

fun WebClient.get(path: String): Mono<Json> = this.get().uri(path).exchange().flatMap { it.bodyToMono<Json>() }
fun WebClient.post(path: String): Mono<Json> = this.post().uri(path).exchange().flatMap { it.bodyToMono<Json>() }
fun WebClient.post(path: String, body: Json): Mono<Json> = this.post().uri(path).syncBody(body).exchange().flatMap { it.bodyToMono<Json>() }
fun WebClient.put(path: String): Mono<Json> = this.put().uri(path).exchange().flatMap { it.bodyToMono<Json>() }
fun WebClient.delete(path: String): Mono<Json> = this.delete().uri(path).exchange().flatMap { it.bodyToMono<Json>() }

fun <T> Json.read(path:String) = JsonPath.parse(this).read<T>(path)!!

fun main(args: Array<String>) { runApplication<DemoApplication>(*args) }
