package `fun`.yanwk.hello.hellomicronaut

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("fun.yanwk.hello.hellomicronaut")
                .mainClass(Application.javaClass)
                .start()
    }
}
