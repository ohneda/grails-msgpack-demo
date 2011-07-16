import org.grails.msgpack.demo.*

class BootStrap {

    def init = { servletContext ->

        100.times {
            def message = new Message(string: "String Value-${it}",
                        optional: "Optional Value-${it}",
                        dateCreated: new Date(),
                        dateUpdated: new Date(),
                        intval: it,
                        longval: (Integer.MAX_VALUE as Long)+ it,
                        doubleval: Float.MAX_VALUE + it,
                        floatval: (it + 0.1) as Float,
                        props: ["key-1" : "value-1", "key-2": "value-2"],
                        isActive: it % 2 == 0
                        )
            5.times{ commentNum ->
              message.addToComments( new Comment( title: "title-${it}-${commentNum}", name: "name-${it}-${commentNum}") )
            }

            assert message.save()

        }
    }
    def destroy = {
    }
}
