package com.hymnal.socket

import com.hymnal.socket.default.Pack
import com.hymnal.socket.default.ProtocolCodecFactoryImpl
import org.junit.Test
import org.junit.Assert.*
import org.slf4j.LoggerFactory

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }

    @Test
    fun test() {

    }

    @Test
    fun socketTest() {


    }


}


fun main(args: Array<String>) {
//    val a = 123
//    println()

    test()
}

fun test () {

    val logger = LoggerFactory.getLogger("test")
    val request = "{\"cmd\":\"login\",\"param\":{\"name\":\"qxj\",\"password\":\"123456\"}}"
    logger.info("start")
    val client = SocketClient.Builder()
        .setType(SocketClient.Type.TCP, false)
        .setTag("SocketSingle")
        .setIp(ip = "10.202.91.98", port = 7085)
//        .setCodecFactory(ProtocolCodecFactoryImpl(Pack(header = "5aa5", HEADER = 2, LENGTH = 4)))
        .setResponse(Response {

            if (it.isSuccess) {

            }

            if (it.isFailure) {
                if (it.exceptionOrNull() is SocketException) {
                    logger.info("服务器异常")
                }
            }
        })
        .builder()

    client.send(1)
}
