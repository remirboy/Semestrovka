function valid(form){
    var fail=false;
    var email = form.email.value;
    var pass = form.password.value;
    var Repass = form.Repassword.value;
    var checkbox = form.checkbox.value;
    console.log(checkbox)
    if (email=='') {
        fail="Введите свой email";
    }
    else if (pass==''||pass==' ') {
        fail="Придумайте пароль";
    }
    else if (Repass!=pass) {
        fail="Пароли не совпадают";
    }
    else if (checkbox=='') {
        fail = "Подтвердите согласие на обработку персональных данных";
    }
    if (fail) {
        alert(fail);
    }
}