
package com.ryle.markethub.data

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.ryle.markethub.models.User
import com.ryle.markethub.navigation.ROUT_HOME
import com.ryle.markethub.navigation.ROUT_INTENT
import com.ryle.markethub.navigation.ROUT_REGISTER
import com.ryle.markethub.navigation.ROUT_UPLOAD_ORDER
import com.ryle.markethub.navigation.ROUT_VIEW_ORDER

class AuthViewModel(
    private val navController: NavController,
    private val context: Context
) {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    // Replace this with your actual Firebase Realtime Database URL.
    private val database: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance(
            "https://markethub-d9da9-default-rtdb.firebaseio.com/"
        )
    }

    companion object {
        private const val TAG = "MARKETHUB_AUTH"
    }

    // REGISTER USER
    fun signup(
        username: String,
        email: String,
        password: String,
        confirmpassword: String
    ) {

        val cleanUsername = username.trim()
        val cleanEmail = email.trim()

        // Validate fields
        if (
            cleanUsername.isBlank() ||
            cleanEmail.isBlank() ||
            password.isBlank() ||
            confirmpassword.isBlank()
        ) {
            Toast.makeText(
                context,
                "Please fill in all fields",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        // Validate email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(cleanEmail).matches()) {
            Toast.makeText(
                context,
                "Enter a valid email address",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        // Validate password
        if (password.length < 6) {
            Toast.makeText(
                context,
                "Password must contain at least 6 characters",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        // Confirm password
        if (password != confirmpassword) {
            Toast.makeText(
                context,
                "Passwords do not match",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        Log.d(TAG, "Starting registration")

        // Firebase Authentication
        mAuth.createUserWithEmailAndPassword(
            cleanEmail,
            password
        ).addOnCompleteListener { task ->

            if (!task.isSuccessful) {

                Log.e(TAG, "Registration failed", task.exception)

                Toast.makeText(
                    context,
                    "Registration failed: ${task.exception?.localizedMessage}",
                    Toast.LENGTH_LONG
                ).show()

                return@addOnCompleteListener
            }

            val firebaseUser = task.result.user

            if (firebaseUser == null) {

                Log.e(TAG, "Firebase user is null")

                Toast.makeText(
                    context,
                    "Unable to retrieve registered user",
                    Toast.LENGTH_LONG
                ).show()

                return@addOnCompleteListener
            }

            val uid = firebaseUser.uid

            Log.d(TAG, "Authentication successful: $uid")

            // Create user profile
            val userdata = User(
                username = cleanUsername,
                email = cleanEmail,
                uid = uid,
                role = "user"
            )

            // Save user to Firebase Realtime Database
            database.getReference("Users")
                .child(uid)
                .setValue(userdata)
                .addOnSuccessListener {

                    Log.d(TAG, "User profile saved successfully")

                    Toast.makeText(
                        context,
                        "Registration successful!",
                        Toast.LENGTH_LONG
                    ).show()

                    navController.navigate(ROUT_HOME) {
                        popUpTo(ROUT_REGISTER) {
                            inclusive = true
                        }
                    }
                }
                .addOnFailureListener { error ->

                    Log.e(TAG, "Database saving failed", error)

                    Toast.makeText(
                        context,
                        "Account created, but profile saving failed: ${error.localizedMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
        }
    }

    // LOGIN USER
    fun login(email: String, password: String) {

        val cleanEmail = email.trim()

        if (cleanEmail.isBlank() || password.isBlank()) {

            Toast.makeText(
                context,
                "Email and password cannot be blank",
                Toast.LENGTH_LONG
            ).show()

            return
        }

        mAuth.signInWithEmailAndPassword(
            cleanEmail,
            password
        ).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val uid = task.result.user?.uid

                if (uid == null) {
                    Log.e(TAG, "Login UID is null")
                    return@addOnCompleteListener
                }

                database.getReference("Users")
                    .child(uid)
                    .get()
                    .addOnSuccessListener { snapshot ->

                        if (!snapshot.exists()) {

                            Toast.makeText(
                                context,
                                "User profile not found",
                                Toast.LENGTH_LONG
                            ).show()

                            return@addOnSuccessListener
                        }

                        val role = snapshot.child("role")
                            .getValue(String::class.java) ?: "user"

                        Toast.makeText(
                            context,
                            "Login successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        if (role == "admin") {
                            navController.navigate(ROUT_VIEW_ORDER)
                        } else {
                            navController.navigate(ROUT_UPLOAD_ORDER)
                        }
                    }
                    .addOnFailureListener { error ->

                        Log.e(TAG, "Database fetch failed", error)

                        Toast.makeText(
                            context,
                            "Database error: ${error.localizedMessage}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

            } else {

                Log.e(TAG, "Login failed", task.exception)

                Toast.makeText(
                    context,
                    "Login failed: ${task.exception?.localizedMessage}",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    // LOGOUT
    fun logout() {

        mAuth.signOut()

        navController.navigate(ROUT_HOME) {
            popUpTo(ROUT_HOME) {
                inclusive = true
            }
        }
    }

    // CHECK LOGIN STATUS
    fun isLoggedIn(): Boolean {
        return mAuth.currentUser != null
    }
}
