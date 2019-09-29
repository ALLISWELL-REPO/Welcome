1. Only class level request mapping - ClassLevelRequestMapping
2. Only method level request mapping - MethodLevelRequestMapping
3. Class and method level request mapping - ClassAndMethodLevelRequestMapping
4. Request mapping from properties file - RequestMappingFromProperties
5. Request mapping using http headers - RequestMappingUsingHeader
6. Request mapping using request params - RequestMappingUsingRequestParams
7. Request mapping with regular expressions - RequestMappingUsingRegularExpression
8. Request mapping with wild cards - RequestMappingWithWildCards
9. Different rules of url mappings with wild cards - DifferentUrlMappingRules


Wild cards (Ant Patterns)
-------------------------
? - matches exactly one character
* - matches zero or more characters until the next "/" path separator is found
** - matches zero or more directories (/) in a path, that is it can match multiple path separators in the path

The priority of these wild card mappings are as below
? - highest priority
* - second priority
** - last priority

Path matching rules
-------------------------
When a URL qualifies for more than one pattern, then a sorting will be applied to match a particular pattern
The sorting rule always try to match to as specific pattern as possible

Rules are defined as below
1. A pattern with lower count of URI variables and wild cards is considered more specific
 		/helloWorld/ruleone/{name}/* (one URI variable and one wild card, total count is 2)
 		/helloWorld/ruleone/{name}/** (one URI variable and two wild cards, each * is a wild card, total count is 3)
	In this case the first URI pattern is preferred, because it has lesser count.
	
2. If two patterns have the same number of URI variables and wild cards then the lengthier URI is chosen
		/helloWorld/ruletwo/spring/* (one wild card, but lengthier)
		/helloWorld/ruletwo/* 	  	 (one wild card)
	The first one is chosen as it is lengthier.
	
3. If two patterns have the same number of URI variable wild card count and having same length, then the pattern with lesser number of wild cards will be chosen
		/helloWorld/rulethree/{name} 
		/helloWorld/rulethree/*
	The first pattern will be chosen as it has lesser number of wild cards.
	
One exclusion for the above rules is that if the URL using from the browser or application is not ending with '/' at the end, then more generic URL pattern will be chosen.

	