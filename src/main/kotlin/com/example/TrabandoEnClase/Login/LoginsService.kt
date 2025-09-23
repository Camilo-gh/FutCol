package com.example.TrabandoEnClase.Login

import org.springframework.beans.factory.annotation.Autowired
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

    fun obtenerLogins(): List<Login> {
        val sql = "SELECT * FROM login"
        return jdbcTemplate.query(sql, loginRowMapper)
    }

    fun agregarLogin(
        email: String,
        password: String
    ) {
        val sql = """
            INSERT INTO login (email, password, created_at, updated_at)
            VALUES (?, ?, NOW(), NOW())
        """.trimIndent()
        jdbcTemplate.update(sql, email, password)
    }

    fun actualizarLogin(
        id: Int,
        email: String,
        password: String
    ) {
        val sql = """
            UPDATE login
            SET email = ?, password = ?, updated_at = NOW()
            WHERE id = ?
        """.trimIndent()
        jdbcTemplate.update(sql, email, password, id)
    }

    fun eliminarLogin(id: Int) {
        val sql = "DELETE FROM login WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }
}