<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title><spring:message code="common.application.title" /></title>
   
    <link rel="icon" type="image/ico" href="${pageContext.request.contextPath}/resources/favicon.ico" />

    <%@include file="../layout/layout_css.jsp"%>
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath}/j_spring_security_check" method="post">
              <h1><spring:message code="common.signin" /></h1>
              <div>
                <input type="text" class="form-control" name="j_username" placeholder="<spring:message code="user.email" />" required="" />
              </div>
              <div>
                <input type="password" class="form-control" name="j_password" placeholder="<spring:message code="user.password" />" required="" />
              </div>
              <div>
               <button class="btn btn-theme btn-block" type="submit"> <i class="fa fa-lock"></i> <spring:message code="common.signin"/> </button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link"><spring:message code="common.new.member" />
                  <a href="#signup" class="to_register"> <spring:message code="common.create.account" /> </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-users"></i> <spring:message code="common.application.title" /></h1>
                  <p><%@include file="../common/copyright.jsp"%></p>
                </div>
              </div>
            </form>
          </section>
        </div>

        <div id="register" class="animate form registration_form">
          <section class="login_content">
            <form action="${pageContext.request.contextPath}/user/create" method="POST">
              <h1><spring:message code="common.create.account" /></h1>
              <div>
                <input name="firstname" type="text" class="form-control" placeholder="First Name" required="" />
              </div>
              <div>
                <input name="lastname" type="text" class="form-control" placeholder="Last Name" required="" />
              </div>
              <div>
                <input name="email" type="email" class="form-control" placeholder="Email" required="" />
              </div>
              <div>
                <input name="password" type="password" class="form-control" placeholder="Password" required="" />
              </div>
              <div>
                <button class="btn btn-theme btn-block" type="submit"><spring:message code="common.signup"/></button>
              </div>

              <div class="clearfix"></div>

              <div class="separator">
                <p class="change_link"><spring:message code="common.already.member"/>
                  <a href="#signin" class="to_register"> <spring:message code="common.signin"/> </a>
                </p>

                <div class="clearfix"></div>
                <br />

                <div>
                  <h1><i class="fa fa-users"></i> <spring:message code="common.application.title" /></h1>
                  <p><%@include file="../common/copyright.jsp"%></p>
                </div>
              </div>
            </form>
          </section>
        </div>
      </div>
    </div> 
  </body>
</html>