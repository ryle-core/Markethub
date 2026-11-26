
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

class AuthViewModel(
    private val navController: NavController,
    private val context: Context
) {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    // Use your actual Firebase Realtime Database URL.
    private val database: FirebaseDatabase =
        FirebaseDatabase.getInstance(
            "YOUR_REALTIME_DATABASE_URL"
        )

    companion object {
        private const val TAG = "MARKETHUB_AUTH"
    }

    // CHECK FIREBASE CONNECTION
    fun testFirebaseConnection() {

        Log.d(TAG, "PROJECT ID: ${mAuth.app.options.projectId}")
        Log.d(TAG, "APP ID: ${mAuth.app.options.applicationId}")

        database.reference.child("ConnectionTest")
            .setValue("Connected")
            .addOnSuccessListener {

                Log.d(TAG, "DATABASE CONNECTION SUCCESSFUL")

                Toast.makeText(
                    context,
                    "Firebase Connected Successfully!",
                    Toast.LENGTH_LONG
                ).show()
            }
            .addOnFailureListener { error ->

                Log.e(TAG, "DATABASE CONNECTION FAILED", error)

                Toast.makeText(
                    context,
                    "Database Error: ${error.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
    }

    // REGISTER USER
    fun signup(
        username: String,
        email: String,
        password: String,
        confirmpassword: String
    ) {

        if (
            username.isBlank() ||
            email.isBlank() ||
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

        if (password != confirmpassword) {

            Toast.makeText(
                context,
                "Passwords do not match",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        Log.d(TAG, "STARTING REGISTRATION")
        Log.d(TAG, "PROJECT ID: ${mAuth.app.options.projectId}")

        mAuth.createUserWithEmailAndPassword(
            email.trim(),
            password
        ).addOnCompleteListener { task ->

            if (!task.isSuccessful) {

                Log.e(TAG, "AUTHENTICATION FAILED", task.exception)

                Toast.makeText(
                    context,
                    "Registration Failed: ${task.exception?.message}",
                    Toast.LENGTH_LONG
                ).show()

                return@addOnCompleteListener
            }

            val firebaseUser = task.result.user

            if (firebaseUser == null) {

                Log.e(TAG, "FIREBASE USER IS NULL")
                return@addOnCompleteListener
            }

            val uid = firebaseUser.uid

            Log.d(TAG, "AUTHENTICATION SUCCESSFUL")
            Log.d(TAG, "USER UID: $uid")
            Log.d(TAG, "USER EMAIL: ${firebaseUser.email}")

            // CREATE USER PROFILE
            val userdata = User(
                username = username.trim(),
                email = email.trim(),
                uid = uid,
                role = "user"
            )

            // SAVE PROFILE TO REALTIME DATABASE
            database.getReference("Users")
                .child(uid)
                .setValue(userdata)
                .addOnCompleteListener { dbTask ->

                    if (dbTask.isSuccessful) {

                        Log.d(TAG, "USER PROFILE SAVED SUCCESSFULLY")

                        Toast.makeText(
                            context,
                            "Registration Successful!",
                            Toast.LENGTH_LONG
                        ).show()

                        navController.navigate(ROUT_HOME) {
                            popUpTo(ROUT_REGISTER) {
                                inclusive = true
                            }
                        }

                    } else {

                        Log.e(
                            TAG,
                            "USER PROFILE SAVE FAILED",
                            dbTask.exception
                        )

                        Toast.makeText(
                            context,
                            "Account created, but profile saving failed: ${dbTask.exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }
    }

    // LOGIN USER
    fun login(email: String, password: String) {

        if (email.isBlank() || password.isBlank()) {

            Toast.makeText(
                context,
                "Email and password cannot be blank",
                Toast.LENGTH_LONG
            ).show()

            return
        }

        mAuth.signInWithEmailAndPassword(
            email.trim(),
            password
        ).addOnCompleteListener { task ->

            if (task.isSuccessful) {

                val uid = task.result.user?.uid

                if (uid == null) {
                    Log.e(TAG, "LOGIN UID IS NULL")
                    return@addOnCompleteListener
                }

                database.getReference("Users")
                    .child(uid)
                    .get()
                    .addOnSuccessListener { snapshot ->

                        if (!snapshot.exists()) {

                            Log.e(TAG, "USER PROFILE NOT FOUND")

                            Toast.makeText(
                                context,
                                "User profile not found in database",
                                Toast.LENGTH_LONG
                            ).show()

                            return@addOnSuccessListener
                        }

                        val role = snapshot.child("role")
                            .getValue(String::class.java) ?: "user"

                        Toast.makeText(
                            context,
                            "Login Successful",
                            Toast.LENGTH_SHORT
                        ).show()

                        if (role == "admin") {

                            navController.navigate(ROUT_INTENT)

                        } else {

                            navController.navigate(ROUT_HOME)
                        }
                    }
                    .addOnFailureListener { error ->

                        Log.e(TAG, "USER FETCH FAILED", error)

                        Toast.makeText(
                            context,
                            "Database Error: ${error.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

            } else {

                Log.e(TAG, "LOGIN FAILED", task.exception)

                Toast.makeText(
                    context,
                    "Login Failed: ${task.exception?.message}",
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
