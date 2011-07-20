package org.grails.msgpack.demo

class MessageService {

    static expose=['msgpack']
    static transactional = true

    Message get(Long id) {
        assert id
        def result = Message.get(id)
        log.debug("get message: ${result.dump()}")
        result
    }

    Message save(Message message){
        log.debug("save message: ${message?.dump()}")
        message.dateCreated = new Date()
        message.dateUpdated = new Date()
        saveOrUpdate(message)
    }

    Message update(Message message){
        log.debug("update message: ${message?.dump()}")
        def target = Message.get(message.id)
        def comments = target.comments
        def dateCreated = target.dateCreated
        target.properties = message.properties

        target.comments = comments
        target.dateCreated = dateCreated
        target.dateUpdated = new Date()
        saveOrUpdate(target)
    }

    Long delete(Long id){
        log.debug("delete message: ${id}")
        def target = Message.get(id)
        log.debug(target?.dump() )
        target.delete()
        id
    }

    Message saveOrUpdate(Message message){
        log.debug("saveOrUpdate: ${message?.dump()}")
        message.save()
        log.debug(message.errors)
        message
    }

}
