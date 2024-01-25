reCaptchaFlag = false;

function showPassword() {
    let password = $('#signInPassword')[0];
    if (password.type === "password") {
        password.type = "text";
        $(".closeEye").addClass("hidden");
        $(".openEye").removeClass("hidden");
    } else {
        password.type = "password";
        $(".closeEye").removeClass("hidden");
        $(".openEye").addClass("hidden");
    }
}

function activeButton() {
    let signInUsername = $("#signInUsername").val();
    let signInPassword = $("#signInPassword").val();
    if (signInUsername !== "" && signInPassword !== "" && reCaptchaFlag) {
        $("#FORM_SIGN_IN_WITH_CALLBACK_SUBMIT").removeClass("disable");
    } else {
        $("#FORM_SIGN_IN_WITH_CALLBACK_SUBMIT").addClass("disable");
    }
}

$("#signInUsername, #signInPassword").on("input", function () {
    activeButton();
});

function signInCheckBeforeSubmit() {
    return reCaptchaFlag;
}

const onSubmit = function (token) {
    reCaptchaFlag = true;
    activeButton();
};

<!-- Google reCaptcha -->
function CaptchaCallback() {
    if ($('#myRecaptcha').length) {
        grecaptcha.render('myRecaptcha', {'sitekey': '6LfhFrwnAAAAAKKOVgEAdCHHtgalQj0PosHPn8Xu', 'callback': onSubmit});
    }
}

$(document).ready(function () {
    $('#FORM_SIGN_IN_WITH_CALLBACK_SUBMIT').addClass("disable");
})