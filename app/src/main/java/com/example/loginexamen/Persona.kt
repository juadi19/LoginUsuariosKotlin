package com.example.loginexamen.model

import java.io.Serializable

data class Persona(val name: String, val lastName: String, val username: String, val password: String) : Serializable
