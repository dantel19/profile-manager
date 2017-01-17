<%@page import="it.univaq.incipict.profilemanager.business.model.User"%>
<%@page import="it.univaq.incipict.profilemanager.business.model.Role"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="user_javascript.jsp"%>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               <spring:message code="user.detail.title" />
            </h2>
            <ul class="nav navbar-right panel_toolbox">
               <li><a class="collapse-link"><i
                     class="fa fa-chevron-up"></i></a></li>
            </ul>
            <div class="clearfix"></div>
         </div>
         <div class="x_content">
            <br />
            <form:form modelAttribute="user" id="user_form" action="${pageContext.request.contextPath}${requestScope.action}"  class="form-horizontal form-label-left" method="POST">
               <form:hidden path="id"/>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name"><spring:message code="user.firstname" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="name" type="text" name="name" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="surname"><spring:message code="user.lastname" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="surname" type="text" name="surname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><spring:message code="user.email" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="email" type="text" name="email" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password"><spring:message code="user.password" /> <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="password" type="password" name="password" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               
                <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="roles"><spring:message code="user.roles" /> <span class="required">*</span></label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                           <select id="roles" name="roles" class="select2_multiple form-control" multiple="multiple" required="required">
                               <%
                                  List<Long> roles = new ArrayList<Long>();
                                  for (Role role : ((User)pageContext.findAttribute("user")).getRoles()) {
                                     roles.add(role.getId());
                                  }
                                  
                                  for (Role role : (List<Role>) pageContext.findAttribute("availableRoles")) {
                                    if (roles.contains(role.getId())) {
                                       out.print("<option value=\"" + role.getId() + "\" selected=\"selected\">" + role.getName()+"</option>");
                                    } else {
                                       out.print("<option value=\"" + role.getId() + "\">"+role.getName()+"</option>");
                                      }
                                   }
                                %>
                           </select>
                        </div>
               </div>
                            
               <div class="ln_solid"></div>
               <div class="form-group">
                  <div
                     class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
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
            </form:form>
         </div>
      </div>
   </div>
</div>