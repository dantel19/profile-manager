<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="row">
   <div class="col-md-12 col-sm-12 col-xs-12">
      <div class="x_panel">
         <div class="x_title">
            <h2>
               Setting
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
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="name">Name <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="name" type="text" name="name" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="surname">Surname <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="surname" type="text" name="surname" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="email" type="text" name="email" required="required" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="form-group">
                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="password">Password <span class="required">*</span>
                  </label>
                  <div class="col-md-6 col-sm-6 col-xs-12">
                     <form:input path="password" type="password" name="password" required="required" readonly="true" class="form-control col-md-7 col-xs-12"/>
                  </div>
               </div>
               <div class="ln_solid"></div>
               <div class="form-group">
                  <div
                     class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                     <form:button type="reset" class="btn btn-primary">Cancel</form:button>
                     <form:button type="submit" class="btn btn-success">Submit</form:button>
                  </div>
               </div>
            </form:form>
         </div>
      </div>
   </div>
</div>