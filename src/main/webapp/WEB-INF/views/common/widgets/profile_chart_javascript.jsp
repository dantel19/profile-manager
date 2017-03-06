<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.Profile"%>

<% 
	@SuppressWarnings("unchecked")
	Map<Profile, Double> distancesMap = (HashMap<Profile, Double>)pageContext.findAttribute("distancesMap");
	@SuppressWarnings("unchecked")
	Map<Profile, Float> percentages = (HashMap<Profile, Float>)pageContext.findAttribute("percentagesMap");
%>

<script type="text/javascript" charset="utf-8">
$(document).ready(function() {
    Chart.defaults.global.legend = {
      enabled: false
    };

    // Doughnut chart
    var ctx = document.getElementById("canvasDoughnut");
    var data = {
      labels: [
         <%
	        for (Map.Entry<Profile, Double> entry : distancesMap.entrySet()) {
	   	    	out.print("\"" + entry.getKey().getName() + "\", ");
	   		}
         %>
      ],
      datasets: [{
        data: [
           <%
        		for (Map.Entry<Profile, Float> entry : percentages.entrySet()) {
        	    	out.print(entry.getValue() + ", ");
        	}
        	%>
        	],
        backgroundColor: [
          "#455C73",
          "#9B59B6",
          "#BDC3C7",
          "#26B99A",
          "#3498DB",
          "#FF8080",
          "#FFFF80",
          "#FFE0F5",
          "#1F45FC",
          "#C2FF91",
          "#E0A175",
          "#82C168",
          "#009F82"
        ],
      }]
    };

    var canvasDoughnut = new Chart(ctx, {
      type: 'doughnut',
      tooltipFillColor: "rgba(51, 51, 51, 0.55)",
      data: data,
      options: {
         tooltips: {
            mode: 'label',
            callbacks: {
                label: function(tooltipItem, data) {
                    return ' ' + data['labels'][tooltipItem['index']] + ': ' + data['datasets'][0]['data'][tooltipItem['index']] + '%';
                }
            }
        },
      }
    });
    
    document.getElementById("canvasDoughnut-Legend").innerHTML = canvasDoughnut.generateLegend();
});
</script>