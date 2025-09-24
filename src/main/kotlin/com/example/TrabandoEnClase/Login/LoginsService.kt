package com.example.TrabandoEnClase.Login

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service

@Service
class LoginsService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    private val loginRowMapper = RowMapper { rs, _ ->
        Login(
            id = rs.getInt("id"),
            email = rs.getString("email"),
            password = rs.getString("password")
        )
    }

    // Solo permitir estos dos correos:
    private val correosPermitidos = setOf("admin@torneo.com", "capitan@torneo.com")

    /**
     * Devuelve el Login si las credenciales son válidas y el email está permitido; si no, null.
     */
    fun autenticar(email: String, password: String): Login? {
        if (email !in correosPermitidos) return null

        val sql = """
            SELECT id, email, password
            FROM login
            WHERE email = ? AND password = ?
            LIMIT 1
        """.trimIndent()

        return try {
            jdbcTemplate.query(sql, loginRowMapper, email, password).firstOrNull()
        } catch (e: EmptyResultDataAccessException) {
            null
        }
    }
}