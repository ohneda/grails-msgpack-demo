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
    
    static hasMany = [comments: Comment]
    
    
    
    static constraints = {
        optional nullable: true
    }
}
