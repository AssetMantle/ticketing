function onCollectionSelect(nftId) {
    let route = jsRoutes.controllers.CollectionController.countForCreatorNotForSale(nftId);
    $.ajax({
        url: route.url,
        type: route.type,
        async: true,
        statusCode: {
            200: function (data) {
                $('#collectionOwnedNFTs').html(data);
            },
            400: function (data) {
                console.log(data.responseText);
            },
        }
    });
}

function setSaleNFTValue(e) {
    let fieldValue = e.target.value;
    let totalOwnedNFT = $("#collectionOwnedNFTs").text();
    $(`#SALE_NFT_NUMBER`).val(fieldValue);
    if (fieldValue > totalOwnedNFT) {
        $("#FORM_COLLECTION_SALE_SUBMIT").addClass("disable");
    }
}

if ($("#SELECT_WHITELIST_ID").val() !== "") {
    let whitelistId = $("#SELECT_WHITELIST_ID").val();
    let selectedWhitelist =  $(`#SELECT_WHITELIST_ID option[value=${whitelistId}]`).text();
    $("#SELECT_WHITELIST_ID").closest("div").find(".custom-select-trigger").text(selectedWhitelist);
}

function setOwnedNFTs(){
    let maxNFTs = $("#collectionOwnedNFTs").text();
    $("#saleNFTNumber").val(maxNFTs);
    $("#SALE_NFT_NUMBER").val(maxNFTs);
}