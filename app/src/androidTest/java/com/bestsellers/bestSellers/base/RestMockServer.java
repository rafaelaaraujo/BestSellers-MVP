package com.bestsellers.bestSellers.base;

import android.content.Context;
import android.util.Log;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.bestsellers.bestSellers.base.TestConstantsKt.BEST_SELLERS_JSON;
import static com.bestsellers.bestSellers.base.TestConstantsKt.NAMES_JSON;
import static com.bestsellers.util.ConstantsKt.URL_BEST_SELLERS;
import static com.bestsellers.util.ConstantsKt.URL_NAMES;

/**
 * Created by Rafaela Araujo
 * on 04/12/2017.
 */

public class RestMockServer {


    private static String convertStreamToString(InputStream is) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    private static String getStringFromFile(Context context, String filePath) throws Exception {
        final InputStream stream = context.getResources().getAssets().open(filePath);
        String ret = convertStreamToString(stream);
        stream.close();
        return ret;
    }

    public final static Dispatcher dispatcher = new Dispatcher() {

        @Override
        public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
            try {
                switch (request.getPath()) {
                    case URL_NAMES:
                        return new MockResponse().setResponseCode(200).setBody(getStringFromFile(getInstrumentation().getContext(), NAMES_JSON));
                    case URL_BEST_SELLERS:
                        return new MockResponse().setResponseCode(200).setBody(getStringFromFile(getInstrumentation().getContext(), BEST_SELLERS_JSON));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MockResponse().setResponseCode(404);
        }
    };
}
