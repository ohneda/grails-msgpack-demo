import groovyx.net.http.*

def http = new HTTPBuilder( 'http://localhost:8080/grails-msgpack-demo/' )

def a = (new Date()).time
10.times{
    def resp = http.get( path: 'message',
    query: [id: (it + 1)] )
    assert resp.id == it + 1
}

def b = (new Date()).time

println "REST : 10 GET method takes ${b -a} millisecond."
