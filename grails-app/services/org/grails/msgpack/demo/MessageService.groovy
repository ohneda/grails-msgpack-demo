package org.grails.msgpack.demo

class MessageService {

    static expose=['msgpack']
    static transactional = true

    Message get(Long id) {
        assert id
        def result = Message.get(id)
        log.debug("get: ${result.dump()}")
        result
    }
}
