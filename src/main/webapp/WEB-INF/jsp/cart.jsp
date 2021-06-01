<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Confirm Order</title>
      <link rel="stylesheet" href="style.css">
      <link href="https://fonts.googleapis.com/css?family=Oswald:400" rel="stylesheet">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
         integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
      <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
         integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
      <!-- jQuery first, then Popper.js, then Bootstrap JS -->
      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
         integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
         crossorigin="anonymous"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
         integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
         crossorigin="anonymous"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
         integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
         crossorigin="anonymous"></script>
      <style>
         @import url('https://fonts.googleapis.com/css2?family=Stint+Ultra+Condensed&display=swap');
         body {
         background-color: #222D32;
         }
         .mainDiv {
         padding: 2rem 1rem;
         margin-bottom: 2rem;
         /* background: white; */
         border-radius: 0.3rem;
         /* color: white; */
         background: white;
         border-radius: 15px;
         /* opacity: 85%; */
         margin-top: 100px;
         width: 1100px;
         }
         #heading {
         color: black;
         font-weight: bold;
         font-size: 42px;
         padding-bottom: 50px;
         }
         table {
         width: 1000px;
         font-size: 25px;
         }
         label {
         font-size: 27px;
         color: black;
         font-family: Roboto;
         display: block;
         margin-bottom: 5px;
         font-weight: bold;
         /* color: #0DB8DE; */
         }
         #submitButton {
         /* margin-left: 155px; */
         /* width: 500px; */
         background: linear-gradient(180deg, #0DB8DE, #27EF9F);
         outline: none !important;
         font-weight: bolder;
         font-size: 25px;
         border: none;
         box-shadow: none;
         border-radius: 10px;
         text-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
         /* padding: 10px 10px 10px 10px; */
         }

         .aboutUs,
        .logOut {
            font-size: 20px;
            font-weight: bold;
            color: white;

        }

        .navbarFixed {
            position: fixed;
            overflow: hidden;
            z-index: 50;
            background: black;

        }
        #submitButton {
            left: 24%;
            transform: translate(-50%, -50%);
            color: #222D32;
            text-decoration: none;
            display: inline-block;
            font-family: Roboto;
            text-transform: uppercase;
            border: 2px solid#27EF9F;
            transition: 0.02s 0.2s cubic-bezier(0.1, 0, 0.1, 1);
            width: 430px;
            margin-top: 20px;

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



      </style>
   </head>
   <body>
    
    
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


    
      <!-- form -->
      <div class="container">
         <div class="row">
            <div class="col-md-8">
               <div class="mainDiv">
                  <span class="display-8" id="heading">Your Order Summary</span>
                  <span class="logo"> <img src="https://trello-attachments.s3.amazonaws.com/60afcdd60446864934b83005/496x503/ebd357883d23eb3c14f0afe8609989f0/ROM.png" width="100" height="100" style="float: right;"></span>
                  <br><br><br><br>
                  <form method="POST" modelAttribute="paymentModel" action="/payment">
                     <div class="form-row">
                        <div class="col-md-8 mb-3">
                           <table border="0">
                              <tbody>
                                 <tr>
                                    <td>
                                       <label for="userName">Name: </label>
                                    </td>
                                    <td>
                                       <label for="userName">${request.userName}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="componentName">Component Name:</label>
                                    </td>
                                    <td>
                                       <label for="componentName">${request.componentName}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="processingCharge">Processing Charges: </label>
                                    </td>
                                    <td>
                                       <label for="processingCharge">${response.processingCharge}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="packagingAndDelivery">Packaging And Delivery Charges:
                                       </label>
                                    </td>
                                    <td>
                                       <label for="packagingAndDelivery">${response.packagingAndDeliveryCharge}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="contactNumber">Contact Number: </label>
                                    </td>
                                    <td>
                                       <label for="contactNumber">${request.contactNumber}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="dateOfDelivery">Date Of Delivery: </label>
                                    </td>
                                    <td>
                                       <label for="dateOfDelivery">${response.dateOfDelivery}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="isPriorityRequest">Is Priority Request:</label>
                                    </td>
                                    <td>
                                       <label for="isPriorityRequest">${request.isPriorityRequest}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="cardLimit">Card Limit:</label>
                                    </td>
                                    <td>
                                       <label for="cardLimit">${request.cardLimit}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td>
                                       <label for="quantity">Quantity:</label>
                                    </td>
                                    <td>
                                       <label for="quantity">${request.quantity}</label>
                                    </td>
                                 </tr>
                                 <tr>
                                    <td></td>
                                    <td><br></td>
                                 </tr>
                                 <input type="hidden" name="requestId" value="${response.requestId}" />
                                 <input type="hidden" name="processingCharge"
                                    value="${response.processingCharge}" />
                                 <input
                                    type="hidden" name="creditCardNumber"
                                    value="${request.creditCardNumber}" />
                                 <input type="hidden"
                                    name="cardLimit" value="${request.cardLimit}" />
                                 <!-- Alldiv ends -->
                                  <h2>${error}</h2> 
                                 <tr>
                                    <td></td>
                                    <td>
                                       <!-- <button type="submit" id="submitButton"></button> -->
                                       <button class="btn" type="submit" accesskey="P"  id="submitButton">
                                        <i class="fa fa-lock"></i> <U>P</U>AY AMOUNT</button>
                                    </td>
                                 </tr>
                              </tbody>
                           </table>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
   </body>
</html>