1. By default actuator end points are secured, that means user has to login and should have ACTUATOR role.
	To disable it use,
				management.security.enabled=false
				
2. We can also set context path for management APIs, using the below property
				management.context-path
				
3. Disable some individual actuator end points using the below property
				endpoints.{end point id}.enabled
				endpoints.shutdown.enabled=false
				
4. The complete end points can be disabled using below property
				endpoints.enabled=false
				
5. Refer spring documentation for actuator end points