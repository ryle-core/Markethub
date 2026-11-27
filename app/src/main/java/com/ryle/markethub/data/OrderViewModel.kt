
package com.ryle.markethub.data

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.mutableStateListOf
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ryle.markethub.models.Order
import com.ryle.markethub.navigation.ROUT_VIEW_ORDER

class OrderViewModel(
    var navController: NavController,
    var context: Context
) {

    private val mAuth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()

    var ordersList = mutableStateListOf<Order>()

    // UPLOAD ORDER
    fun uploadOrder(
        productName: String,
        quantity: Int,
        price: Double,
        address: String
    ) {

        val uid = mAuth.currentUser?.uid

        if (uid == null) {
            Toast.makeText(
                context,
                "Please login first",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        if (productName.isBlank() || address.isBlank()) {
            Toast.makeText(
                context,
                "Please fill in all fields",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val orderRef = database.reference
            .child("Users")
            .child(uid)
            .child("Orders")
            .push()

        val orderId = orderRef.key ?: return

        val order = Order(
            orderId = orderId,
            userId = uid,
            productName = productName,
            quantity = quantity,
            price = price,
            address = address,
            status = "Pending"
        )

        orderRef.setValue(order)
            .addOnSuccessListener {

                Toast.makeText(
                    context,
                    "Order Uploaded Successfully",
                    Toast.LENGTH_LONG
                ).show()

                navController.navigate(ROUT_VIEW_ORDER)
            }
            .addOnFailureListener { error ->

                Toast.makeText(
                    context,
                    "Upload Failed: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }

    // FETCH ORDERS
    fun fetchOrders() {

        val uid = mAuth.currentUser?.uid

        if (uid == null) {
            Toast.makeText(
                context,
                "Please login first",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        val dbRef = database.reference
            .child("Users")
            .child(uid)
            .child("Orders")

        dbRef.get()
            .addOnSuccessListener { snapshot ->

                ordersList.clear()

                for (orderSnap in snapshot.children) {

                    val order = orderSnap.getValue(Order::class.java)

                    if (order != null) {
                        ordersList.add(order)
                    }
                }
            }
            .addOnFailureListener { error ->

                Toast.makeText(
                    context,
                    "Failed to fetch orders: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }
}
