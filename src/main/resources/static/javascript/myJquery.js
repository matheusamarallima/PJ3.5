$(document).ready(function(){

if($("#login")){
    $("#login").click(function(){
        $("loginForm").submit();
    });
}
if($("#register")){
    $("#register").click(function(){
        let flag = true;
        let message = "";
        if($("#userId").val() == ""){
            message += "User Id is Mandatory <br>" ;
            flag = false;
        }
        if($("#password").val() == ""){
                    message += "Password is Mandatory <br>" ;
                    flag = false;
                }
        if($("#name").val() == ""){
                            message += "name Id is Mandatory <br>" ;
                            flag = false;
                        }
        if($("#petName").val() == ""){
                            message += "Petname Id is Mandatory <br>" ;
                            flag = false;
                        }



        if(flag ){
            $("#registerForm").submit();

        }else{
            $("#error").html(message);
            return false;
        }

    });
}
});