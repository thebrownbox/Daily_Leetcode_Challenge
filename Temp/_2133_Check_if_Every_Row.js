/**
 * @param {number[][]} matrix
 * @return {boolean}
 */
 var checkValid = function(a = [[]]) {
    const n = a.length;

    for (let col = 0; col < n; col++) {
        const count = {};
        for (let row = 0; row < n; row++) {
            count[a[row][col]] = true;
        }
        for (let x = 1; x <= n; x++) {
            if(!count[x]){
                return false;
            }            
        }
    }

    for (let row = 0; row < n; row++) {
        const count = {};
        for (let col = 0; col < n; col++) {
            count[a[row][col]] = true;
        }
        for (let x = 1; x <= n; x++) {
            if(!count[x]){
                return false;
            }            
        }
    }

    return true;
};