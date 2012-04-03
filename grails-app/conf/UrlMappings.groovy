class UrlMappings {

	static mappings = {
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
		
		"/membre/sucess"(view:"/membre/create_sucess")
		"/identification/index"(view:"/identification/home")
	}
}
