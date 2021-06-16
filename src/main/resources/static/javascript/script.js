const userId = document.getElementById('userId');
const password = document.getElementById('password');
const registerForm = document.getElementById('registerForm');

console.log("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");



function testeType(userId, password, name, petName, age){
    var pattUserId = new RegExp("[A-Za-z\d\.]{6,10}");
    var pattPassword = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$");
    var pattName = new RegExp("[A-Za-z\d\.]{3,20}");
    var pattPetName = new RegExp("[A-Za-z]*{3,10}");
    var pattAge = new RegExp("[1-9][0-9]{0,2}");

    var check1 = pattUser.exec(userId);
    var check2 = pattPassword.exec(password);
    var check3 = pattName.exec(name);
    var check4 = pattName.exec(petName);
    var check5 = pattName.exec(age);

    if (!check1 && !check2 && !check3 && !check4 && !check5) {
        console.error('Errou');
        window.location.href ="http://localhost:8080/registration"
      } else {
        console.log('acertou mizeravi');
      }
    }




//
//
//document.getElementByClassName("extenso").innerHTML = "qualqer";
//registerForm.addEventListener('register', (e) => {
//    let messages = []
//    if(password.value.length <= 6){
//        messages.push('Password must be..');
//    }
//})