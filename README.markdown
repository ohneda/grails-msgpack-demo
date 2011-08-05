Grails MessagePack Plugin Demo Application
======================

This application is for the demonstration of the Grails MessagePack Plugin.

Build
---------------

Clone the application on your computer.

    git clone https://github.com/ohneda/grails-msgpack-demo

Install the Grails MessagePack Plugin like this:

    grails install-plugin msgpack

Edit your grails-app/config/Config.groovy if you would like to change the port number of MessagePack PPC.

    msgpack {
        rpc.expose = true
        rpc.port = 1985
    }

Running
---------------

Type this command in the demo application directory:

    grails run-app

This application provides a RESTful JSON service and MessagePack RPC service for grails-app/services/org/grails/msgpack/demo/MessageService.groovy.
You can access the JSON 'GET' service with the following link:

http://localhost:8080/grails-msgpack-demo/message/1

To access the msgpack rpc service and measure the performance, clone the [grails-msgpack-demo-client] (https://github.com/ohneda/grails-msgpack-demo-client) and run the test.
