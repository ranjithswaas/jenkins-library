import groovy.json.JsonBuilder
import org.ranjith.JenkinsHttpClient

def buildApp(String morpheusUrl, Map<?, ?> postBody, String bearerToken) {
	String jsoncontent = new JsonBuilder(postBody).toString()
	JenkinsHttpClient http = new JenkinsHttpClient()
	return println bearerToken
	
}

def getApp(String morpheusUrl, String bearerToken) {
	JenkinsHttpClient http = new JenkinsHttpClient()
	http.get(morpheusUrl, bearerToken)
}

def deleteApp(String morpheusUrl, String bearerToken) {
	JenkinsHttpClient http = new JenkinsHttpClient()
	http.delete(morpheusUrl, bearerToken)
}
