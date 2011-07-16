package org.grails.msgpack.demo

import grails.converters.JSON;

class MessageController {

    def messageService
    def show = {
        def message = messageService.get(params.int('id'))
        assert message
        render message as JSON
    }
}
