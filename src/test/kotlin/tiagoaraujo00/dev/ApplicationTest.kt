package tiagoaraujo00.dev

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.*
import tiagoaraujo00.dev.plugins.*
import kotlin.test.assertContains
import org.junit.Assert.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
        client.get("/test1").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("html", contentType()?.contentSubtype)
            assertContains(bodyAsText(), "Hello from Ktor")
        }
    }
}
