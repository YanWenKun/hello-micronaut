package `fun`.yanwk.hello.hellomicronaut

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals

object HelloControllerSpec : Spek({
    describe("HelloController Suite") {
        // 启动内嵌的 HTTP Server
        // 测试期的 Server 会随机指派一个端口，无需配置
        var embeddedServer: EmbeddedServer = ApplicationContext.run(EmbeddedServer::class.java)
        // 启动内嵌的 HTTP Client
        // 并指定到刚启动的 Server 的 URL
        var client: HttpClient = HttpClient.create(embeddedServer.url)

        it("test /hello responds Hello World") {
            var rsp: String = client.toBlocking().retrieve("/hello")
            assertEquals("Hello, World!", rsp)
        }

        afterGroup {
            client.close()
            embeddedServer.close()
        }
    }
})
