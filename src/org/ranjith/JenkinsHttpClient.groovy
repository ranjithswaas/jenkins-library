#! /usr/bin/groovy
package org.ranjith

import groovy.json.JsonBuilder
@Grab("org.jodd:jodd-http:3.8.5")
import jodd.http.HttpRequest

/**
 * Helper class for making REST calls from a Jenkins Pipeline job.
 */
class JenkinsHttpClient {

    private HttpRequest httpRequest
    
    JenkinsHttpClient() {
        httpRequest = new HttpRequest()
    }

    /**
     * GET method
     * @param url
     * @return response body as String
     */
    def get(String url, String bearerToken) {
	String token = 'BEARER' + bearerToken
        def resp = httpRequest.get(url)
                .header('Authorization', token)
                .send()
        return resp.bodyText()
    }

    /**
     * POST method, convert body Map to applicationjson.
     * @param url
     * @param body
     * @return response body as String
     */
    def postJson(String url, Map<?, ?> body, String bearerToken) {
	String jsonbody = new JsonBuilder(body).toString()
        String token = 'BEARER' + bearerToken
	def resp = httpRequest.post(url)
                .header('Authorization', token)
                .contentType('application/json')
                .body(jsonbody)
	        .trustAllCerts(true)
                .send()
	         
        return resp.bodyText()
    }

    /**
     * DELETE method
     * @param url
     * @return
     */
    def delete(String url, String bearerToken) {
	String token = 'BEARER' + bearerToken
        def resp = httpRequest.delete(url)
                .header('Authorization', token)
                .send()
        return resp.bodyText()
    }
}
