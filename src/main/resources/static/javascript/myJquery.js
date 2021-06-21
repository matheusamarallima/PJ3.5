$(document).ready(function() {

        if($("#login")) {
            $("#login").click(function() {
                $("loginForm").submit();
            }
            );
        }

        if($("#register")) {
            $("#register").click(function() {
                let flag = true;
                let message = "";

                if($("#userId").val() == "") {
                    message += "User Id is Mandatory <br>" ;
                    flag = false;
                }
                else {
                    let patt = /[A-Za-z]{6,10}/;
                    if(!patt.test($("#userId").val())) {
                        message += "User Id must be alphanumeric and should contain 6 - 10 character <br>";
                        flag = false;
                    }
                }

                if($("#password").val() == "") {
                    message += "Password is Mandatory <br>" ;
                    flag = false;
                }
                else {
                    let patt = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
                    if(!patt.test($("#password").val())) {
                        message += "Password must contain at least one number, one special character, one uppercase, one lowercase letter, one special char and should contain 8 - 16 characters <br>";
                        flag = false;
                    }
                }

                if($("#name").val() == "") {
                    message += "Name is Mandatory <br>" ;
                    flag = false;
                }
                else {
                    let patt = /[A-Za-z]{3,20}/;
                    if(!patt.test($("#name").val())) {
                        message += "Name must be at least 3 - 20 characters long, Name must contain letters only <br>";
                        flag = false;
                    }
                }

                if($("#petName").val() == "") {
                    message += "Pet name is Mandatory <br>" ;
                    flag = false;
                }
                else {
                    let patt = /[A-Za-z]{3,10}/;
                    if(!patt.test($("#petName").val())) {
                        message += "Pet Name must be at least 3 - 10 characters long <br>";
                        flag = false;
                    }
                }

                if($("#age").val() == "") {
                    message += "Age is Mandatory <br>" ;
                    flag = false;
                }
                else {
                    let patt = /(1[89]|[2-9][0-9]|1[01][0-9]|120)/;
                    if(!patt.test($("#age").val())) {
                        message += "Age should be greater than 18 and less than 120 <br>";
                        flag = false;
                    }
                }


                if(flag) {
                    $("#registerForm").submit();
                }
                else {
                     $("#error").html(message);
                     return false;
                }
            });
        }


    });