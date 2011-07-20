package org.grails.msgpack.demo

class Message {

    String string
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
    
    static hasMany = [comments: Comment]
    
    static constraints = {
        optional nullable: true
    }
    static mapping = {comments lazy: false}
}
