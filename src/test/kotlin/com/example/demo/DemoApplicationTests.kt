package com.example.demo

import io.kotlintest.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.web.reactive.function.client.WebClient

@ExtendWith(SpringExtension::class)
@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private lateinit var webClientBuilder: WebClient.Builder

  @Nested
  inner class InnerClass {

    @Nested
    inner class InnerClass2 {

      @Nested
      inner class InnerClass3 {
        @Test
        fun `Given something | When something | Then something should pass also 3`() {
          assert(true)
        }
      }

      @Test
      fun `Given something | When something | Then something should pass also 2`() {
        assert(true)
      }
    }

    @Test
    fun `Given something | When something | Then something should pass also`() {
      assert(true)
    }
  }

  @Test
  fun `Given something | When something | Then something`() {
    val springClient = webClientBuilder.baseUrl("https://start.spring.io").build()
    val actual = springClient.get("actuator/info").block()!!.read<String>("$.git.commit.id")
    actual shouldBe "781c1a5"
  }

  @Test
  fun `Given something | When something | Then something should pass`() {
    assert(true)
  }
}
