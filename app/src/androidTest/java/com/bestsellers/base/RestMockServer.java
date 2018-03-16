package com.bestsellers.base;

import android.content.Context;

import com.squareup.okhttp.mockwebserver.Dispatcher;
import com.squareup.okhttp.mockwebserver.MockResponse;
import com.squareup.okhttp.mockwebserver.RecordedRequest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static com.bestsellers.base.TestConstantsKt.BEST_SELLERS_JSON;
import static com.bestsellers.base.TestConstantsKt.NAMES_JSON;
import static com.bestsellers.base.TestConstantsKt.NO_REVIEW_JSON;
import static com.bestsellers.base.TestConstantsKt.REVIEW_JSON;
import static com.bestsellers.base.TestConstantsKt.URL_BEST_SELLERS;
import static com.bestsellers.base.TestConstantsKt.URL_NO_REVIEW_FIRST_ITEM;
import static com.bestsellers.base.TestConstantsKt.URL_NO_REVIEW_LAST_ITEM;
import static com.bestsellers.base.TestConstantsKt.URL_REVIEW_ITEM;
import static com.bestsellers.util.ConstantsKt.URL_NAMES;

/**
 * Created by Rafaela Araujo
 * on 04/12/2017.
 */

public class RestMockServer {

    private static final int SUCESS_CODE = 200;

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
                        return new MockResponse().setResponseCode(SUCESS_CODE).setBody(getStringFromFile(getInstrumentation().getContext(), NAMES_JSON));

                    case URL_BEST_SELLERS:
                        return new MockResponse().setResponseCode(SUCESS_CODE).setBody(getStringFromFile(getInstrumentation().getContext(), BEST_SELLERS_JSON));

                    case URL_NO_REVIEW_LAST_ITEM:
                    case URL_NO_REVIEW_FIRST_ITEM:
                        return new MockResponse().setResponseCode(SUCESS_CODE).setBody(getStringFromFile(getInstrumentation().getContext(), NO_REVIEW_JSON));

                    case URL_REVIEW_ITEM:
                        return new MockResponse().setResponseCode(SUCESS_CODE).setBody(getStringFromFile(getInstrumentation().getContext(), REVIEW_JSON));

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return new MockResponse().setResponseCode(404);
        }
    };
}
