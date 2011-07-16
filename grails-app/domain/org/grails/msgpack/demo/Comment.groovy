package org.grails.msgpack.demo

class Comment {

    String title
    String name

    static belongsTo = [message: Message]

    static constraints = {
    }

}
