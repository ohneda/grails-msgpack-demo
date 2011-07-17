import groovyx.net.http.*

import org.grails.msgpack.*
import org.msgpack.rpc.loop.EventLoop
import org.msgpack.annotation.Ignore;
import org.msgpack.annotation.MessagePackBeans;
import org.msgpack.annotation.Optional;
import org.msgpack.rpc.*

//TODO: refactoring to run this test as script

// These beans will be generated automatically in the future release.
@MessagePackBeans
class Message {
    @Optional
    Long id
    @Optional
    Long version
    String string
    @Optional
    String optional
    Date dateCreated
    Date dateUpdated
    Integer intval
    Long longval
    Double doubleval
    Float floatval
    Map<String, String> props
    Boolean isActive
    List<Comment> comments
}

@MessagePackBeans
class Comment {
    @Optional
    Long id
    @Optional
    Long version
    String title
    String name
    @Ignore
    Message message
}

interface RPCInterface {
    Message get(Long id)
}

// REST /GET
def http = new HTTPBuilder( 'http://localhost:8080/grails-msgpack-demo/' )

def a = (new Date()).time
10.times{
    def resp = http.get( path: 'message',
            query: [id: (it + 1)] )
    assert resp.id == it + 1
}

def b = (new Date()).time
println "REST : 10 times GET method takes ${b -a} millisecond."


// MessagePack RPC GET
GroovyBeansRegister.instance.register(Message.class)

EventLoop loop = EventLoop.defaultEventLoop()
Client cli = new Client("localhost", 1985, loop)
RPCInterface iface = cli.proxy(RPCInterface.class)
a = (new Date()).time
10.times{
    def result = iface.get(it+21)
    assert result.id == it + 21
    //assert result.string == "String Value-${it+11}"
}
b = (new Date()).time
println "MessagePack RPC : 10 times GET method takes ${b -a} millisecond."


// REST /GET
http = new HTTPBuilder( 'http://localhost:8080/grails-msgpack-demo/' )

a = (new Date()).time
10.times{
    def resp = http.get( path: 'message',
            query: [id: (it + 11)] )
    assert resp.id == it + 11
}

b = (new Date()).time
println "REST : 10 times GET method takes ${b -a} millisecond."



a = (new Date()).time
10.times{
    def result = iface.get(it+31)
    assert result.id == it + 31
    //assert result.string == "String Value-${it+11}"
}
b = (new Date()).time
println "MessagePack RPC : 10 times GET method takes ${b -a} millisecond."
cli.close()
loop.shutdown()


