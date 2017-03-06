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
      <a class="hiddenanchor" id="informationset"></a>

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
        
        <section class="login_content">
	        <form action="${pageContext.request.contextPath}/user/create" method="POST">
		        <div id="register" class="animate form registration_form">
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
						<a href="#informationset" class="btn btn-theme btn-block to_register to_register_btn" style="margin:0;">
							<i class="fa fa-arrow-circle-right" aria-hidden="true"></i> Next
						</a>
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
		        </div>
		        
		        <div id="information-set" class="animate form informationset_form">
		            <h1>Select your favorites</h1>
		            <div class="row no-margin">
		            
			            <div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Storia dell'edificio e delle sue trasformazioni architettoniche</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Tecniche e materiali utilizzati nel consolidamento e nella mitigazione della vulnerabilità sismica</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Meccanismi di danno che hanno interessato un edificio</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Contesto culturale in cui è nata un opera</h5>
								<input type="checkbox" />
							</div>
						</div>
						
			            <div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Opere architettoniche</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Prestazioni energetiche dell'edificio</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Informazioni sulla messa in sicurezza di un edificio</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Espressioni intangibili e patrimoni culturali che caratterizzano una comunità, come tradizioni orali, arti dello spettacolo, feste, artigianato, cucina...</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Presenza di funzioni di automazione</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Mostre artistiche e/o fotografiche</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Funzioni di risparmio e ottimizzazione energia negli edifici</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Opere scultoree</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Quando sei fuori per lavoro, non ti interessa visitare la città, preferisci fare altro.</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Opere pittoriche e scultoree presenti nell'edificio</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Centri storici</h5>
								<input type="checkbox" />
							</div>
						</div>
						
						<div class="no-margin no-padding animated flipInY col-lg-3 col-md-3 col-sm-6 col-xs-12">
							<div class="tile-stats no-radius tilesCheckbox">
								<div class="icon">
									<i class="fa fa-check-square-o"></i>
								</div>
								<h5 class="hideOverflow">Reperti archeologici</h5>
								<input type="checkbox" />
							</div>
						</div>
		            
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
		        </div>
	        </form>
        </section>
        
      </div>
    </div> 
    
    <script src="${pageContext.request.contextPath}/resources/themes/gentelella/vendors/jquery/jquery.min.js"></script>
    <%@include file="login_javascript.jsp"%>
    
  </body>
</html>