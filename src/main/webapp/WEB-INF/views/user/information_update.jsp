<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.User"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.Information"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="user_javascript.jsp"%>

<div class="row">
	<form:form modelAttribute="user" id="user_information_list" action="${pageContext.request.contextPath}${requestScope.action}"  class="form-horizontal form-label-left" method="POST">
		<form:hidden path="id"/>
		<form:hidden path="firstname"/>
		<form:hidden path="lastname"/>
		<form:hidden path="email"/>
		<form:hidden path="password"/>
		<c:forEach var="role" items="${user.roles}">
                            <form:hidden path="roles" value="${role.id}"/>
        </c:forEach>
	
		<div class="col-md-12 col-sm-12 col-xs-12">
			<div class="x_panel">
				<div class="x_title">
					<h2>
						<spring:message code="information.list.title" />
					</h2>
					<ul class="nav navbar-right panel_toolbox">
						<li><a href="${pageContext.request.contextPath}/user/information/update?id=${user.id}"><i class="fa fa-refresh"></i></a></li>
						<li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a></li>
					</ul>
					<div class="clearfix"></div>
				</div>
				<div class="x_content">
				
					<p class="text-muted font-13 m-b-30"></p>
					<table id="information_list"
						class="table table-striped table-bordered dt-responsive th-noborder"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th></th>
								<th><spring:message code="information.description" /></th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th class="hidden-pm"></th><th></th>
							</tr>
						</tfoot>
						<tbody>
							<%
							   List<Long> informationSet = new ArrayList<Long>();
							   for (Information information : ((User) pageContext.findAttribute("user")).getInformationSet()) {
							      informationSet.add(information.getId());
							   }
	
							   for (Information information : ((List<Information>) pageContext.findAttribute("informationList"))) {
							      out.println("<tr>");
							      out.println("<td class=\"dt-body-center sorting_1\" tabindex=\"0\">");
							      if (informationSet.contains(information.getId())) {
							         out.println(
							               "<input type=\"checkbox\" path=\"informationSet\" name=\"informationSet\" class=\"flat\" value=\"" + information.getId() + "\" checked>");
							      } else {
							         out.println("<input type=\"checkbox\" path=\"informationSet\" name=\"informationSet\" class=\"flat\" value=\"" + information.getId()
							               + "\">");
							      }
							      out.println("</td>");
							      out.println("<td>" + information.getDescription().replace("'", "&rsquo;") + "</td>");
							      out.println("</tr>");
							   }
							%>
						</tbody>
					</table>
					
					<br />
				    <div class="form-group">
				       <div
				          class="col-xs-12">
				          <form:button type="reset" class="btn btn-warning"><spring:message code="common.reset" /></form:button>
				          <a href="${pageContext.request.contextPath}${requestScope.action_cancel}" class="btn btn-info"><spring:message code="common.cancel"/></a>
				          <c:choose>
				             <c:when test="${requestScope.view_type == 'update'}">
				                <form:button type="submit" class="btn btn-success"><spring:message code="common.update" /></form:button>
				             </c:when>
				             <c:when test="${requestScope.view_type == 'create'}">
				                <form:button type="submit" class="btn btn-success"><spring:message code="common.create" /></form:button>
				             </c:when>
				             <c:when test="${requestScope.view_type == 'delete'}">
				                <form:button type="submit" class="btn btn-danger"><spring:message code="common.delete" /></form:button>
				             </c:when>
				          </c:choose>
				       </div>
				    </div>
				    <br />
					
				</div>
			</div>
		</div>
		</form:form>
</div>
