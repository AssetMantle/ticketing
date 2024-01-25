window.onbeforeunload = function () {
    if ($("#createdCollectionsPerPage").length !== 0) {
        window.scrollTo(0, 0);
    }
}
document.onload = function () {
    if ($("#createdCollectionsPerPage").length !== 0) {
        window.scrollTo(0, 0);
    }
}

function loadMoreCollections(accountId) {
    const loading = document.querySelector('.loading');
    if ($("#noCreatedCollectionsPerPage").length === 0) {
        let nextPageNumber = Math.ceil(($('.singleCreatedCollection').length - 1) / 6 + 1);
        let route = jsRoutes.controllers.CollectionController.createdCollectionPerPage(accountId, nextPageNumber);
        $.ajax({
            url: route.url,
            type: route.type,
            async: true,
            beforeSend: function () {
                loading.classList.add('show');
            },
            complete: function () {
                loading.classList.remove('show');
            },
            statusCode: {
                200: function (data) {
                    $('.createdCollectionsPerPage').append(data);
                }
            }
        });
    } else {
        $(".collectionPage.createdCollectionsPerPage:last").css("margin-top", "0px");
    }
}

timeout = 0;

function loadCreatedCollectionOnScroll(accountId) {
    clearTimeout(timeout);
    timeout = setTimeout(function () {
        if ($(window).scrollTop() >= ($(document).height() - $(window).height() - 100)) {
            if ($("#noCreatedCollectionsPerPage").length === 0) {
                loadMoreCollections(accountId);
            }
        }
    }, 300);
}

function loadFirstCreatedCollections(accountId){
    loadMoreCollections(accountId);
    if($(document).height() > 900){
        loadCreatedCollectionOnScroll(accountId);
    }
}