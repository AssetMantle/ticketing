// Hide submit button
$("#formSubmitButton").hide();

// Show/Hide Unmanaged Address & Password Screen
function showHideUnmanagedAddressModalScreen(showScreen, hideScreen) {
    $(hideScreen).hide();
    $("#staticBackdropLabel").text("Send Transaction");
    $("#modalSubtitle").text("Enter your password to send transaction");
    $(".toggleBtn").hide();
    $("#formSubmitButton").show();
    $(showScreen).show();
}

// Enable button on fill
function enableNavigationButton(pageNumber){
    if (pageNumber === 0) {
        let flag = 0;
        let unmanagedKeyName = document.getElementById("unmanagedKeyName");
        let unmanagedKeyAddress = document.getElementById("unmanagedKeyAddress");
        if ($.trim(unmanagedKeyName.value).length && ($.trim(unmanagedKeyName.value).length < 3 || $.trim(unmanagedKeyName.value).length > 50)) {
            $("#unmanagedKeyName").css("border-color", "var(--error)");
            $("#keyNameError").show(300);
            flag = 1;
        } else {
            $("#unmanagedKeyName").css("border-color", "var(--default)");
            $("#keyNameError").hide(300);
        }
        if ($.trim(unmanagedKeyAddress.value).length && $.trim(unmanagedKeyAddress.value).length !== 45) {
            $("#unmanagedKeyAddress").css("border-color", "var(--error)");
            $("#walletAddressError").show(300);
            flag = 1;
        } else {
            $("#unmanagedKeyAddress").css("border-color", "var(--default)");
            $("#walletAddressError").hide(300);
        }
        if ($.trim(unmanagedKeyName.value).length && $.trim(unmanagedKeyAddress.value).length && flag === 0) {
            $("#newUnmanagedAddressScreenBtn").removeClass("disable");
        } else {
            $("#newUnmanagedAddressScreenBtn").addClass("disable");
        }
    }
    else if(pageNumber === 1){
        let unmanagedMnemonicPassword = document.getElementById("unmanagedMnemonicPassword");

        if ($.trim(unmanagedMnemonicPassword.value).length < 5 || $.trim(unmanagedMnemonicPassword.value).length > 128) {
            $("#unmanagedMnemonicPassword").css("border-color", "var(--error)");
            $("#passwordError").show(300);
        }else {
            $("#unmanagedMnemonicPassword").css("border-color", "var(--default)");
            $("#passwordError").hide(300);
        }
    }
}