package Classes;

import Strategy.IBancoDados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;


public class Curso {
    private IBancoDados bancoDados;

    private String nomecurso;
    private int cargahorariacurso;
    private float valorcurso;
    private String descricaocurso;
    private String publicoalvo;

    public String getNomecurso() { return nomecurso; }
    public void setNomecurso(String nomecurso) { this.nomecurso = nomecurso; }
    public int getCargahorariacurso() { return cargahorariacurso; }
    public void setCargahorariacurso(int cargahorariacurso) { this.cargahorariacurso = cargahorariacurso; }
    public float getValorcurso() { return valorcurso; }
    public void setValorcurso(float valorcurso) { this.valorcurso = valorcurso; }
    public String getDescricaocurso() { return descricaocurso; }
    public void setDescricaocurso(String descricaocurso) { this.descricaocurso = descricaocurso; }
    public String getPublicoalvo(){return publicoalvo;}
    public void setPublicoalvo(String publicoalvo){this.publicoalvo = publicoalvo;}

    public Curso(IBancoDados bancoDados){
        this.bancoDados = bancoDados;
    }

    public Curso(String nomecurso, int cargahorariacurso, float valorcurso, String descricaocurso, String publicoalvo){
        this.nomecurso = nomecurso;
        this.cargahorariacurso = cargahorariacurso;
        this.valorcurso = valorcurso;
        this.descricaocurso = descricaocurso;
        this.publicoalvo = publicoalvo;
    }
    public void setBanco(IBancoDados banco) {
        this.bancoDados = banco;
    }

    public void InserirCurso() {
        String sql = String.format(java.util.Locale.US,
                "INSERT INTO curso (nomecurso, cargahorariacurso, valorcurso, descricaocurso, publicoalvo)" +
                        " VALUES ('%s', %d, %.2f, '%s', '%s')",
                nomecurso, cargahorariacurso, valorcurso, descricaocurso, publicoalvo
        );
        bancoDados.Execute(sql);
    }

    public List<Curso> ConsultarCursos() {
        String sql = "SELECT * FROM curso";
        List<Curso> lista = new ArrayList<>();

        try {
            ResultSet rs = bancoDados.Select(sql);
            while (rs != null && rs.next()) {
                Curso c = new Curso(this.bancoDados);
                c.setNomecurso(rs.getString("nomecurso"));
                c.setCargahorariacurso(rs.getInt("cargahorariacurso"));
                c.setValorcurso(rs.getFloat("valorcurso"));
                c.setDescricaocurso(rs.getString("descricaocurso"));
                c.setPublicoalvo(rs.getString("publicoalvo"));
                lista.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao consultar cursos: " + e.getMessage());
        }

        return lista;
    }
}
