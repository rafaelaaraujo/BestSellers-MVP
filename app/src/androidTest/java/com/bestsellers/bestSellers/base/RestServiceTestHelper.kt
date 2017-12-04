package com.bestsellers.bestSellers.base

import android.content.Context
import com.squareup.okhttp.mockwebserver.MockResponse
import com.squareup.okhttp.mockwebserver.RecordedRequest

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

import android.support.test.InstrumentationRegistry.getInstrumentation
import com.bestsellers.util.URL_BEST_SELLERS
import com.bestsellers.util.URL_NAMES
import com.squareup.okhttp.mockwebserver.Dispatcher
import java.net.HttpURLConnection

object RestServiceTestHelper{

    var context:Context = getInstrumentation().context
    val dispatcher: Dispatcher = object : Dispatcher() {

        override fun dispatch(request: RecordedRequest): MockResponse {
            try {
                when (request.path) {
                    URL_NAMES -> return getMockResponse(NAMES_JSON)
                    URL_BEST_SELLERS -> return getMockResponse(BEST_SELLERS_JSON)
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
            return MockResponse().setResponseCode(HttpURLConnection.HTTP_NOT_FOUND)
        }
    }

    private fun getMockResponse(filename: String) =
            MockResponse().setResponseCode(HttpURLConnection.HTTP_OK).setBody(getBody(filename))

    private fun getBody(fileName:String) =
            getStringFromFile(context, fileName)

    @Throws(Exception::class)
    private fun convertStreamToString(inputStream: InputStream): String {
        val reader = BufferedReader(InputStreamReader(inputStream))
        val sb = StringBuilder()
        val line = reader.readLine()
        while (line != null) {
            sb.append(line).append("\n")
        }
        reader.close()
        return sb.toString()
    }

    @Throws(Exception::class)
    private fun getStringFromFile(context: Context, filePath: String): String {
        val stream = context.resources.assets.open(filePath)
        val ret = convertStreamToString(stream)
        stream.close()
        return ret
    }
}
