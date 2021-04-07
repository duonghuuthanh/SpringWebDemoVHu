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

function addToCart(productId) {
    fetch(`/HutechWebDemo/api/cart/${productId}`).then(res => {
        if (res.status == 200) {
            let d = document.getElementById("cart-quantity");
            d.innerText = parseInt(d.innerText) + 1;
        } else {
            alert("Something wrong!!!");
        }
    });
}

function saveCart() {
    fetch("/HutechWebDemo//api/cart/", {
        method: "post",
        headers: {
            "Content-Type": "application/json"
        }
    }).then(res => {
        if (res.status == 201) {
            location.reload();
        } else {
            alert("Something wrong!!!");
        }
    })
}


