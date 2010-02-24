package net.ileto.jstools.jsunit.template

import groovy.text.SimpleTemplateEngine

class TestSuiteTemplate {
	private static String html = 
	'''<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Unit Tests</title>
<script src="$jsUnitCore"></script>
<script>
	function suite() {
		var suite = new top.jsUnitTestSuite();
	<% for(file in files) { %>
		suite.addTestPage("${file.toURI().toURL()}");
	<% } %>
		return suite;
	};
</script>
</head>
<body>
</body>
</html>
'''
	
	String process(Map<String,Object> model) {
		def engine = new SimpleTemplateEngine()
		def template = engine.createTemplate(html)
		return template.make(model).toString()
	}
}