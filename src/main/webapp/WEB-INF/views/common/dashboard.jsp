TODO
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.Profile"%>

<p> ${nomemio} <br />
<%
	Map<Profile, Double> distances = (HashMap<Profile, Double>)pageContext.findAttribute("distancesMap");
	if (distances.isEmpty() || distances == null) { out.print("<p> NULL, COMPLETA IL PROFILO!</p>"); }
	else {
		for (Map.Entry<Profile, Double> entry : distances.entrySet()) {
	    	out.print("<br />Profile: " +entry.getKey().getName() + " / " + entry.getValue());
		}
	}
%>




</p>