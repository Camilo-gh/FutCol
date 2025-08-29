package.org.example.TrabandoEnClase


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Service
import java.sql.ResultSet

@Service
class TorneosService {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    private val rowMapper = RowMapper<Torneo> { rs: ResultSet, _: Int ->
        Torneo(
            id = rs.getInt("id"),
            nombre = rs.getString("nombre"),
            fecha_Inicio = rs.getDate("fecha_inicio"),
            fecha_Fin = rs.getDate("fecha_fin"),
            categoria = rs.getString("categoria"),
            modalidad = rs.getString("modalidad"),
            organizador = rs.getString("organizador"),
            precio = rs.getDouble("precio"),
            sedes = rs.getString("sedes"),
        )
    }

    fun obtenerTorneos(): List<Torneo> {
        val sql = "SELECT * FROM torneos"
        return jdbcTemplate.query(sql, rowMapper)
    }

    fun agregarTorneo(torneo: Torneo) {
        val sql = """
            INSERT INTO torneos 
            (nombre, fecha_inicio, fecha_fin, categoria, modalidad, organizador, precio, sedes, created_at, updated_at)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, NOW(), NOW())
        """.trimIndent()

        jdbcTemplate.update(
            sql,
            torneo.nombre,
            torneo.fecha_Inicio,
            torneo.fecha_Fin,
            torneo.categoria,
            torneo.modalidad,
            torneo.organizador,
            torneo.precio,
            torneo.sedes
        )
    }

    fun actualizarTorneo(torneo: Torneo) {
        val sql = """
            UPDATE torneos 
            SET nombre = ?, fecha_inicio = ?, fecha_fin = ?, categoria = ?, modalidad = ?, organizador = ?, precio = ?, sedes = ?, updated_at = NOW()
            WHERE id = ?
        """.trimIndent()

        jdbcTemplate.update(
            sql,
            torneo.nombre,
            torneo.fecha_Inicio,
            torneo.fecha_Fin,
            torneo.categoria,
            torneo.modalidad,
            torneo.organizador,
            torneo.precio,
            torneo.sedes,
            torneo.id
        )
    }

    fun eliminarTorneo(id: Int) {
        val sql = "DELETE FROM torneos WHERE id = ?"
        jdbcTemplate.update(sql, id)
    }
}