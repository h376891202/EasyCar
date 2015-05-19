/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gred.easy_car.car_owner.internet;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;

/**
 * A request for retrieving a {@link JSONObject} response body at a given URL, allowing for an
 * optional {@link JSONObject} to be passed in as part of the request body.
 */
public class JsonRequestWithKeyValueParam extends JsonRequest<JSONObject> {
    private static final String PROTOCOL_CONTENT_TYPE_KEY_VALUE =
            String.format("application/x-www-form-urlencoded; charset=%s", PROTOCOL_CHARSET);

    /**
     * Creates a new request.
     * @param method the HTTP method to use
     * @param url URL to fetch the JSON from
     * @param jsonRequest A {@link JSONObject} to post with the request. Null is allowed and
     *   indicates no parameters will be posted along with request.
     * @param listener Listener to receive the JSON response
     * @param errorListener Error listener, or null to ignore errors.
     */
    public JsonRequestWithKeyValueParam(int method, String url, JSONObject jsonRequest,
            Listener<JSONObject> listener, ErrorListener errorListener) {
        super(method, url, (jsonRequest == null) ? null : parseJsonToKeyValue(jsonRequest), listener,
                    errorListener);
    }

    /**
     * Constructor which defaults to <code>GET</code> if <code>jsonRequest</code> is
     * <code>null</code>, <code>POST</code> otherwise.
     *
     * @see #JsonObjectRequest(int, String, JSONObject, Listener, ErrorListener)
     */
    public JsonRequestWithKeyValueParam(String url, JSONObject jsonRequest, Listener<JSONObject> listener,
            ErrorListener errorListener) {
        this(jsonRequest == null ? Method.GET : Method.POST, url, jsonRequest,
                listener, errorListener);
    }

    //TODO check here
    private static String parseJsonToKeyValue(JSONObject jsonRequest) {
        StringBuilder data = new StringBuilder();
    Iterator<String> keys = jsonRequest.keys();
    boolean added = false;
    while (keys.hasNext()) {
          String key = keys.next();
          try {
                data.append(key + "=" + jsonRequest.getString(key) + "&");
          } catch (JSONException e) {
                e.printStackTrace();
          }
          added = true;
    }
    if (added) {
          data.deleteCharAt(data.length()-1);
    }
    return data.toString();
  }

    @Override
    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE_KEY_VALUE;
    }

    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers, PROTOCOL_CHARSET));
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }
}
