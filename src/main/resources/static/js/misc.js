/*jslint browser: true*/
(function (window) {

    "use strict";

    window.compareByText = function (a, b) {
        if (a.text === b.text) {
            return 0;
        }
        return (a.text > b.text) ? 1 : -1;
    };
}(window));