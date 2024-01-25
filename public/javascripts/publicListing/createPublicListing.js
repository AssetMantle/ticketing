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

function setPublicListingNFTValue(e) {
    let fieldValue = e.target.value;
    let totalOwnedNFT = $("#collectionOwnedNFTs").text();
    $(`#PUBLIC_LISTING_NFT_NUMBER`).val(fieldValue);
    if (fieldValue > totalOwnedNFT) {
        $("#FORM_PUBLIC_LISTING_SUBMIT").addClass("disable");
    }
}

function setOwnedNFTs(){
    let maxNFTs = $("#collectionOwnedNFTs").text();
    $("#publicListingNFTNumber").val(maxNFTs);
    $("#PUBLIC_LISTING_NFT_NUMBER").val(maxNFTs);
}