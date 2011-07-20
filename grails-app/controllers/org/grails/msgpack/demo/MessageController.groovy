package org.grails.msgpack.demo

import grails.converters.JSON;

class MessageController {

    def messageService

    def show = {
        def message = messageService.get(params.int('id'))
        assert message
        render message as JSON
    }

    def save = {

        def jsonObject = request.JSON

        def comments = jsonObject.comments
        jsonObject.comments = null

        def message = new Message( jsonObject )
        message.props = jsonObject.props

        message.comments =[]
        comments.each{ c->
            def comment = new Comment(c)
            comment.message = message
            message.addToComments(comment)
        }

        def result = messageService.save(message)
        render result as JSON
    }

    def update = {
        def jsonObject = request.JSON

        def message = new Message( jsonObject )
        message.id = params.int('id')
        message.props = jsonObject.props

        def result = messageService.update(message)
        render result as JSON
    }

    def delete = {
        messageService.delete(params.int('id'))
        def result = [id: "${params.id}"]
        render result as JSON
    }
}
