/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function deleteProduct(productId) {
    if (confirm("Bạn chắc chắn xoá không") == true) {
        fetch(`/HutechWebDemo/product/${productId}`, {
            method: "delete",
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function(res) {
            console.info(res);
            if (res.status == 200) {
                let d = document.getElementById(`product${productId}`);
                d.style.display = "none";
            }
        })
    }
}


