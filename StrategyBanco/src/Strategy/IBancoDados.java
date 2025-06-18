package Strategy;
import java.sql.ResultSet;

public interface IBancoDados {

    public void Instancia();
    public void Execute(String sql);
    public ResultSet Select(String sql);

}
