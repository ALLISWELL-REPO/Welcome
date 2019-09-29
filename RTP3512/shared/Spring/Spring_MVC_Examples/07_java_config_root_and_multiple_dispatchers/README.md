1. We can have multiple dispatcher servlets sharing a common root context
we can create three different `WebApplicationInitializer` implementations each one to initialize root context, 
dispatcher one context and dispatcher two context respectively.
But it is suggested to have only one initializer for the complete application and initialize all contexts there.