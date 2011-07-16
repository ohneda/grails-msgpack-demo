package org.grails.msgpack.demo

class MessageService {

    static transactional = true

    def get(Integer id) {
        assert id
        Message.get(id)
    }
}
