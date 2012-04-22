class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/identification/login")
		"500"(view:'/error')
		"/home"(view:"/home/private_home")
	}
}
