<!-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>. -->
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Details</title>
    <!-- Bootstrap CSS -->

    <!-- <link rel="stylesheet" href="second.css"> -->
    <link href="https://fonts.googleapis.com/css?family=Oswald:400" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">

    
    
    <style>
        *,
        *::before,
        *::after {
            box-sizing: border-box;
        }

        html,
        body {
            min-height: 100%;
            font-family: 'Roboto', sans-serif;
        }

        #bodyComponent {
            background-color: #222D32;
            /* background-color: whitesmoke; */

        }

        /*-------------------- Button ends --------------------*/
        .btn {
            display: block;
            padding: 15px 15px;
            border-radius: 5px;
            position: relative;
        }
 /*-------------------- Button ends --------------------*/

        /*-------------------- Form --------------------*/
        .form fieldset {
            border: none;
            padding: 0;

        }

        .form fieldset.fieldset-expiration {
            float: left;
            width: 60%;
        }

        .form fieldset.fieldset-expiration .select {
            width: 120px;
            margin-right: 20px;
            float: left;
        }

        .form fieldset.fieldset-ccv {
            clear: none;
            float: right;
            width: 86px;
        }

        .form fieldset label {
            display: block;
            text-transform: uppercase;
            font-size: 17px;
            /* color: #27ef9f; */
            color: black;
            margin-bottom: 15px;
            margin-top: 15px;
            font-weight: bold;
            font-family: 'Roboto', sans-serif;
        }

        .form fieldset input,
        .form fieldset .select {
            width: 100%;
            height: 50px;
            color: rgb(59, 59, 59);
            /* padding: 10px; */
            border-radius: 5px;
            font-size: 20px;
            font-weight: bold;
            outline: none !important;
            border: 1px solid black;
            box-shadow: inset 0 1px 4px black;
        }

        .form fieldset input.input-cart-number,
        .form fieldset .select.input-cart-number {
            width: 93%;
            display: inline-block;
            padding: 8px;
            margin-right: 8px;
        }

        .form fieldset input.input-cart-number:last-child,
        .form fieldset .select.input-cart-number:last-child {
            margin-right: 0;
        }

        .form fieldset .select {
            position: relative;
        }

        .form fieldset .select::after {
            content: '';
            border-top: 8px solid black;
            border-left: 4px solid transparent;
            border-right: 4px solid transparent;
            position: absolute;
            z-index: 2;
            top: 14px;
            right: 10px;
            pointer-events: none;
        }

        .form fieldset .select select {
            appearance: none;
            position: absolute;
            padding: 0;
            border: none;
            width: 100%;
            outline: none !important;
            top: 6px;
            left: 6px;
            background: none;
        }

        .form fieldset .select select :-moz-focusring {
            color: transparent;
            text-shadow: 0 0 0 #000;
        }

        .form button {
            width: 100%;
            outline: none !important;
            background: linear-gradient(180deg, #27EF9F, #0DB8DE);
            text-transform: uppercase;
            font-weight: bolder;
            font-size: 20px;
            border: none;
            box-shadow: none;
            text-shadow: 0 1px 2px rgba(240, 7, 7, 0.2);
            margin-top: 90px;
        }

        .form button .fa {
            margin-right: 6px;
        }

        .fieldset-type {
            width: 200px;
        }

        #component-type {
            width: 193px;
            color: black;
            /* background: #1A2226; */
        }

        #component-qty {
            max-width: 200px;
            color: black;
            /* background: #1A2226; */
        }

        #card-holder-name {
            max-width: 400px;
            color: black;
            font-weight: 29px;
        }

        #mainTable {
            margin-left: 21%;
            /* margin-top: 50px; */
        }

        #innerTable {
            /* padding-left: 50px; */
            margin-left: 50px;
            width: 900px;
            /* border: 4px solid red; */
        }

        #card-expiration-month,
        #card-expiration-year,
        #component-priority {
            color: black;
            /* background: #1A2226; */
        }

        /*-------------------- Checkout --------------------*/
        .checkout {
            margin: 150px auto 30px;
            position: relative;
            width: 1100px;
            /* background: #1A2226; */
            background: white;
            border-radius: 15px;
            padding: 160px 45px 30px;
            /* box-shadow: 0 5px 5px whitesmoke; */
            height: auto;

            margin-top: 210px;
        }

        #submitButton {
            margin-left: 235px;
            width: 500px;
        }

        /*-------------------- Credit Card --------------------*/
        .credit-card-box {
            perspective: 1000;
            width: 400px;
            height: 280px;
            position: absolute;
            top: -112px;
            left: 50%;
            transform: translateX(-50%);
        }

        .credit-card-box:hover .flip,
        .credit-card-box.hover .flip {
            transform: rotateY(180deg);
        }

        .credit-card-box .front,
        .credit-card-box .back {
            width: 400px;
            height: 250px;
            border-radius: 15px;
            backface-visibility: hidden;
            background: linear-gradient(135deg, #0DB8DE, #27EF9F);
            position: absolute;
            color: black;
            font-family: Inconsolata;
            top: 0;
            left: 0;
            text-shadow: 0 1px 1px #27EF9F;
            box-shadow: 0 1px 6px #27EF9F;
        }

        .credit-card-box .front::before,
        .credit-card-box .back::before {
            content: '';
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            background: url('http://cdn.flaticon.com/svg/44/44386.svg') no-repeat center;
            background-size: cover;
            opacity: 0.05;
        }

        .credit-card-box .flip {
            transition: 0.6s;
            transform-style: preserve-3d;
            position: relative;
        }

        .credit-card-box .logo {
            position: absolute;
            top: 9px;
            right: 20px;
            width: 60px;
        }

        .credit-card-box .logo svg {
            width: 100%;
            height: auto;
            fill: #000;
        }

        .credit-card-box .front {
            z-index: 2;
            transform: rotateY(0deg);
        }

        .credit-card-box .back {
            transform: rotateY(180deg);
        }

        .credit-card-box .back .logo {
            top: 185px;
        }

        .credit-card-box .chip {
            position: absolute;
            width: 60px;
            height: 45px;
            top: 20px;
            left: 20px;
            background: linear-gradient(135deg, #512880 0%, #eef5f8 44%, #080807 100%);
            border-radius: 8px;
        }

        .credit-card-box .chip::before {
            content: '';
            position: absolute;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            margin: auto;
            border: 4px solid rgba(128, 128, 128, .1);
            width: 80%;
            height: 70%;
            border-radius: 5px;
        }

        .credit-card-box .strip {
            background: linear-gradient(135deg, #19181b 10%, #eef5f8 44%, #080807);
            position: absolute;
            width: 100%;
            height: 50px;
            top: 30px;
            left: 0;
        }

        .credit-card-box .number {
            position: absolute;
            margin: 0 auto;
            top: 103px;
            left: 19px;
            font-size: 38px;
        }

        .credit-card-box label {
            font-size: 10px;
            letter-spacing: 1px;
            text-shadow: none;
            text-transform: uppercase;
            font-weight: normal;
            opacity: 0.5;
            display: block;
            margin-bottom: 3px;
        }

        .credit-card-box .card-holder,
        .credit-card-box .card-expiration-date {
            position: absolute;
            margin: 0 auto;
            top: 180px;
            left: 19px;
            font-size: 22px;
            font-weight: bolder;
            text-transform: capitalize;
            color: black;
        }

        .credit-card-box .card-expiration-date {
            text-align: right;
            left: auto;
            right: 20px;
            color: #000;
        }

        .credit-card-box .ccv {
            height: 36px;
            background: #fff;
            width: 91%;
            border-radius: 5px;
            top: 110px;
            left: 0;
            right: 0;
            position: absolute;
            margin: 0 auto;
            color: #000;
            text-align: right;
            padding: 10px;
        }

        .credit-card-box .ccv label {
            margin: -25px 0 14px;
            color: #000;
            font-weight: bolder;
            font-size: 11px;
        }

        .the-most {
            position: fixed;
            z-index: 1;
            bottom: 0;
            left: 0;
            width: 50vw;
            max-width: 200px;
            padding: 10px;
        }

        .the-most img {
            max-width: 100%;
        }

        /* Credit Card ends   */
        
        #cardnumber {
            padding-right: 100px;
        }

        @import url("https://fonts.googleapis.com/css?family=Montserrat");

        body {
            background: #2f2f31;
            transform: rotateX(0.003deg);
            height: 100vh;
            color: #fff;
        }


        #submitButton {
            left: 24%;
            transform: translate(-50%, -50%);
            color: #222D32;
            text-decoration: none;
            display: inline-block;
            font-family: Montserrat;
            text-transform: uppercase;
            border: 2px solid#27EF9F;
            transition: 0.02s 0.2s cubic-bezier(0.1, 0, 0.1, 1);
        }

        #submitButton::before {
            content: "";
            display: inline-block;
            position: absolute;
            top: 0;
            left: 0;
            right: 100%;
            bottom: 0;
            background: whitesmoke;
            transition: 0.3s 0.2s cubic-bezier(0.1, 0, 0.1, 1), left 0.3s cubic-bezier(0.1, 0, 0.1, 1);
            z-index: -1;
        }

        #submitButton::after {
            content: "";
            display: inline-block;
            background-image: url("https://image.flaticon.com/icons/png/128/109/109617.png");
            /* background: white; */
            position: absolute;
            top: 0;
            left: calc(100% - 3em);
            right: 3em;
            bottom: 0;
            background-size: 1.5em;
            background-repeat: no-repeat;
            background-position: center;
            transition: right 0.3s cubic-bezier(0.1, 0, 0.1, 1);
        }


        #submitButton:hover::before {
            left: calc(100% - 3em);
            right: 0;
            transition: 0.3s cubic-bezier(0.1, 0, 0.1, 1), left 0.3s 0.2s cubic-bezier(0.1, 0, 0.1, 1);
        }

        #submitButton:hover::after {
            right: 0;
            transition: right 0.3s 0.2s cubic-bezier(0.1, 0, 0.1, 1);
        }

        .aboutUs,
        .logOut {
            font-size: 20px;
            font-weight: bold;
            color: white;
            /* background-color: #27EF9F; */

        }

        .navbarFixed {
            position: fixed;
            overflow: hidden;
            z-index: 50;
        }

    </style>
</head>

<body id="bodyComponent">
    <script>
        document.getElementById("submitButton").addEventListener("click", function (event) {
            event.preventDefault()
        });
    </script>

    <!-- Navbar -->    
    
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <img src="https://trello-attachments.s3.amazonaws.com/60afcdd60446864934b83005/496x503/ebd357883d23eb3c14f0afe8609989f0/ROM.png"
            style="width: 50px; height: 50px;" alt="">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link aboutUs" href="#">
                        <i class="fa fa-info-circle" aria-hidden="true" style="margin-left: 15px;"></i>
                        About Us </a>
                </li>

            </ul>
            <form class="form-inline my-2 my-lg-0">
                <a class="nav-link logOut" href="/logout">
                    <i class="fa fa-sign-out" aria-hidden="true"></i>
                    Logout</a>
            </form>

        </div>
    </nav>


    <!-- Navbar ends -->


    <table id="mainTable">
        <tbody>
            <tr>
                <td>
                    <div class="checkout">
                        <div class="credit-card-box">
                            <div class="flip">
                                <div class="front">
                                    <div class="chip"></div>
                                    <div class="logo">
                                        <svg version="1.1" id="visa" xmlns="http://www.w3.org/2000/svg"
                                            xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="47.834px"
                                            height="47.834px" viewBox="0 0 47.834 47.834"
                                            style="enable-background: new 0 0 47.834 47.834;">
                                        </svg>
                                    </div>
                                    <div class="number"></div>
                                    <div class="card-holder">
                                        <label>Card holder</label>
                                        <div></div>
                                    </div>
                                    <div class="card-expiration-date">
                                        <label>Expires</label>
                                        <div></div>
                                    </div>
                                </div>
                                <div class="back">
                                    <div class="strip"></div>
                                    <div class="logo">
                                        <svg version="1.1" id="visa" xmlns="http://www.w3.org/2000/svg"
                                            xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="47.834px"
                                            height="47.834px" viewBox="0 0 47.834 47.834"
                                            style="enable-background: new 0 0 47.834 47.834;">
                                        </svg>
                                    </div>
                                    <div class="ccv">
                                        <label>CCV</label>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Credit card photo code ends here -->
                        <div>
                            <div class="form">
                                <table id="innerTable">
                                    <form class="form" method="post" modelAttribute="orderModel" action="/order">
                                        <tr>
                                            <td>
                                                <fieldset>
                                                    <label for="card-holder-name">Card Holder Name </label> <input
                                                        type="text" id="card-holder-name" path="userName"
                                                        placeholder="First name" name="userName" required>
                                                </fieldset>
                                            </td>
                                            <td>
                                                <fieldset>
                                                    <label for="Contact-number">Contact Number</label> <input
                                                        type="text" id="Contact-number" maxlength="10"
                                                        pattern="[1-9]{1}[0-9]{9}" placeholder="Contact Number"
                                                        name="contactNumber" required />
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset id="cardnumber">
                                                    <label for="card-number">Card Number</label> <input type="text"
                                                        id="card-number" class="input-cart-number" maxlength="16"
                                                        placeholder="Enter Credit Card Number" name="creditCardNumber"
                                                        required />
                                                </fieldset>
                                            </td>
                                            <td>
                                                <fieldset>
                                                    <label for="card-holder">Card Limit</label> <input type="number"
                                                        id="card-holder" max="1000000" value="100000"
                                                        name="cardLimit" />
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset class="fieldset-expiration">
                                                    <label for="card-expiration-month">Expiration date</label>
                                                    <div class="select">
                                                        <select id="card-expiration-month">
                                                            <option>Month</option>
                                                            <option>01</option>
                                                            <option>02</option>
                                                            <option>03</option>
                                                            <option>04</option>
                                                            <option>05</option>
                                                            <option>06</option>
                                                            <option>07</option>
                                                            <option>08</option>
                                                            <option>09</option>
                                                            <option>10</option>
                                                            <option>11</option>
                                                            <option>12</option>
                                                        </select>
                                                    </div>
                                                    <div class="select">
                                                        <select id="card-expiration-year">
                                                            <option>Year</option>
                                                            <option>2022</option>
                                                            <option>2023</option>
                                                            <option>2024</option>
                                                            <option>2025</option>
                                                            <option>2026</option>
                                                            <option>2027</option>
                                                            <option>2028</option>

                                                        </select>
                                                    </div>
                                                </fieldset>
                                            </td>
                                            <td>
                                                <table>
                                                    <tr>
                                                        <td>
                                                            <fieldset class="fieldset-ccv">
                                                                <label for="card-ccv">CVV</label> <input type="text"
                                                                    id="card-ccv" maxlength="3" placeholder="CVV" />
                                                            </fieldset>
                                                        </td>
                                                    </tr>
                                                </table>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset class="fieldset-type">
                                                    <label for="component-type">Component Type</label>
                                                    <div class="select">
                                                        <select id="component-type" name="componentType">
                                                            <option>Select Type</option>
                                                            <option>Integral</option>
                                                            <option>Accessory</option>
                                                        </select>
                                                    </div>
                                                </fieldset>
                                            </td>
                                            <td>
                                                <fieldset>
                                                    <label for="card-holder">Component Name </label> <input type="text"
                                                        id="card-holder" name="componentName"
                                                        placeholder="Component Name" />
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                <fieldset id="component-qty">
                                                    <label for="component-qty"> Quantity</label>
                                                    <div class="select">
                                                        <select id="component-qty" name="quantity">
                                                            <option>Quantity</option>
                                                            <option>01</option>
                                                            <option>02</option>
                                                            <option>03</option>
                                                            <option>04</option>
                                                            <option>05</option>
                                                        </select>
                                                    </div>
                                                </fieldset>
                                            </td>
                                            <td>
                                                <fieldset id="component-priority">
                                                    <label for="component-priority">Priority Status</label>
                                                    <div class="select">
                                                        <select id="component-priority" name="isPriorityRequest">
                                                            <option>Select</option>
                                                            <option>Yes</option>
                                                            <option>No</option>
                                                        </select>
                                                    </div>
                                                </fieldset>
                                            </td>
                                        </tr>
                                        <tr>
                                            <table>
                                                <tr>
                                                    <button class="btn" type="submit" id="submitButton">
                                                        <i class="fa fa-lock"></i> submit
                                                    </button>

                                                    <!-- <a href="#">Submit</a> -->
                                                </tr>
                                            </table>
                                        </tr>
                                    </form>
                                </table>
                </td>
            </tr>
        </tbody>
    </table>
</body>

</html>