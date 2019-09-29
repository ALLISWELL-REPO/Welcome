1. All the @Configuration marked class configurations will be loaded into the dispatcher servlet
 context by default if they are not referred to as root config in
  `AbstractAnnotationConfigDispatcherServletInitializer` class
  Example: Create RootConfigOne and RootConfigTwo, loaded different packages, refer to one another 
   in any class. All should be accessible. But this is exception
   in one case, you cannot refer to RootConfig configuration loaded classes in MvcConfig loaded classes
   because of the order of loading, first MvcConfig and then rest of RootConfig. To make the RootConfig
   class loaded beans available in MvcConfig loaded beans, you need to add RootConfig in root context.
  
2. Child context can access from parent context but other way around is not possible