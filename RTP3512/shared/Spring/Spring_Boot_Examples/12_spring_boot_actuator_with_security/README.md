1. By default actuator end points are secured, that means user has to login and should have ACTUATOR role.
	The actuator end points are secured because of the below property
				management.security.enabled=true
2. Hence if you are using actuator in secure mode, then the user with which you access actuator end points should have ROLE_ACTUATOR role (add in the database).
