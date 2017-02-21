<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.Profile"%>

<style>

ol.highlight {
  padding: 0;
  padding-left: 10px;
  padding-right: 10px;
  color: #ccc;
  list-style-type: none;
}

ol.highlight li {
  position: relative;
  font: bold italic 25px/1.5 Helvetica, Verdana, sans-serif;
  margin-bottom: 10px;
}

ol.highlight li p {
  font: 12px/1.5 Helvetica, sans-serif;
  padding-left: 60px;
  color: #555;
}

ol.highlight p {
  font: 12px/1.5 Helvetica, sans-serif;
  color: #555;
  margin-bottom: 2px;
}

span.absolute {
  position: absolute;
}
</style>

<div class="x_panel">
	<div class="x_title">
		<h2>
			Distances List <small>Similarity</small>
		</h2>
		<ul class="nav navbar-right panel_toolbox">
			<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
			<li><a class="close-link"><i class="fa fa-close"></i></a></li>
		</ul>
		<div class="clearfix"></div>
	</div>
	<div class="x_content">
		<span>Affinity with your profile: <br /><br /></span>
		<%
			@SuppressWarnings("unchecked")
			Map<Profile, Double> distancesMap = (HashMap<Profile, Double>)pageContext.findAttribute("distancesMap");
			
			if (distancesMap.isEmpty() || distancesMap == null) { out.print("<p> NULL, COMPLLLETA IL PROFILO!</p>"); }
			
			else {
			    int i = 1;
			   	out.print("<ol class=\"highlight\">");
				for (Map.Entry<Profile, Double> entry : distancesMap.entrySet()) {
				    if (i > 7) { 
				       out.print(
				       "<p class=\"highlight\">" 
				       + "<span><big><b>" + i++ + ".</b></big> </span>" + entry.getKey().getName() + ": " 
				       + "<b><big>" + entry.getValue() + "</big></b>"
				       + "</p>"
				       ); 
				    }
				    else {
				    	out.print(
				    	"<li>"
				    	+ "<span class=\"absolute\">" + i++ + ".</span>"
						+ "<p><b>" + entry.getKey().getName() + ":</b> " + entry.getKey().getDescription()
						+ "<br />Distance: <b><big>" + entry.getValue() + "</big></b>"
						+ "</p>" +
						"</li>"
						);
				    }
				}
				out.print("</ol>");
			}
		%>
		</div>
</div>