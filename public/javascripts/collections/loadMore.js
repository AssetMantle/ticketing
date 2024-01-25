window.onbeforeunload = function () {
    if ($(".collectionsPerPage").length !== 0) {
        window.scrollTo({ top:0, left:0, behavior: "instant"});
    }
}
document.onload = function () {
    if ($(".collectionsPerPage").length !== 0) {
        window.scrollTo({ top:0, left:0, behavior: "instant"});
    }
}

function loadMoreCollections() {
    if ($(".noCollection").length === 0) {
        let showAll = true;
        let route = jsRoutes.controllers.CollectionController.collectionsPerPage($(".collectionPage").length + 1, showAll);
        let loadMore = $("#collectionsPerPage");
        let loading = document.querySelector('.loading');
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
                    loadMore.append(data);
                }
            }
        });
    }
}

timeout = 0;

function loadCollectionOnScroll() {
    clearTimeout(timeout);
    timeout = setTimeout(function () {
        if ($(window).scrollTop() >= ($(document).height() - $(window).height() - 100)) {
            if ($(".noCollection").length === 0) {
                loadMoreCollections();
            }
        }
    }, 300);
}

function loadFirstCollections() {
    loadMoreCollections();
    if ($(document).height() > 900) {
        setTimeout(loadMoreCollections, 1000);
    }
}