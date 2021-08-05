"use strict";
exports.__esModule = true;
/**
 * Array forEach
 */
function forEach(arr, callback, thisObj) {
    if (arr == null) {
        return;
    }
    var i = -1;
    var len = arr.length;
    while (++i < len) {
        // we iterate over sparse items since there is no way to make it
        // work properly on IE 7-8. see #64
        if (callback.call(thisObj, arr[i], i, arr) === false) {
            break;
        }
    }
}
exports["default"] = forEach;
