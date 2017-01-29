<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               <spring:message code="user.settings.title" />
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
               <c:forEach var="role" items="${user.roles}">
                            <form:hidden path="roles" value="${role.id}"/>
               </c:forEach>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="firstname"><spring:message code="user.firstname" /><span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="firstname" type="text" name="firstname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="lastname"><spring:message code="user.lastname" /><span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="lastname" type="text" name="lastname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email"><spring:message code="user.email" /><span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="email" type="text" name="email" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password"><spring:message code="user.password" /><span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="password" type="password" name="password" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="ln_solid"></div>
               <div class="form-group">
                  <div
                     class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                     <form:button type="reset" class="btn btn-primary"><spring:message code="common.cancel" /></form:button>
                     <form:button type="submit" class="btn btn-success"><spring:message code="common.submit" /></form:button>
                  </div>
               </div>
            </form:form>
         </div>
      </div>
   </div>
</div>