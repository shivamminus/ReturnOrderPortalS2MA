<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>
<html lang="en">
   <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- Bootstrap CSS -->
      <link
         href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
         rel="stylesheet"
         integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
         crossorigin="anonymous">
      <title>Login Page</title>
      <link rel="stylesheet"
         href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
      <style>
         body {
         background: #222D32;
         font-family: 'Roboto', sans-serif;
         }
         .login-box {
         margin-top: 200px;
         height: auto;
         background: #1A2226;
         text-align: center;
         box-shadow: 0 3px 6px rgba(0, 0, 0, 0.16), 0 3px 6px rgba(0, 0, 0, 0.23);
         /* border: 1px dotted #27EF9F; */
         }
         .login-key {
         height: 100px;
         font-size: 80px;
         line-height: 100px;
         /* background: -webkit-linear-gradient(#27EF9F, #0DB8DE); */
         background-clip: text;
         -webkit-text-fill-color: transparent;
         }
         .login-title {
         margin-top: 15px;
         text-align: center;
         font-size: 30px;
         letter-spacing: 2px;
         margin-top: 15px;
         font-weight: bold;
         /* color: #ECF0F5; */
         color: #27EF9F;
         }
         .login-form {
         margin-top: 25px;
         text-align: left;
         }
         input[type=text] {
         background-color: #1A2226;
         border: none;
         border-bottom: 2px solid #0DB8DE;
         border-top: 0px;
         border-radius: 0px;
         font-weight: bold;
         outline: 0;
         margin-bottom: 20px;
         padding-left: 0px;
         color: #ECF0F5;
         }
         input[type=password] {
         background-color: #1A2226;
         border: none;
         border-bottom: 2px solid #0DB8DE;
         border-top: 0px;
         border-radius: 0px;
         font-weight: bold;
         outline: 0;
         padding-left: 0px;
         margin-bottom: 20px;
         color: #ECF0F5;
         }
         .form-group {
         margin-bottom: 40px;
         outline: 0px;
         }
         .form-control:focus {
         border-color: inherit;
         -webkit-box-shadow: none;
         box-shadow: none;
         border-bottom: 2px solid #0DB8DE;
         outline: 0;
         background-color: #1A2226;
         color: #ECF0F5;
         }
         input:focus {
         outline: none;
         box-shadow: 0 0 0;
         }
         label {
         margin-bottom: 0px;
         }
         .form-control-label {
         font-size: 20px;
         color: #6C6C6C;
         font-weight: bold;
         letter-spacing: 1px;
         }
         .btn-outline-primary {
         border-color: #0DB8DE;
         color: #0DB8DE;
         border-radius: 0px;
         font-weight: bold;
         letter-spacing: 1px;
         box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
         }
         .btn-outline-primary:hover {
         background-color: #0DB8DE;
         right: 0px;
         }
         .login-btm {
         float: right;
         }
         .login-button {
         padding-right: 0px;
         text-align: right;
         margin-bottom: 25px;
         /* margin-right: 10px; */
         border-radius: 20px;
         }
         .login-text {
         text-align: left;
         padding-left: 0px;
         color: #A2A4A4;
         }
         .loginbttm {
         padding: 0px;
         }
         button {
         font-weight: 30px;
         }
      </style>
   </head>
   <body>
      <div class="container">
      <div class="row">
         <div class="col-lg-3 col-md-2"></div>
         <div class="col-lg-6 col-md-8 login-box">
            <div class="col-lg-12 login-key">
               <img src="https://trello-attachments.s3.amazonaws.com/60afcdd60446864934b83005/496x503/ebd357883d23eb3c14f0afe8609989f0/ROM.png" style="width: 100px; height: 100px;">
            </div>
            <div class="col-lg-12 login-title">Return Order Management</div>
            <div class="col-lg-12 login-form">
               <div class="col-lg-12 login-form">
                  <form:form method="post" modelAttribute="loginModel"
                     action="/login">
                     <spring:bind path="userName">
                        <div class="form-group ">
                           <label for="userName">Username</label>
                           <form:input path="userName" type="text"
                              class="form-control ${status.error ? 'is-invalid' : ''}"
                              id="userName" placeholder="Username" />
                           <form:errors path="userName" class="invalid-feedback" />
                        </div>
                     </spring:bind>
                     <spring:bind path="password">
                        <div class="form-group ">
                           <label for="password">Password</label>
                           <form:input path="password" type="password"
                              class="form-control ${status.error ? 'is-invalid' : ''}"
                              id="password" placeholder="Password" />
                           <form:errors path="password" class="invalid-feedback" />
                        </div>
                     </spring:bind>
                     <div class="col-lg-12 loginbttm">
                        <div class="col-lg-6 login-btm login-text">
                           <!-- Error Message -->
                        </div>
                        <div class="col-lg-6 login-btm login-button">
                           <button type="submit" class="btn btn-outline-primary"
                              style="font-size: 25px;">LOGIN</button>
                        </div>
                     </div>
                  </form:form>
                  <span style="color: red; font-weight: bold">${error }</span>
               </div>
            </div>
            <div class="col-lg-3 col-md-2"></div>
         </div>
      </div>
   </body>
</html>