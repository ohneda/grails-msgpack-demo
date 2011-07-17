class UrlMappings {

    static mappings = {
        "/message/$id?"(resource:"message")
        "/$controller/$action?/$id?"{ constraints { // apply constraints here
            } }

        "/"(view:"/index")
        "500"(view:'/error')
    }
}
